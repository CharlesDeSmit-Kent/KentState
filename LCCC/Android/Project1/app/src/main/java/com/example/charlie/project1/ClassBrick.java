package com.example.charlie.project1;

/**
 * Created by Charlie on 4/30/2017.
 */


import android.content.Context;

public class ClassBrick extends MovingComponent {
    public Boolean CDvisible=true;
    public int CDourId;
    public int CDHP;
    public ClassBrick(Context CDcontext, FloatPoint CDcoords, String CDfilename )
    {


        super(CDcontext, CDcoords, CDfilename);
        CDVx=2.0f;
        CDVy=0.0f;
        CDmyHeight=CDourImage.getHeight()*2;
        CDmyWidth=CDourImage.getWidth();
        //myWidth=windowWidth/10;
    }

    public void updatePosition(float CDdeltaT)
    {
        super.updatePosition(CDdeltaT);
        this.bounceScreen();

        /*if (this.overlapsWith(CDpaddle))
        {
            //bounce from paddle rudimentary to change with a better bouncing
            this.CDVy*=-1;
            float maxVx=5.0f;
            this.CDVx=maxVx*((this.CDx-CDpaddle.CDx)/(CDpaddle.CDmyWidth/2));

        };*/

        /*for (ClassBrick oneBrick:CDBricks)
        {
            if (oneBrick.CDvisible)
            {
                if (this.overlapsWith(oneBrick)) {
                    oneBrick.bounceFromBrick(this);
                    //make it disappear
                    //Bricks.remove(oneBrick);
                    //oneBrick.loadImage("newImage.png");

                    if(oneBrick.CDHP==1) {
                        oneBrick.CDmyWidth = oneBrick.CDmyWidth / 4;
                        oneBrick.CDmyHeight = oneBrick.CDmyHeight / 4;
                        oneBrick.CDHP=oneBrick.CDHP-1;
                    }else oneBrick.CDvisible = false;

                }
            }
        }*/


    }


    public void bounceFromBrick(MovingComponent CDball)
    {
        //rudimentary  brick bounce
        if ((this.CDx+this.CDmyWidth/2)<CDball.CDx)CDball.CDVx*=-1;
        else if ((this.CDx-this.CDmyWidth/2)>CDball.CDx) CDball.CDVx*=-1;
        else if ((this.CDy-this.CDmyHeight/2)>CDball.CDy) CDball.CDVy*=-1;
        else if ((this.CDy+this.CDmyHeight/2)<CDball.CDy) CDball.CDVy*=-1;
        else CDball.CDVy*=-1;

    }

}