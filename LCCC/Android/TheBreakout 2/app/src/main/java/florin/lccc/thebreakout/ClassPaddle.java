package florin.lccc.thebreakout;

import android.content.Context;

/**
 * Created by fmuscuta on 4/10/17.
 */

public class ClassPaddle extends MovingComponent {
    public float touchX;
    public float touchY;
    public ClassPaddle(Context context, FloatPoint coords, String filename)
    {
        super(context, coords, filename);
        Vx=0.0f;
        Vy=0.0f;
        myHeight=ourImage.getHeight();
        myWidth=ourImage.getWidth()*2;

    }

    @Override
    public void updatePosition(float delta)
    {
        if (x>touchX) Vx=-3;
        else
        if (x<touchX) Vx=3;
        else Vx=0;
        if (Math.abs(x-touchX)<Vx) Vx=0;

        super.updatePosition(delta);
    }
}

