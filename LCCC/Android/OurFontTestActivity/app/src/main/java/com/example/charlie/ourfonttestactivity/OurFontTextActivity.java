package com.example.charlie.ourfonttestactivity;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class OurFontTextActivity extends AppCompatActivity {
    class RenderView extends View     {
        Paint paint;
        Typeface font;
        Rect bounds=new Rect();
    public RenderView(Context context)         {
        super(context);
        paint=new Paint();
        font=Typeface.createFromAsset(context.getAssets(), "galaxy_1.ttf");
    }
        protected void onDraw(Canvas canvas)         {
            canvas.drawRGB(0,0,0);
            paint.setColor(Color.YELLOW);
            paint.setTypeface(font);
            paint.setTextSize(50);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("blah blah text", canvas.getWidth()/2,100,paint);
            String text="some more blah text";
            paint.setColor(Color.WHITE);
            paint.setTextSize(60);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(text, 0, text.length(), bounds);
            canvas.drawText(text, canvas.getWidth()-bounds.width(), 240, paint);
            invalidate();         }
    }
    @Override     public void onCreate(Bundle savedInstanceState)
    {         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_font_text);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new RenderView(this));
    }
}
