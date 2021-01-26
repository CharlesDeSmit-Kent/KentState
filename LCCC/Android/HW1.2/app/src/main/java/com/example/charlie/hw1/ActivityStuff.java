package com.example.charlie.hw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.Random;


public class ActivityStuff extends View {

    Paint ourPaint;
    public ActivityStuff(Context context)
    {
        super(context);
        ourPaint=new Paint();

    }
    protected void onDraw(Canvas canvas)
    {
        canvas.drawRGB(255,255,255);
        ourPaint.setColor(Color.RED);
        ourPaint.setStrokeWidth(2);
        canvas.drawLine(0,0,canvas.getWidth()-1,canvas.getHeight()-1,ourPaint);

        ourPaint.setStyle(Paint.Style.STROKE);
        ourPaint.setStrokeWidth(10);
        ourPaint.setColor(0xff00ff00);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2,40,ourPaint);

        ourPaint.setStyle(Paint.Style.FILL);
        ourPaint.setColor(0x770000ff);
        canvas.drawRect(100,100,200,200,ourPaint);
        invalidate();
    }
}
