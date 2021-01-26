package florin.lccc.thebreakout;

import android.content.Context;

import java.util.LinkedList;

/**
 * Created by fmuscuta on 4/10/17.
 */

public class ClassBall extends MovingComponent {
    ClassPaddle paddle;
    public LinkedList<ClassBrick> Bricks;

    public ClassBall(Context context, FloatPoint coords, String filename)
    {
        super(context,coords,filename);
        Vx=2.0f;
        Vy=3.0f;
        myWidth=50;
        myHeight=50;
        //paddle=null;
       // Bricks=null;

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

        };

        for (ClassBrick oneBrick:Bricks)
        {
            if (oneBrick.visible)
            {
                if (this.overlapsWith(oneBrick)) {
                    oneBrick.bounceFromBrick(this);
                    //make it disappear
                    //Bricks.remove(oneBrick);
                    //oneBrick.loadImage("newImage.png");
                    /*if (oneBrick.ourId==4)
                    {
                        oneBrick.loadImage("specialImage.png"); //for a specific brick

                    }*/
                    oneBrick.visible = false;

                }
            }
        }


    }

}
