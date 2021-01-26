package com.lccc.natebirkas.nbquizapp3;

import android.content.Context;
import java.util.LinkedList;

public class ClassBall extends MovingComponent {

    ClassPaddle paddle;
    public LinkedList<ClassBrick> Bricks;
    boolean nbHits=false;

    public ClassBall(Context context, FloatPoint coords, String filename)
    {
        super(context,coords,filename);
        Vx=4.0f;
        Vy=6.0f;
        myWidth=50;
        myHeight=50;
        //paddle=null;
        Bricks=null;
        tick=0.005f;
    }

    @Override
    public void updatePosition(float deltaTime)
    {
        super.updatePosition(deltaTime);
        this.bounceScreen();

        if (this.overlapsWith(paddle))
        {
            //bounce from paddle rudimentary to change with a better bouncing
            this.Vy*=-1;
            float maxVx=5.0f;
            this.Vx=maxVx*((this.x-paddle.x)/(paddle.myWidth/2));
            //insert paddle bounce sound here
        };

        for (ClassBrick oneBrick:Bricks)
        {
            if (oneBrick.visible)
            {
                if (this.overlapsWith(oneBrick)) {
                    if (nbHits==true){
                        oneBrick.bounceFromBrick(this);
                        oneBrick.visible = false;
                    }

                    oneBrick.myHeight=oneBrick.myHeight/2;
                    oneBrick.myWidth=oneBrick.myWidth/2;
                    nbHits=true;

                    //oneBrick.bounceFromBrick(this);
                    //make it disappear
                    //Bricks.remove(oneBrick);
                    /*
                    if (oneBrick.ourId==4){
                        oneBrick.loadImage("brickVariationImage.png");
                    }
                    */
                    //oneBrick.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }
    }
}
