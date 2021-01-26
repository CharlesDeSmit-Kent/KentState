package charlie.lccc.movingstuff;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by uc224 on 3/28/17.
 */

public class ClassShip {

    public float Vx;
    public float Vy;
    public float speed=4.0f;
    public FloatPoint moveToPoint;
    public FloatPoint currentPoint;
    public Bitmap shipBitmap;
    public float tick=0.0005f;//unit of time
    public float timeAccumulator = 0;

    public ClassShip(Context context)
    {
        currentPoint=new FloatPoint(0,0);
        moveToPoint=new FloatPoint(0,0);
        loadImage(context);
    }

    public void calculateSpeed()
    {
            FloatPoint c = currentPoint;
            float diffx=moveToPoint.x-c.x;
            float diffy=moveToPoint.y-c.y;

            if(diffx!=0)
            {
                double alpha = Math.atan(diffy/diffx);
                Vx=(float) Math.cos(alpha)*speed;
                Vy=(float) Math.sin(alpha)*speed;

                if (diffx<0)
                {
                    Vx = Vx*(-1);
                    Vy = Vy*(-1);
                }
            }else
            {
                Vx = 0;
                if (diffy<0) Vy=-speed;
                else if (diffy!=0) Vy=speed;
                else Vy = 0;
            }

    }
    public void updatePosition(float deltatime)
    {
        timeAccumulator+=deltatime;
        if(timeAccumulator>tick) {
            if (!reachedDestination()) {
                currentPoint.x = currentPoint.x + Vx * 1;
                currentPoint.y = currentPoint.y + Vy * 1;
                timeAccumulator -= tick; //subtract the time you used
            }
        }

    }
    boolean reachedDestination()
    {
        float diffx=moveToPoint.x-currentPoint.x;
        float diffy=moveToPoint.y-currentPoint.y;

        double distance=Math.sqrt(diffx*diffx*diffy*diffy);
        if(distance<speed) return true;
        else return false;

    }

    public void setCurrentPoint(FloatPoint bubu)
    {

        currentPoint.x=bubu.x;
        currentPoint.y=bubu.y;
    }
    public void setMoveToPoint(FloatPoint bubu)
    {

        moveToPoint.x=bubu.x;
        moveToPoint.y=bubu.y;
    }
    public void loadImage(Context context)
    {
        try
        {
            AssetManager ourManager=context.getAssets();
            InputStream ourInput=ourManager.open("viper.png");
            shipBitmap= BitmapFactory.decodeStream(ourInput);
            Log.d("ourMesasges", "image found");
        }
        catch(IOException e)
        {
            Log.d("ourMessages", "image not found");
        }
    }
}
