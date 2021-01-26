package charlie.lccc.movingstuff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by uc224 on 3/28/17.
 */

public class ClassSurfaceView extends SurfaceView implements Runnable{

    boolean running;
    Thread ourThread;
    SurfaceHolder ourHolder;
    ClassShip theShip;
    //ClassShip theShip2;

    public ClassSurfaceView(Context context, ClassShip aShip /*,ClassShip bShip*/)
    {
        super(context);
        ourHolder=getHolder();
        theShip=aShip;
        //theShip2=bShip;
    }

    private void drawStuff(Canvas theCanvas)
    {
        theCanvas.drawRGB(255,255,255);
        Rect ourRect=new Rect();
        ourRect.set((int) theShip.currentPoint.x-75, (int) theShip.currentPoint.y-75,
                (int) theShip.currentPoint.x+75, (int) theShip.currentPoint.y+75);
        //ourRect.set((int) theShip2.currentPoint.x-75, (int) theShip2.currentPoint.y-75,
          //      (int) theShip2.currentPoint.x+75, (int) theShip2.currentPoint.y+75);
        theCanvas.drawBitmap(theShip.shipBitmap, null, ourRect, null);
    }
    public void run()
    {
        long startTime=System.nanoTime();
        while(running)
        {
            if (!ourHolder.getSurface().isValid()) continue;
            //call to do calcs
            float deltatime= (System.nanoTime()-startTime/1000000000.0f);
            startTime=System.nanoTime();
            theShip.updatePosition(deltatime);
            Canvas ourCanvas=ourHolder.lockCanvas();
            //do changes to the view (screen)
            drawStuff(ourCanvas);

            ourHolder.unlockCanvasAndPost(ourCanvas);
        }
    }
    public void pause()
    {
        //called from activity when we put the activity onPause
        //where we stop second execution thread
        running=false;
        while(true){
            try {
                ourThread.join();
                break;
            }catch(InterruptedException e) {

            }
        }
    }
    public void resume()
    {
        //called from activity when we resume the app
        running=true;//keepin track that we start the second thread of execution
        ourThread=new Thread(this);
        ourThread.start();
    }


}
