package com.example.hackeru.drawinggameclient.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by hackeru on 17/08/2016.
 */
public class DrawingLayout extends View {

    private Paint paint = new Paint();
    private Paint circlePaint = new Paint();
    private Path path = new Path();
    private Path circlePath = new Path();

    public DrawingLayout(Context context){
        super(context);

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
