package com.example.charlie.project1;

/**
 * Created by Charlie on 4/30/2017.
 */
import android.view.MotionEvent;
import android.view.View;



public class ClassOurTouchListener implements View.OnTouchListener {

    ClassPaddle CDpaddle;
    public ClassOurTouchListener( ClassPaddle CDaPaddle)

    {
        CDpaddle=CDaPaddle;
    }
    public  boolean onTouch(View CDv, MotionEvent CDevent)
    {
        switch(CDevent.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                for (int i=0, n=CDevent.getHistorySize();i<n; i++)
                {
                    CDpaddle.CDtouchX=CDevent.getHistoricalX(i);
                    CDpaddle.CDtouchY=CDevent.getHistoricalY(i);
                }
                break;

            case MotionEvent.ACTION_DOWN:
            {
                CDpaddle.CDtouchX=CDevent.getX();
                CDpaddle.CDtouchY=CDevent.getY();
            }
            break;

            case MotionEvent.ACTION_UP:
            {
                CDpaddle.CDtouchX=CDevent.getX();
                CDpaddle.CDtouchY=CDevent.getY();
            }
            break;

        }



        return true;

    }
}
