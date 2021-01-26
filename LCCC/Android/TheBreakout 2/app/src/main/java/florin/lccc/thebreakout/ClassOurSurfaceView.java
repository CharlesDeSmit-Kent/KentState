package florin.lccc.thebreakout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;

/**
 * Created by fmuscuta on 4/10/17.
 */

public class ClassOurSurfaceView extends SurfaceView implements Runnable {

    volatile boolean running;
    Thread ourThread;
    SurfaceHolder ourHolder;
    //ClassShip ship;
    Rect dest=new Rect();
    ClassBall theBall;
    ClassPaddle thePaddle;
    public LinkedList<ClassBrick> Bricks;

    public ClassOurSurfaceView(Context context, ClassBall aball, ClassPaddle apaddle, LinkedList<ClassBrick> listOfBricks)
    {
        super(context);
        ourHolder=getHolder();
        // ship=theShip;
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
            //ship.updatePosition(deltaTime);
            theBall.updatePosition(deltaTime);
            thePaddle.updatePosition(deltaTime);
            Canvas ourCanvas=ourHolder.lockCanvas();
            //do the changes
            drawStuff(ourCanvas);
            ourHolder.unlockCanvasAndPost(ourCanvas);


        }

    }

    private void drawStuff(Canvas theCanvas)
    {
        theCanvas.drawRGB(255,255,255);
        // dest.set((int) ship.currentPoint.x-75,(int)ship.currentPoint.y-75,(int)ship.currentPoint.x+75, (int)ship.currentPoint.y+75 );
        //theCanvas.drawBitmap(ship.shipBitmap, null, dest,null);
        Rect dest=new Rect();
        dest.set((int)(theBall.x-theBall.myWidth/2),(int)(theBall.y-theBall.myHeight/2),(int)(theBall.x+theBall.myWidth/2),(int)(theBall.y+theBall.myHeight/2));
        theCanvas.drawBitmap(theBall.ourImage,null, dest, null);
        dest.set((int)(thePaddle.x-thePaddle.myWidth/2),(int)(thePaddle.y-thePaddle.myHeight/2),(int)(thePaddle.x+thePaddle.myWidth/2),(int)(thePaddle.y+thePaddle.myHeight/2));
        theCanvas.drawBitmap(thePaddle.ourImage,null, dest, null);

        for(ClassBrick theBrick:Bricks)
        {
            if (theBrick.visible)
            {
                dest.set((int) (theBrick.x - theBrick.myWidth / 2), (int) (theBrick.y - theBrick.myHeight / 2), (int) (theBrick.x + theBrick.myWidth / 2), (int) (theBrick.y + theBrick.myHeight / 2));
                theCanvas.drawBitmap(theBrick.ourImage, null, dest, null);
            }
        }
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
