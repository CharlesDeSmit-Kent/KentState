package com.example.charlie.project1;

/**
 * Created by Charlie on 4/30/2017.
 */

import android.content.Context;

import java.util.LinkedList;

public class ClassPowerUpBall extends MovingComponent {
    ClassPaddle CDpaddle;
    ClassBall CDogBall;
    public LinkedList<ClassBrick> CDBricks;

    public ClassPowerUpBall(Context CDcontext, FloatPoint CDcoords, String CDfilename)
    {
        super(CDcontext,CDcoords,CDfilename);
        CDVx=-3.0f;
        CDVy=0.0f;
        CDmyWidth=50;
        CDmyHeight=50;
        //paddle=null;
        // Bricks=null;

    }

    @Override
    public void updatePosition(float CDdeltaTime)
    {
        super.updatePosition(CDdeltaTime);
        this.bounceScreen();

        if (this.overlapsWith(CDpaddle))
        {
            //bounce from paddle rudimentary to change with a better bouncing
            this.CDVy*=-1;
            float CDmaxVx=5.0f;
            this.CDVx=CDmaxVx*((this.CDx-CDpaddle.CDx)/(CDpaddle.CDmyWidth/2));

        };
        if (this.overlapsWith(CDogBall))
        {
            if(CDVy==0.0)
            {
                CDVx=2.0f;
                CDVy=3.0f;
            }else
            {
                CDVx=CDogBall.CDVx;
                CDVy=CDogBall.CDVy;
            }

        }
        for (ClassBrick oneBrick:CDBricks)
        {
            if (oneBrick.CDvisible)
            {
                if (this.overlapsWith(oneBrick)) {
                    CDogBall.CDscore+=10;
                    oneBrick.bounceFromBrick(this);
                    //make it disappear
                    //Bricks.remove(oneBrick);
                    //oneBrick.loadImage("newImage.png");
                    if(oneBrick.CDHP==1) {

                        oneBrick.CDHP-=1;

                    }else oneBrick.CDvisible = false;

                }
            }
        }


    }

}
