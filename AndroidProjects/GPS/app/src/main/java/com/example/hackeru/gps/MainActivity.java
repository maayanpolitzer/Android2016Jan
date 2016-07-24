package com.example.hackeru.gps;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager manager;
    private String provider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = manager.getBestProvider(criteria, false);

        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Log.d("Maayan", "GPS PROVIDER ENABLED!!!");
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("GPS is disabled")
                    .setMessage("Please turn on your GPS")
                    .setIcon(android.R.drawable.ic_dialog_map)
                    .setPositiveButton("Settings", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .create().show();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.requestLocationUpdates(provider, 1000, 10, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void getLocation(View view) {

        Location location = manager.getLastKnownLocation(provider);
        Log.d("Maayan", "The best provider is: " + provider);
        if (location != null){
            Log.d("Maayan", location.toString());
        }else{
            Log.d("Maayan", "It's null!");
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("Maayan", "Location changed: " + location.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch(status){
            case LocationProvider.AVAILABLE:
                Log.d("Maayan", "status available");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("Maayan", "status out of service");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("Maayan", "status temporarily unavailable");
                break;
        }
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Maayan", "Provider: " + provider + " is enabled!");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Maayan", "Provider: " + provider + " is disabled!");
    }
}
