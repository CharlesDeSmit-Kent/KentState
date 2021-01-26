package florin.lccc.thebreakout;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fmuscuta on 4/10/17.
 */

public class ClassOurTouchListener implements View.OnTouchListener {

    ClassPaddle paddle;
    public ClassOurTouchListener( ClassPaddle aPaddle)

    {
        paddle=aPaddle;
    }
    public  boolean onTouch(View v, MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                for (int i=0, n=event.getHistorySize();i<n; i++)
                {
                    paddle.touchX=event.getHistoricalX(i);
                    paddle.touchY=event.getHistoricalY(i);
                }
                break;

            case MotionEvent.ACTION_DOWN:
            {
                paddle.touchX=event.getX();
                paddle.touchY=event.getY();
            }
            break;

            case MotionEvent.ACTION_UP:
            {
                paddle.touchX=event.getX();
                paddle.touchY=event.getY();
            }
            break;

        }



        return true;

    }
}
