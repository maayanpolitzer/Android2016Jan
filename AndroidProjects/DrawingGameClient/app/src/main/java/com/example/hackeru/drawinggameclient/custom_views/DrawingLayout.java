package com.example.hackeru.drawinggameclient.custom_views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hackeru.drawinggameclient.threads.SendImageThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by hackeru on 17/08/2016.
 */
public class DrawingLayout extends View {

    private Paint paint = new Paint();
    private Paint circlePaint = new Paint();
    private Path path = new Path();
    private Path circlePath = new Path();
    public LinearLayout parentLayout;
    public LinearLayout.LayoutParams params;
    private Context context;

    public DrawingLayout(Context context){
        super(context);

        this.context = context;

        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(10f);

        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.RED);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeJoin(Paint.Join.MITER);
        circlePaint.setStrokeWidth(5f);

        parentLayout = new LinearLayout(context);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setBackgroundColor(Color.WHITE);

        Button btn = new Button(context);
        btn.setText("Share image");
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDrawing();
            }
        });
        parentLayout.addView(btn);
    }

    private void saveDrawing() {
        setDrawingCacheEnabled(true);
        buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(getDrawingCache());
        String fileName = "myImage.png";
        try {
            FileOutputStream out = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            Log.d("TAG", "DONE!");
            new SendImageThread(context, fileName).start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);
                break;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
                circlePath.reset();
                circlePath.addCircle(pointX, pointY, 40f, Path.Direction.CW);
                break;

            case MotionEvent.ACTION_UP:
                circlePath.reset();
                break;
        }
        invalidate();   // call a method that will draw on the layout(canvas).
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
        canvas.drawPath(circlePath, circlePaint);
    }
}
