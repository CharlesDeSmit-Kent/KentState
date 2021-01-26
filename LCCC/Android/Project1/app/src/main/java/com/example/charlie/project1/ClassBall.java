package com.example.charlie.project1;

/**
 * Created by Charlie on 4/30/2017.
 */


import android.content.Context;

import java.util.LinkedList;

public class ClassBall extends MovingComponent {
    int CDscore = 0;
    int CDlives = 3;
    ClassPowerUpBall CDextraBall;
    ClassPaddle CDpaddle;
    public LinkedList<ClassBrick> CDBricks;

    public ClassBall(Context CDcontext, FloatPoint CDcoords, String CDfilename)
    {
        super(CDcontext,CDcoords,CDfilename);
        CDVx=2.0f;
        CDVy=3.0f;
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
        if (this.overlapsWith(CDextraBall))
        {
            if(CDextraBall.CDVy==0.0)
            {
                CDVx=-CDVx;
                CDVy=-CDVy;
            }else
            {
                CDVx=CDextraBall.CDVx;
                CDVy=CDextraBall.CDVy;
            }

        }
        for (ClassBrick CDoneBrick:CDBricks)
        {
            if (CDoneBrick.CDvisible)
            {
                if (this.overlapsWith(CDoneBrick)) {

                    CDscore+=10;
                    CDoneBrick.bounceFromBrick(this);
                    //make it disappear
                    //Bricks.remove(oneBrick);
                    //oneBrick.loadImage("newImage.png");
                    if(CDoneBrick.CDHP==1) {

                        CDoneBrick.CDHP-=1;

                    }else CDoneBrick.CDvisible = false;

                }
            }
        }


    }

}
