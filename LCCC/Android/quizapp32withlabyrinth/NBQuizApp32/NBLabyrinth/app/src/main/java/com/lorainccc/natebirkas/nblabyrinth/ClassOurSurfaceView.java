package com.lorainccc.natebirkas.nblabyrinth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;


public class ClassOurSurfaceView extends SurfaceView implements Runnable {

    volatile boolean running=false;
    Thread ourThread=null;
    SurfaceHolder ourHolder;
    Rect dest=new Rect();
    ClassBall ball;
    //ClassPaddle thePaddle;
    ClassBrick theBrick;
    public LinkedList<ClassBrick> Bricks;

    public ClassOurSurfaceView(Context context, ClassBall aball, LinkedList<ClassBrick> listOfBricks)
    {
        super(context);
        ourHolder=getHolder();
        ball=aball;
        //thePaddle=apaddle;
        Bricks=listOfBricks;
    }

    public void run()
    {
        long startTime=System.nanoTime();
        ball.lastTime=System.currentTimeMillis();
        while(running)
        {
            if (!ourHolder.getSurface().isValid()) continue;

            float deltaTime=(System.nanoTime()-startTime)/1000000000.0f;
            //get the the number into seconds
            startTime=System.nanoTime();
            ball.updatePosition();
            //thePaddle.updatePosition((deltaTime));

            Canvas ourCanvas=ourHolder.lockCanvas();
            //do the changes
            drawStuff(ourCanvas);
            ourHolder.unlockCanvasAndPost(ourCanvas);
        }

    }

    private void drawStuff(Canvas theCanvas)
    {

        theCanvas.drawRGB(0,0,0);
        Rect dest=new Rect();
        dest.set((int)(ball.currentPoint.x-ball.width/2),(int)(ball.currentPoint.y-ball.height/2),(int)(ball.currentPoint.x+ball.width/2),(int)(ball.currentPoint.y+ball.height/2));
        theCanvas.drawBitmap(ball.ourImage, null, dest,null);


        //dest.set((int)(thePaddle.x-thePaddle.myWidth/2),(int)(thePaddle.y-thePaddle.myHeight/2),(int)(thePaddle.x+thePaddle.myWidth/2),(int)(thePaddle.y+thePaddle.myHeight/2));
        //theCanvas.drawBitmap(thePaddle.ourImage, null, dest,null);

        for (ClassBrick theBrick:Bricks)
        {
            if (theBrick.visible)
                dest.set((int)(theBrick.x-theBrick.myWidth/2),(int)(theBrick.y-theBrick.myHeight/2),(int)(theBrick.x+theBrick.myWidth/2),(int)(theBrick.y+theBrick.myHeight/2));
            theCanvas.drawBitmap(theBrick.ourImage, null, dest,null);
        }

        Paint paint = new Paint();

        paint.setColor(Color.GRAY);
        paint.setTextSize(60);
        theCanvas.drawText("Score: "+String.valueOf(ClassBrick.nbScore), 25, theCanvas.getHeight()/2, paint);
        theCanvas.drawText("Lives: "+String.valueOf(MovingComponent.nbDeadHit), 25, theCanvas.getHeight()/2+50, paint);
    }

    public void resume()
    {

        running=true;
        ourThread=new Thread(this);
        ourThread.start();
    }

    public void pause()
    {
        running=false;
        while(true)
        {
            try
            {
                ourThread.join();
                break;

            }catch (InterruptedException e)
            {


            }
        }

    }
}
