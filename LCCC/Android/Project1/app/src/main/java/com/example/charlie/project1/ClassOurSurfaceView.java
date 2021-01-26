package com.example.charlie.project1;


import android.view.SurfaceView;

/**
 * Created by uc224 on 4/25/17.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Paint.Style;


import java.util.LinkedList;



public class ClassOurSurfaceView extends SurfaceView implements Runnable {

    volatile boolean CDrunning;
    Thread CDourThread;
    SurfaceHolder CDourHolder;
    //ClassShip ship;
    Rect CDdest=new Rect();
    ClassBall CDtheBall;
    ClassPaddle CDthePaddle;
    ClassPowerUpBall CDextraBall;
    public LinkedList<ClassBrick> CDBricks;

    public ClassOurSurfaceView(Context CDcontext, ClassBall CDaball, ClassPaddle CDapaddle, ClassPowerUpBall CDanextraBall, LinkedList<ClassBrick> CDlistOfBricks)
    {
        super(CDcontext);
        CDourHolder=getHolder();
        // ship=theShip;
        CDtheBall=CDaball;
        CDthePaddle=CDapaddle;
        CDextraBall=CDanextraBall;
        CDBricks=CDlistOfBricks;
    }

    public void run()
    {
        long startTime=System.nanoTime();
        while(CDrunning)
        {
            if (!CDourHolder.getSurface().isValid()) continue;

            float CDdeltaTime=(System.nanoTime()-startTime)/1000000000.0f;
            //get the the number into seconds
            startTime=System.nanoTime();
            //ship.updatePosition(deltaTime);
            CDtheBall.updatePosition(CDdeltaTime);
            CDthePaddle.updatePosition(CDdeltaTime);
            //CDextraBall.updatePosition(CDdeltaTime);
            Canvas ourCanvas=CDourHolder.lockCanvas();
            //do the changes
            drawStuff(ourCanvas);
            CDourHolder.unlockCanvasAndPost(ourCanvas);


        }

    }

    private void drawStuff(Canvas CDtheCanvas)
    {
        CDtheCanvas.drawRGB(255,255,255);
        // dest.set((int) ship.currentPoint.x-75,(int)ship.currentPoint.y-75,(int)ship.currentPoint.x+75, (int)ship.currentPoint.y+75 );
        //theCanvas.drawBitmap(ship.shipBitmap, null, dest,null);
        Rect CDdest=new Rect();
        CDdest.set((int)(CDtheBall.CDx-CDtheBall.CDmyWidth/2),(int)(CDtheBall.CDy-CDtheBall.CDmyHeight/2),(int)(CDtheBall.CDx+CDtheBall.CDmyWidth/2),(int)(CDtheBall.CDy+CDtheBall.CDmyHeight/2));
        CDtheCanvas.drawBitmap(CDtheBall.CDourImage,null, CDdest, null);
        CDdest.set((int)(CDthePaddle.CDx-CDthePaddle.CDmyWidth/2),(int)(CDthePaddle.CDy-CDthePaddle.CDmyHeight/2),(int)(CDthePaddle.CDx+CDthePaddle.CDmyWidth/2),(int)(CDthePaddle.CDy+CDthePaddle.CDmyHeight/2));
        CDtheCanvas.drawBitmap(CDthePaddle.CDourImage,null, CDdest, null);
        CDdest.set((int)(CDextraBall.CDx-CDextraBall.CDmyWidth/2),(int)(CDextraBall.CDy-CDextraBall.CDmyHeight/2),(int)(CDextraBall.CDx+CDextraBall.CDmyWidth/2),(int)(CDextraBall.CDy+CDextraBall.CDmyHeight/2));
        CDtheCanvas.drawBitmap(CDextraBall.CDourImage,null, CDdest, null);

        for(ClassBrick CDtheBrick:CDBricks)
        {
            if (CDtheBrick.CDvisible)
            {
                CDdest.set((int) (CDtheBrick.CDx - CDtheBrick.CDmyWidth / 2), (int) (CDtheBrick.CDy - CDtheBrick.CDmyHeight / 2), (int) (CDtheBrick.CDx + CDtheBrick.CDmyWidth / 2), (int) (CDtheBrick.CDy + CDtheBrick.CDmyHeight / 2));
                CDtheCanvas.drawBitmap(CDtheBrick.CDourImage, null, CDdest, null);
            }
        }

        Paint CDpaint = new Paint();

        CDpaint.setColor(Color.BLACK);
        CDpaint.setTextSize(30);
        CDtheCanvas.drawText("Score: "+ String.valueOf(CDtheBall.CDscore), 10, 25, CDpaint);
        CDtheCanvas.drawText("Lives: "+ String.valueOf(CDtheBall.CDlives), 10, 50, CDpaint);
    }

    public void resume()
    {

        CDrunning=true;
        CDourThread=new Thread(this);
        CDourThread.start();
    }

    public void pause()
    {
        CDrunning=false;
        while(true)
        {
            try
            {
                CDourThread.join();
                break;

            }catch (InterruptedException e)
            {


            }
        }

    }
}