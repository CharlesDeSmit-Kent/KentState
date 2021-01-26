package charlie.lccc.movingstuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MovingActivity extends AppCompatActivity {

    //Declare variables
    ClassShip objShip;
    //ClassShip objShip2;
    ClassSurfaceView ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving);
        FloatPoint coord=new FloatPoint(200,200);
        objShip=new ClassShip(this);
        objShip.setCurrentPoint(coord);

        //FloatPoint coord2=new FloatPoint(300,300);
        //objShip2=new ClassShip(this);
        //objShip2.setCurrentPoint(coord);

        ourView=new ClassSurfaceView(this, objShip/*, objShip2*/);
        setContentView(ourView);
        View.OnTouchListener ourListener=new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (MotionEvent.ACTION_DOWN!=event.getAction())
                {

                }else
                {
                    objShip.moveToPoint.x=event.getX();
                    objShip.moveToPoint.y=event.getY();
                    objShip.calculateSpeed();
                }

                return false;
            };
        };
        ourView.setOnTouchListener(ourListener);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ourView.resume();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        ourView.pause();
    }

}
