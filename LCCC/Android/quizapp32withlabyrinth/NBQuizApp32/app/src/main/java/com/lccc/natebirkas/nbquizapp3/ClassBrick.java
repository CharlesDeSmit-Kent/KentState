package com.lccc.natebirkas.nbquizapp3;

import android.content.Context;


public class ClassBrick extends MovingComponent {
    public Boolean visible=true;
    public int ourId;
    static int nbScore;
    //TextView nbScoreField;
    //boolean hits=false;

    public ClassBrick(Context context, FloatPoint coords, String filename )
    {
        super(context, coords, filename);
        Vx=2.0f;
        Vy=0.0f;
        myHeight=ourImage.getHeight()*2;
        myWidth=ourImage.getWidth();
        tick=0.005f;

        //nbScoreField = (TextView)findViewById(R.id.scoreField);
        //nbScoreField.setText(String.valueOf(score));
    }

    @Override
    public void updatePosition(float deltaTime)
    {
        super.updatePosition(deltaTime);
        this.bounceScreen();
    }

    public void bounceFromBrick(MovingComponent ball)
    {
        //rudimentary  brick bounce

        //nbScoreField = (TextView)findViewById(R.id.scoreField);
        //nbScoreField.setText(String.valueOf(score));

        if ((this.x+this.myWidth/2)<ball.x) {
            nbScore++;
            this.myWidth=this.myWidth/2;
            this.myHeight=this.myHeight/2;
            ball.Vx*=-1;

            //this is where the score is supposed to increase if the ball collides
            //with a brick. Upon the first collision the score does not change
            //but after that one the score goes up by one and that's it.

        }
        else if ((this.x-this.myWidth/2)>ball.x) ball.Vx*=-1;

        else if ((this.y-this.myHeight/2)>ball.y) ball.Vy*=-1;
        else if ((this.y+this.myHeight/2)<ball.y) ball.Vy*=-1;
        else ball.Vy*=-1;

    }

}
