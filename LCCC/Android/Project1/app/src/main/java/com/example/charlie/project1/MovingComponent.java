package com.example.charlie.project1;

/**
 * Created by Charlie on 4/30/2017.
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;


public class MovingComponent {
    public float CDx;
    public float CDy;
    public float CDradius;
    public double CDVx;
    public double CDVy;
    public Bitmap CDourImage;

    public float CDtick=0.0005f;
    public float CDtimeAccumulator=0;
    public float CDspeed=4.0f;
    public float CDmyHeight;
    public float CDmyWidth;
    public float CDwindowWidth;
    public float CDwindowHeight;


    public MovingComponent(Context CDcontext, FloatPoint CDcoords, String CDfilename)
    {
        CDx=CDcoords.CDx;
        CDy=CDcoords.CDy;

        loadImage(CDcontext,CDfilename);
    }

    public void moveComponent()
    {
        CDx+=CDVx;
        CDy+=CDVy;
    }




    public void updatePosition(float CDdeltaTime)
    {
        CDtimeAccumulator+=CDdeltaTime;
        if (CDtimeAccumulator>CDtick)
        {
            CDtimeAccumulator-=CDtick;
            moveComponent();
        }
    }

    public void bounceScreen()
    {
        if ((CDx-CDmyWidth/2)<0)//bouce from the left wall
        {
            CDx=CDmyWidth/2;
            CDVx*=-1;
        }

        if ((CDy-CDmyHeight/2)<0)//bounce from the top
        {
            CDy=CDmyHeight/2;
            CDVy*=-1;
        }

        if (CDx>(CDwindowWidth-CDmyWidth/2))//bounce from the right
        {
            CDx=CDwindowWidth-CDmyWidth/2;
            CDVx*=-1;

        }

        if (CDy>(CDwindowHeight-CDmyHeight/2))//bounce from the bottom
        {
            CDy=CDwindowHeight-CDmyHeight/2;
            CDVy*=-1;

        }
    }

    public void loadImage(Context CDcontext, String CDFilename)
    {
        try
        {
            AssetManager ourManager = CDcontext.getAssets();
            InputStream CDourInput = ourManager.open(CDFilename);//try catch sequence
            CDourImage = BitmapFactory.decodeStream(CDourInput);
            Log.d("OurMessage", "image found");
        } catch (IOException e)
        {
            Log.d("OurMessages", "image not found");
        }
    }
    public boolean overlapsWith(MovingComponent CDobj2)
    {
        if (CDobj2!=null) {
            boolean CDtemp = true;
            float CDdeltaX = Math.abs(this.CDx - CDobj2.CDx);
            float CDdeltaY = Math.abs(this.CDy - CDobj2.CDy);

            CDtemp = CDtemp && (CDdeltaX < (this.CDmyWidth / 2 + CDobj2.CDmyWidth / 2));
            CDtemp = CDtemp && (CDdeltaY < (this.CDmyHeight / 2 + CDobj2.CDmyHeight / 2));

            return CDtemp;
        }else
            return false;
    }
}

