package florin.lccc.drawings2017;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by uc224 on 3/7/17.
 */

public class OurTouchListener implements View.OnTouchListener {

    OurView theView;
    Dots mDots;
    OurTouchListener(OurView theView, Dots dots)
    {
        this.theView=theView;
        mDots=dots;
    }

    public OurTouchListener(OurView theView) {
    }

    public boolean onTouch(View v, MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                //move finger over screen
                for(int i=0, n=event.getHistorySize(); i<n; i++)
                {
                   // Dot theDot=new Dot(event.getHistoricalX(i), event.getHistoricalY(i), Color.BLACK, 30);
                }
                break;
            case MotionEvent.ACTION_DOWN:
                //press finger on screen
                Dot theDot=new Dot(event.getX(), event.getY(), Color.BLUE, 30);
                theView.setDots(mDots);
                theView.invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //release finger from screen
                break;
            default:
                return false;
        }
        return true;
    }
}
