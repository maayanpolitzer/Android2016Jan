package com.example.maayanpolitzer.gestures;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public static final int MARGIN_LEFT = 0;
    public static final int MARGIN_TOP = 0;
    public static final int MARGIN_RIGHT = 900;
    public static final int MARGIN_BOTTOM = 1750;
    private final int BALL_SIZE = 150;
    private GestureDetectorCompat mDetector;
    private ImageView ball;
    private RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(BALL_SIZE, BALL_SIZE);
    private RelativeLayout mainLayout;
    private int x;
    private int y;

    private boolean dragging;

    private float vX;
    private float vY;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        ball = new ImageView(this);
        ball.setImageResource(R.drawable.ball);
        mainLayout.addView(ball, params);

        handler = new Handler();

        mDetector = new GestureDetectorCompat(this, this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                if (event.getX() >= x && event.getX() <= x + BALL_SIZE &&
                        event.getY() >= y && event.getY() <= y + BALL_SIZE){
                    dragging = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (dragging) {
                    x = (int) event.getX();
                    y = (int) event.getY();
                    params.setMargins(x, y, 0, 0);
                    ball.setLayoutParams(params);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;

        }
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
     //   Log.d("TAG", "onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    //    Log.d("TAG", "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
    //    Log.d("TAG", "onSingleTagUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //Log.d("TAG", "onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
     //   Log.d("TAG", "onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, final float velocityX, final float velocityY) {
        if (dragging) {
            dragging = false;
            Log.d("TAG", "onFling");
            vX = velocityX * 0.01f; // ball power
            vY = velocityY * 0.01f; //
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (vX != 0f && vY != 0f) {
                        x += vX;
                        y += vY;
                        vX *= 0.93; // stop power
                        vY *= 0.93;
                        if (Math.abs(vX) < 0.02) {  // stop condition
                            vX = 0;
                        }
                        if (Math.abs(vY) < 0.02) {  // stop condition
                            vY = 0;
                        }
                        if (x <= MARGIN_LEFT || x >= MARGIN_RIGHT) {
                            if (x <= MARGIN_LEFT) {
                                x = MARGIN_LEFT;
                            } else {
                                x = MARGIN_RIGHT;
                            }
                            vX *= -1;
                        }
                        if (y <= MARGIN_TOP || y >= MARGIN_BOTTOM) {
                            if (y <= MARGIN_TOP) {
                                y = MARGIN_TOP;
                            } else {
                                y = MARGIN_BOTTOM;
                            }
                            vY *= -1;
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                params.setMargins((int) Math.round(x), (int) Math.round(y), 0, 0);
                                ball.setLayoutParams(params);
                            }
                        });
                        try {
                            Thread.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            return true;
        }
        return false;
    }
}














