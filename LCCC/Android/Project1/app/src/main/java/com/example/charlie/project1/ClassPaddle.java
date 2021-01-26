package com.example.charlie.project1;

/**
 * Created by Charlie on 4/30/2017.
 */

import android.content.Context;

public class ClassPaddle extends MovingComponent {
    public float CDtouchX;
    public float CDtouchY;
    public ClassPaddle(Context CDcontext, FloatPoint CDcoords, String CDfilename)
    {
        super(CDcontext, CDcoords, CDfilename);
        CDVx=0.0f;
        CDVy=0.0f;
        CDmyHeight=CDourImage.getHeight();
        CDmyWidth=CDourImage.getWidth()*2;

    }

    @Override
    public void updatePosition(float CDdelta)
    {
        if (CDx>CDtouchX) CDVx=-3;
        else
        if (CDx<CDtouchX) CDVx=3;
        else CDVx=0;
        if (Math.abs(CDx-CDtouchX)<CDVx) CDVx=0;

        super.updatePosition(CDdelta);
    }
}

