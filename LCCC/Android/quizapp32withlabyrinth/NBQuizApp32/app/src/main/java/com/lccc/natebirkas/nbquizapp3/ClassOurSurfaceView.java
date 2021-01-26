package com.lccc.natebirkas.nbquizapp3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;
import java.util.Random;


public class ClassOurSurfaceView extends SurfaceView implements Runnable {

    volatile boolean running;
    Thread ourThread;
    SurfaceHolder ourHolder;
    Rect dest=new Rect();
    ClassBall theBall;
    ClassPaddle thePaddle;
    //ClassBrick nbMovingBricks;
    ClassBrick theBrick;
    public LinkedList<ClassBrick> Bricks;

    public ClassOurSurfaceView(Context context, ClassBall aball, ClassPaddle apaddle, LinkedList<ClassBrick> listOfBricks)
    {
        super(context);
        ourHolder=getHolder();
        theBall=aball;
        thePaddle=apaddle;
        Bricks=listOfBricks;
    }

    public void run()
    {
        long startTime=System.nanoTime();
        while(running)
        {
            if (!ourHolder.getSurface().isValid()) continue;

            float deltaTime=(System.nanoTime()-startTime)/1000000000.0f;
            //get the the number into seconds
            startTime=System.nanoTime();
            theBall.updatePosition((deltaTime));
            thePaddle.updatePosition((deltaTime));
            //nbMovingBricks.updatePosition((deltaTime));

            Canvas ourCanvas=ourHolder.lockCanvas();
            //do the changes
            drawStuff(ourCanvas);
            ourHolder.unlockCanvasAndPost(ourCanvas);
        }

    }

    private void drawStuff(Canvas theCanvas)
    {

        Random rand = new Random();
        int nbBrickPlace = rand.nextInt(800);
        theCanvas.drawRGB(255,255,255);
        Rect dest=new Rect();
        dest.set((int)(theBall.x-theBall.myWidth/2),(int)(theBall.y-theBall.myHeight/2),(int)(theBall.x+theBall.myWidth/2),(int)(theBall.y+theBall.myHeight/2));
        theCanvas.drawBitmap(theBall.ourImage, null, dest,null);

        dest.set((int)(thePaddle.x-thePaddle.myWidth/2),(int)(thePaddle.y-thePaddle.myHeight/2),(int)(thePaddle.x+thePaddle.myWidth/2),(int)(thePaddle.y+thePaddle.myHeight/2));
        theCanvas.drawBitmap(thePaddle.ourImage, null, dest,null);

        /*
        for (ClassBrick theBrick:Bricks)
        {
            if (theBrick.visible)
                dest.set((int)(theBrick.x-theBrick.myWidth/2),(int)(theBrick.y-theBrick.myHeight/2),(int)(theBrick.x+theBrick.myWidth/2),(nbBrickPlace));
            theCanvas.drawBitmap(theBrick.ourImage, null, dest,null);
        }
        */
        // tried making random placement for the bricks in vertical space but it was moving them randomly at a very erratic pace, not the effect I was going for.
        //"nbBrickPlace"

        for (ClassBrick theBrick:Bricks)
        {
            if (theBrick.visible)
                dest.set((int)(theBrick.x-theBrick.myWidth/2),(int)(theBrick.y-theBrick.myHeight/2),(int)(theBrick.x+theBrick.myWidth/2),(int)(theBrick.y+theBrick.myHeight/2));
            theCanvas.drawBitmap(theBrick.ourImage, null, dest,null);
        }

        Paint paint = new Paint();

        paint.setColor(Color.BLACK);
        paint.setTextSize(120);
        theCanvas.drawText(String.valueOf(ClassBrick.nbScore), 50, 120, paint);

        //draws score to screen

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
