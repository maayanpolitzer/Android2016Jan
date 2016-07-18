package com.example.hackeru.bindservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by hackeru on 17/07/2016.
 */
public class PlayMusicService extends Service implements MediaPlayer.OnCompletionListener {

    private MediaPlayer player;
    private IBinder binder = new MyBinder();
    private MainActivity activity;
    private boolean isWorking;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        player = MediaPlayer.create(this, intent.getIntExtra("SONG", -1));
        player.setOnCompletionListener(this);
        Log.d("Maayan", player.getDuration() + "");
        return binder;
    }

    public void setListener(MainActivity activity){
        this.activity = activity;
    }

    public void startPlaying(){
        isWorking = true;
        player.start();
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isWorking){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            activity.updateSeekBar((player.getCurrentPosition() * 100) / player.getDuration());
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public void pausePlaying(){
        isWorking = false;
        player.pause();
    }

    public void updateSongTime(int progress){
        player.seekTo(progress * (player.getDuration() / 100));
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        isWorking = false;
        sendBroadcast(new Intent("99fm"));
    }

    public class MyBinder extends Binder {
        public PlayMusicService getService(){
            return PlayMusicService.this;
        }
    }

    public int sum(int x, int y){
        return x + y;
    }
}
