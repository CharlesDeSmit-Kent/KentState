package com.desmit.charlie.project2;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Charlie on 5/8/2017.
 */

public class ClassShip {

    public float CDx;
    public float CDy;
    public float CDradius;
    public int CDcolor;
    public double CDdx=2;//speedX
    public double CDdy=2;//speedY
    public Bitmap CDbitmap;
    public FloatPoint CDmoveToPoint;
    public float CDtick=0.0005f;
    public float CDtimeAccumulator=0;
    public float CDspeed=4.0f;
    public int CDmyWidth;
    public int CDmyHeight;


    public ClassShip(Context CDcontext, FloatPoint CDcoords, String CDfilename)
    {
        CDx=CDcoords.CDx;
        CDy=CDcoords.CDy;
        loadImage(CDcontext, CDfilename);
        CDmoveToPoint=new FloatPoint(CDx, CDy);
        CDmyHeight=80;
        CDmyWidth=80;



    }

    public void updatePosition(float deltaTime)
    {
        CDtimeAccumulator+=deltaTime;
        if (CDtimeAccumulator>CDtick)
        {
            CDtimeAccumulator-=CDtick;
            //moveShip();
            moveShipToPoint();

        }
    }

    private void moveShip()
    {
        CDx+=CDdx;
        CDy+=CDdy;
    };

    private void moveShipToPoint()
    {
        float CDdiffX = (CDmoveToPoint.CDx -CDx);
        float CDdiffY = (CDmoveToPoint.CDy -CDy);

        if (CDdiffX!=0)
        {
            //Log.d("LifeCycleTest", "diffX "+String.valueOf(diffX));

            //Log.d("LifeCycleTest", "diffY "+String.valueOf(diffY));
            double theta = Math.atan(CDdiffY/CDdiffX);


            CDdx = Math.cos(theta)*CDspeed;
            CDdy =Math.sin(theta)*CDspeed;

            if (CDdiffX < 0){
                CDdx *= -1;
                CDdy *= -1;
            }

            moveShip();

            if (Math.abs(CDmoveToPoint.CDx -CDx) < CDspeed && Math.abs(CDmoveToPoint.CDy -CDy) < CDspeed)
            {
                CDx = CDmoveToPoint.CDx;
                CDy = CDmoveToPoint.CDy;
            }
        }

    };

    private void loadImage(Context CDcontext, String CDfilename)
    {
        try
        {
            AssetManager assetManager=CDcontext.getAssets();
            InputStream inputStream=assetManager.open(CDfilename);
            CDbitmap= BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            Log.d("LifeCycleTest","image found");

        }
        catch(IOException e)
        {
            //done nothing;
            Log.d("LifeCycleTest","image NOT found");

        }finally
        {
            //we should close our input stream here

        }
    }
}