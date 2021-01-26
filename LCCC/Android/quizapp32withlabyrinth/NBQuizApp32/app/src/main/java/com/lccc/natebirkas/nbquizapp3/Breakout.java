package com.lccc.natebirkas.nbquizapp3;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.LinkedList;

public class Breakout extends AppCompatActivity {

    public int windowHeight;
    public int windowWidth;
    ClassOurSurfaceView ourView;
    ClassBall ball;
    ClassPaddle paddle;
    public LinkedList<ClassBrick> Bricks=new LinkedList<ClassBrick>();
    //ClassBrick nbBrick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        FloatPoint coords2=new FloatPoint(100,100);

        ball=new ClassBall(this, coords2, "ball.png");
        paddle=new ClassPaddle(this, coords2, "Paddle.png");

        ball.paddle=paddle;
        //ball.Bricks=Bricks;
        ball.Bricks=Bricks;

        ourView=new ClassOurSurfaceView(this,ball,paddle,Bricks);
        setContentView(ourView);

        Rect dim=new Rect();
        ourView.getWindowVisibleDisplayFrame(dim);
        windowHeight=dim.height();
        windowWidth=dim.width();

        ball.windowHeight=windowHeight;
        ball.windowWidth=windowWidth;
        ball.x=windowWidth/2;
        ball.y=windowHeight/2;

        paddle.windowHeight=windowHeight;
        paddle.windowWidth=windowWidth;
        paddle.x=windowWidth/2;
        paddle.y=windowHeight-3*paddle.myHeight;
        paddle.touchX=paddle.x;
        paddle.touchY=paddle.y;

        ClassOurTouchListener theCop=new ClassOurTouchListener(paddle);
        ourView.setOnTouchListener(theCop);
        setupBricks();

    }


    public void setupBricks()
    {
        FloatPoint coords;
        ClassBrick oneBrick;
        for (int i=0; i<10; i++) {
            coords = new FloatPoint(10, 10);
            //we're not using them, they're just for init purposes.
            oneBrick = new ClassBrick(this, coords, "Paddle.png");
            oneBrick.myWidth=windowWidth/10;
            oneBrick.myHeight=oneBrick.ourImage.getHeight()*10;
            oneBrick.windowWidth=windowWidth;
            oneBrick.windowHeight=windowHeight;
            oneBrick.x=i*oneBrick.myWidth+oneBrick.myWidth/2;
            oneBrick.y=oneBrick.myHeight*3;
            oneBrick.ourId=i;
            Bricks.add(oneBrick);
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ourView.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        ourView.pause();

    }
}
