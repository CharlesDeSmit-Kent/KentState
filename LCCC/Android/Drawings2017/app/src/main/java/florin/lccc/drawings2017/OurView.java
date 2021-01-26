package florin.lccc.drawings2017;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by fmuscuta on 2/27/17.
 */

public class OurView extends View {

    //Dot ourDot;
    Dots theDots;
    int theHight;
    int theWidth;

    public OurView(Context context, int h, int w) {
        super(context);
        theHight = h;
        theWidth = w;
        setMinimumHeight(theHight);
        setMinimumWidth(theWidth);
    }

    /*public void setDot(Dot adot)
    {
        ourDot=adot;
    }*/
    public void setDots(Dots dots)
    {
        theDots=dots;
    }
    @Override
    protected  void onMeasure(int withMeasureSpec, int heightMesureSpec)
    {
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());

    }

    protected void onDraw(Canvas canvas) {
        //this is where we actually do the graphic drawing
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

      //if (ourDot!=null) {
        for (Dot ourDot: theDots.getDots()){
           paint.setColor(ourDot.getColor());
           canvas.drawCircle(ourDot.getX(),ourDot.getY(),ourDot.getDiameter(),paint);
        }


    }
}

