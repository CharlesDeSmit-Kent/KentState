package com.lccc.natebirkas.nbquizapp3;

import android.content.Context;

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
        if (x>touchX) Vx=-7;
        else
        if (x<touchX) Vx=7;
        else Vx=0;
        if (Math.abs(x-touchX)<Vx) Vx=0;

        super.updatePosition(delta);
    }
}