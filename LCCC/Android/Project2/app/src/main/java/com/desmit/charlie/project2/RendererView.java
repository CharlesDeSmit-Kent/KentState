package com.desmit.charlie.project2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Charlie on 5/8/2017.
 */

public class RendererView extends SurfaceView implements Runnable {

    Thread CDourThread=null;
    SurfaceHolder CDholder;
    ClassShip CDship;
    ClassShip CDship2;
    BallClass CDball;
    volatile boolean CDrunning=false;
    Rect CDdest=new Rect();

    public RendererView(Context CDcontext, ClassShip CDAship, ClassShip CDAship2, BallClass CDAball){
        super(CDcontext);
        CDship=CDAship;
        CDship2=CDAship2;
        CDball=CDAball;
        //Log.d("LifeCycleTest","renderViewUp");
        CDholder=getHolder();
    }
    public void run() {
        // TODO Auto-generated method stub
        long startTime=System.nanoTime();
        CDball.CDlastTime=System.currentTimeMillis();

        while(CDrunning)
        {
            if (!CDholder.getSurface().isValid()) continue;

            float deltaTime=(System.nanoTime()-startTime)/1000000000.0f;//in seconds
            startTime=System.nanoTime();
            CDship.updatePosition(deltaTime);
            CDship2.updatePosition(deltaTime);
            //ball.updatePosition(deltaTime);
            CDball.updatePosition(CDship, CDship2);

            Canvas canvas=CDholder.lockCanvas();
            ourDraw(canvas);
            CDholder.unlockCanvasAndPost(canvas);
        }
    }

    public void resume()
    {
        CDrunning=true;
        CDourThread=new Thread(this);
        CDourThread.start();
    };

    public void pause(){
        CDrunning=false;
        while(true)
        {
            try {
                CDourThread.join();
                break;
            }
            catch (InterruptedException e){
            }//close catch
        }//close while
        CDourThread = null;
    };//close pause


    private void ourDraw(Canvas CDcanvas)
    {
        CDcanvas .drawRGB(255,255,255);
        CDdest.set((int)CDship.CDx,(int)CDship.CDy,(int)CDship.CDx+150,(int)CDship.CDy+150);
        CDcanvas.drawBitmap(CDship.CDbitmap, null,CDdest, null);

        CDdest.set((int)CDship2.CDx,(int)CDship2.CDy,(int)CDship2.CDx+150,(int)CDship2.CDy+150);
        CDcanvas.drawBitmap(CDship2.CDbitmap, null,CDdest, null);

        CDdest.set((int)CDball.CDcurrentPoint.CDx-CDball.CDwidth/2,(int)CDball.CDcurrentPoint.CDy-CDball.CDheight/2,(int)CDball.CDcurrentPoint.CDx+CDball.CDwidth/2,(int)CDball.CDcurrentPoint.CDy+CDball.CDheight/2);
        CDcanvas.drawBitmap(CDball.CDourImage, null,CDdest, null);

        Paint CDpaint = new Paint();
        CDpaint.setColor(Color.BLACK);
        CDpaint.setTextSize(30);
        CDcanvas.drawText("Score: "+ String.valueOf(CDball.CDScore), 10, 25, CDpaint);

        //canvas.drawBitmap(ship.bitmap, ship.x, ship.y, null);
    }


};//close class
