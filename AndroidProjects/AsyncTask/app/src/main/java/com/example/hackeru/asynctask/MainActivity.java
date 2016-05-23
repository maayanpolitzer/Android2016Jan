package com.example.hackeru.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        new MyAsyncTask().execute();

    }




    private class MyAsyncTask extends AsyncTask<Integer, Integer, Void>{

        @Override
        protected Void doInBackground(Integer... params) {
            // NOT the main thread...
            Log.d("Maayan", "doInBackground()");
            for (int i = 0; i < 100; i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... kevin) {
            //super.onProgressUpdate(values);
            textView.setText(kevin[0] + "");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("Maayan", "onPostExecute()");
        }
    }

}
