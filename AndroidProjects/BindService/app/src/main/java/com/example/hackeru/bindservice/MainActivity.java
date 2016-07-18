package com.example.hackeru.bindservice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private int counter;
    private Button btn;
    private TextView textView;
    private SeekBar seekBar;
    private boolean playing = false;
    private boolean isBinded;
    private PlayMusicService playService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PlayMusicService.MyBinder binder = (PlayMusicService.MyBinder) service;
            playService = binder.getService();
            isBinded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBinded = false;
        }
    };
    private BroadcastReceiver songEndedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            songEnded();
        }
    };

    public void updateSeekBar(int progress){
        Log.d("Maayan", "The progress is: " + progress);
        seekBar.setProgress(progress);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        btn.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);

    }



    public void addToCounter(View view) {
        seekBar.setProgress(counter += 20);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, PlayMusicService.class);
        intent.putExtra("SONG", R.raw.song);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        registerReceiver(songEndedReceiver, new IntentFilter("99fm"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(serviceConnection);
        unregisterReceiver(songEndedReceiver);
    }

    private void songEnded(){
        btn.setText("START");
        seekBar.setProgress(0);
    }

    @Override
    public void onClick(View v) {
        if (!playing){
            // start playing...
            btn.setText("STOP");
            playService.setListener(this);
            playService.startPlaying();
            Toast.makeText(this, "nice song...", Toast.LENGTH_LONG).show();
        }else{
            // stop playing...
            btn.setText("START");
            playService.pausePlaying();
        }
        playing = !playing;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.d("Maayan", seekBar.getProgress() + "");
        playService.updateSongTime(seekBar.getProgress());
    }
}
