package com.lorainccc.natebirkas.nblabyrinth;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;


public class MovingComponent {

    public float x;
    public float y;
    public float radius;
    public double Vx;
    public double Vy;
    public Bitmap ourImage;

    public float tick=0.0005f;
    public float timeAccumulator=0;
    public float speed=4.0f;
    public float myHeight;
    public float myWidth;
    public float windowWidth;
    public float windowHeight;
    static int nbDeadHit=3;
    ClassBall ball;

    public MovingComponent(Context context, FloatPoint coords, String filename)
    {
        x=coords.x;
        y=coords.y;

        loadImage(context,filename);
    }

    public void moveComponent()
    {
        x+=Vx;
        y+=Vy;
    }




    public void nbUpdatePosition(float deltaTime)
    {
        timeAccumulator+=deltaTime;
        if (timeAccumulator>tick)
        {
            timeAccumulator-=tick;
            moveComponent();
        }
    }


    public void bounceScreen()
    {
        if ((x-myWidth/2)<0)//bouce from the left wall
        {
            x=myWidth/2;
            Vx*=-1;
        }

        if ((y-myHeight/2)<0)//bounce from the top
        {
            y=myHeight/2;
            Vy*=-1;
        }

        if (x>(windowWidth-myWidth/2))//bounce from the right
        {
            x=windowWidth-myWidth/2;
            Vx*=-1;

        }

        if (y>(windowHeight-myHeight/2))//bounce from the bottom
        {
            y=windowHeight-myHeight/2;

            nbDeadHit--;

            if (nbDeadHit<=0){
                Vy*=0;
                Vx*=0;
            }
            Vy*=-1;
        }
    }


    public void loadImage(Context context, String Filename)
    {
        try
        {
            AssetManager ourManager = context.getAssets();
            InputStream ourInput = ourManager.open(Filename);//try catch sequence
            ourImage = BitmapFactory.decodeStream(ourInput);
            Log.d("OurMessage", "image found");
        } catch (IOException e)
        {
            Log.d("OurMessages", "image not found");
        }
    }

    public boolean overlapsWith(MovingComponent obj2)
    {
        if (obj2!=null) {
            boolean temp = true;
            float deltaX = Math.abs(this.x - obj2.x);
            float deltaY = Math.abs(this.y - obj2.y);

            temp = temp && (deltaX < (this.myWidth / 2 + obj2.myWidth / 2));
            temp = temp && (deltaY < (this.myHeight / 2 + obj2.myHeight / 2));

            return temp;
        }else
            return false;
    }
}