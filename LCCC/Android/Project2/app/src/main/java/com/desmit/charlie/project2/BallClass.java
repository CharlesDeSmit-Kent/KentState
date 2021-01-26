package com.desmit.charlie.project2;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Charlie on 5/8/2017.
 */


public class BallClass {
    public Bitmap CDourImage;
    public FloatPoint CDcurrentPoint;
    public FloatPoint CDpreviousPoint;
    public XYZCoords CDAccelData;
    public float CDballXVelocity;
    public float CDballYVelocity;
    public OurSensorListener CDl1;
    public int CDdisplayWidth;
    public int CDdisplayHeight;
    public long CDlastTime;
    public int CDwidth;
    public int CDheight;
    public int CDScore;

    public BallClass(Context CDcontext, FloatPoint CDcoords, String CDfilename)
    {
        loadImage(CDcontext, CDfilename);
        CDcurrentPoint=new FloatPoint(CDcoords.CDx, CDcoords.CDy);
        CDpreviousPoint=new FloatPoint(0, 0);
        CDballXVelocity=0.0f;
        CDballYVelocity=0.0f;
        //Log.d("LifeCycleTest","loadTheBall");
        CDAccelData=new XYZCoords(0,0,0);
        //displayWidth=getWindowManager().getDefaultDisplay().getWidth();
        //displayWidth=getWindowManager().getDefaultDisplay().getHeight()/5;
        startAcclerometerUpdates(CDcontext);
        CDheight=50;
        CDwidth=50;
        CDScore=0;
        //lastTime=System.currentTimeMillis();


        ;	}


    private void loadImage(Context context, String filename)
    {
        try
        {
            AssetManager assetManager=context.getAssets();
            InputStream inputStream=assetManager.open(filename);
            CDourImage= BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            Log.d("LifeCycleTest","image found");

        }
        catch(IOException e)
        {
            //done nothing;
            Log.d("LifeCycleTest","image NOT found");

        }finally
        {
            //we should close our input stream here

        }
    }

    public void startAcclerometerUpdates(Context CDcontext)
    {
        SensorManager CDmanager=(SensorManager) CDcontext.getSystemService(Context.SENSOR_SERVICE);
        if (CDmanager.getSensorList(Sensor.TYPE_ACCELEROMETER).size()==0)
        {//we have no accelerometer
        	/*
        	xACoord.setText("No Accelerometer");
        	yACoord.setText("No Accelerometer");
        	zACoord.setText("No Accelerometer");
        	*/
        }else
        {

            Sensor accelerometer=CDmanager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            CDl1=new OurSensorListener(CDAccelData);
            Boolean couldRegisterListener=CDmanager.registerListener(CDl1, accelerometer, SensorManager.SENSOR_DELAY_GAME);
            if (!couldRegisterListener)
            {
                //could not register accelerometer
        		/*
        		xACoord.setText("Couldn't register Acceleromer Listener");
        		yACoord.setText("Couldn't register Acceleromer Listener");
        		zACoord.setText("Couldn't register Acceleromer Listener");
        		*/
            }
        }//close else (if accelerometer exists)


    }
    public void updatePosition(ClassShip CDship, ClassShip CDship2)
    {
        float deltaTime=(float)(CDlastTime-System.currentTimeMillis())/1000;
        Log.d("LifeCycleTest","time interval"+ String.valueOf(deltaTime));
        CDlastTime=System.currentTimeMillis();


		/*
		 timeAccumulator+=deltaTime;

		if (timeAccumulator>tick)
		{
			timeAccumulator-=tick;
			//moveShip();
			moveShipToPoint();


		}

		*/

        CDballXVelocity-=(CDAccelData.getX()*deltaTime);
        CDballYVelocity+=(CDAccelData.getY()*deltaTime);


        Float CDxCoordPlus=deltaTime*CDballXVelocity*50;
        Float CDyCoordPlus=deltaTime*CDballYVelocity*50;

        setCurrentPoint(CDcurrentPoint.CDx+CDxCoordPlus,CDcurrentPoint.CDy+CDyCoordPlus, CDship, CDship2);

    }
    public void setCurrentPoint(float CDxCoord, float CDyCoord, ClassShip CDship, ClassShip CDship2)
    {
        CDpreviousPoint.CDx=CDcurrentPoint.CDx;
        CDpreviousPoint.CDy=CDcurrentPoint.CDy;


        CDcurrentPoint.CDx=CDxCoord;
        CDcurrentPoint.CDy=CDyCoord;

        if(CDcurrentPoint.CDx<0)
        {
            CDcurrentPoint.CDx=0+CDwidth/2;
            CDballXVelocity*=-1;
            CDScore-=10;
        }

        if(CDcurrentPoint.CDy<0)
        {
            CDcurrentPoint.CDy=0+CDheight/2;
            CDballYVelocity*=-1;
            CDScore-=10;

        }

        if (CDcurrentPoint.CDx>(CDdisplayWidth-CDwidth/2))
        {
            CDcurrentPoint.CDx=CDdisplayWidth-CDwidth/2;

            CDballXVelocity*=-1;
            CDScore-=10;
        }

        if (CDcurrentPoint.CDy>(CDdisplayHeight-CDheight/2))
        {
            CDcurrentPoint.CDy=(CDdisplayHeight-CDheight/2);
            CDballYVelocity*=-1;
            CDScore-=10;
        }
        if(CDcurrentPoint.CDx==CDship.CDx)
        {
            CDballXVelocity*=-1;
            CDScore-=10;
        }

        if(CDcurrentPoint.CDy==CDship.CDy)
        {
            CDballYVelocity*=-1;
            CDScore-=10;

        }

        if(this.overlapsWith(CDship))
        {
            CDballXVelocity*=-1;
            CDballYVelocity*=-1;
            CDScore+=10;

        }
        if(this.overlapsWith(CDship2))
        {
            CDballXVelocity*=-1;
            CDballYVelocity*=-1;
            CDScore+=10;

        }





    }
    public boolean overlapsWith(ClassShip CDship)
    {
        if (CDship!=null) {
            boolean CDtemp = true;
            float CDdeltaX = Math.abs(this.CDcurrentPoint.CDx - CDship.CDx);
            float CDdeltaY = Math.abs(this.CDcurrentPoint.CDy - CDship.CDy);

            CDtemp = CDtemp && (CDdeltaX < (this.CDwidth / 2 + CDship.CDmyWidth / 2));
            CDtemp = CDtemp && (CDdeltaY < (this.CDheight / 2 + CDship.CDmyHeight / 2));

            return CDtemp;
        }else
            return false;
    }

}
