package com.lorainccc.natebirkas.nblabyrinth;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class ClassBall {

    public Bitmap ourImage;
    public FloatPoint currentPoint;
    public FloatPoint previousPoint;
    public nbCoordinates AccelData;
    //ClassPaddle paddle;
    //ClassBall ball;
    public float ballXVelocity;
    public float ballYVelocity;
    public OurSensorListener l1;
    public int displayWidth;
    public int displayHeight;
    public long lastTime;
    public int width;
    public int height;
    //ClassDead nbdead1;
    public LinkedList<ClassBrick> Bricks;
    //static int nbBonusBalls;


    public ClassBall(Context context, FloatPoint coords, String filename)
    {
        //super(context,coords,filename);
        loadImage(context, filename);
        currentPoint=new FloatPoint(coords.x, coords.y);
        previousPoint=new FloatPoint(0, 0);
        ballXVelocity=0.0f;
        ballYVelocity=0.0f;
        //Log.d("LifeCycleTest","loadTheBall");
        AccelData=new nbCoordinates(0,0,0);
        //displayWidth=getWindowManager().getDefaultDisplay().getWidth();
        //displayWidth=getWindowManager().getDefaultDisplay().getHeight()/5;
        startAcclerometerUpdates(context);
        height=30;
        width=30;
        //Vx=8.0f;
        //Vy=12.0f;
        //myWidth=50;
        //myHeight=50;
        //paddle=null;
        //Bricks=null;
        //tick=0.005f;
    }
    private void loadImage(Context context, String filename)
    {
        try
        {
            AssetManager assetManager=context.getAssets();
            InputStream inputStream=assetManager.open(filename);
            ourImage=BitmapFactory.decodeStream(inputStream);
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


    public void startAcclerometerUpdates(Context context)
    {
        SensorManager manager=(SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size()==0)
        {//we have no accelerometer
        	/*
        	xACoord.setText("No Accelerometer");
        	yACoord.setText("No Accelerometer");
        	zACoord.setText("No Accelerometer");
        	*/
        }else
        {

            Sensor accelerometer=manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            l1=new OurSensorListener(AccelData);
            Boolean couldRegisterListener=manager.registerListener(l1, accelerometer, SensorManager.SENSOR_DELAY_GAME);
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

    public void updatePosition()
    {
        float deltaTime=(float)(lastTime-System.currentTimeMillis())/1000;
        Log.d("LifeCycleTest","time interval"+ String.valueOf(deltaTime));
        lastTime=System.currentTimeMillis();


		/*
		 timeAccumulator+=deltaTime;

		if (timeAccumulator>tick)
		{
			timeAccumulator-=tick;
			//moveShip();
			moveShipToPoint();


		}

		*/

        ballXVelocity-=(AccelData.getX()*deltaTime);
        ballYVelocity+=(AccelData.getY()*deltaTime);


        Float xCoordPlus=deltaTime*ballXVelocity*50;
        Float yCoordPlus=deltaTime*ballYVelocity*50;

        setCurrentPoint(currentPoint.x+xCoordPlus,currentPoint.y+yCoordPlus);

        //FloatPoint coords2=new FloatPoint(100,100);

        /*
        if (this.overlapsWith(paddle))
        {
            //bounce from paddle rudimentary to change with a better bouncing
            this.Vy*=-1;
            float maxVx=5.0f;
            this.Vx=maxVx*((this.x-paddle.x)/(paddle.myWidth/2));
            //insert paddle bounce sound here
        };
        */

        /*

        for (ClassBrick nbBrick01:Bricks)
        {
            if (nbBrick01.visible)
            {
                if (this.overlapsWith(nbBrick01))

                {
                    nbBrick01.bounceFromBrick(this);
                    nbBrick01.visible = false;

                    //ball = new ClassBall(android.content.Context, coords2, "ball.png");

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick02:Bricks)
        {
            if (nbBrick02.visible)
            {
                if (this.overlapsWith(nbBrick02)) {

                    nbBrick02.bounceFromBrick(this);
                    nbBrick02.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick03:Bricks)
        {
            if (nbBrick03.visible)
            {
                if (this.overlapsWith(nbBrick03)) {

                    nbBrick03.bounceFromBrick(this);
                    nbBrick03.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick04:Bricks)
        {
            if (nbBrick04.visible)
            {
                if (this.overlapsWith(nbBrick04)) {

                    nbBrick04.bounceFromBrick(this);
                    nbBrick04.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick05:Bricks)
        {
            if (nbBrick05.visible)
            {
                if (this.overlapsWith(nbBrick05)) {

                    nbBrick05.bounceFromBrick(this);
                    nbBrick05.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick06:Bricks)
        {
            if (nbBrick06.visible)
            {
                if (this.overlapsWith(nbBrick06)) {

                    nbBrick06.bounceFromBrick(this);
                    nbBrick06.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick07:Bricks)
        {
            if (nbBrick07.visible)
            {
                if (this.overlapsWith(nbBrick07)) {

                    nbBrick07.bounceFromBrick(this);
                    nbBrick07.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick08:Bricks)
        {
            if (nbBrick08.visible)
            {
                if (this.overlapsWith(nbBrick08)) {

                    nbBrick08.bounceFromBrick(this);
                    nbBrick08.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick01R2:Bricks)
        {
            if (nbBrick01R2.visible)
            {
                if (this.overlapsWith(nbBrick01R2)) {

                    nbBrick01R2.bounceFromBrick(this);
                    nbBrick01R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick02R2:Bricks)
        {
            if (nbBrick02R2.visible)
            {
                if (this.overlapsWith(nbBrick02R2)) {

                    nbBrick02R2.bounceFromBrick(this);
                    nbBrick02R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick03R2:Bricks)
        {
            if (nbBrick03R2.visible)
            {
                if (this.overlapsWith(nbBrick03R2)) {

                    nbBrick03R2.bounceFromBrick(this);
                    nbBrick03R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick04R2:Bricks)
        {
            if (nbBrick04R2.visible)
            {
                if (this.overlapsWith(nbBrick04R2)) {

                    nbBrick04R2.bounceFromBrick(this);
                    nbBrick04R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick05R2:Bricks)
        {
            if (nbBrick05R2.visible)
            {
                if (this.overlapsWith(nbBrick05R2)) {

                    nbBrick05R2.bounceFromBrick(this);
                    nbBrick05R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick06R2:Bricks) //extra balls
        {
            if (nbBrick06R2.visible)
            {
                if (this.overlapsWith(nbBrick06R2)) {

                    //nbBonusBalls++;
                    nbBrick06R2.bounceFromBrick(this);
                    nbBrick06R2.visible = false;

                    //Breakout  cls2= new Breakout();
                    //cls2.nbBonusCollide();

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick07R2:Bricks)
        {
            if (nbBrick07R2.visible)
            {
                if (this.overlapsWith(nbBrick07R2)) {

                    nbBrick07R2.bounceFromBrick(this);
                    nbBrick07R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick08R2:Bricks)
        {
            if (nbBrick08R2.visible)
            {
                if (this.overlapsWith(nbBrick08R2)) {

                    nbBrick08R2.bounceFromBrick(this);
                    nbBrick08R2.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick01R3:Bricks)
        {
            if (nbBrick01R3.visible)
            {
                if (this.overlapsWith(nbBrick01R3)) {

                    nbBrick01R3.bounceFromBrick(this);
                    nbBrick01R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick02R3:Bricks)
        {
            if (nbBrick02R3.visible)
            {
                if (this.overlapsWith(nbBrick02R3)) {

                    nbBrick02R3.bounceFromBrick(this);
                    nbBrick02R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick03R3:Bricks)
        {
            if (nbBrick03R3.visible)
            {
                if (this.overlapsWith(nbBrick03R3)) {

                    nbBrick03R3.bounceFromBrick(this);
                    nbBrick03R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick04R3:Bricks)
        {
            if (nbBrick04R3.visible)
            {
                //nbBrick04R3.visible=false;
                if (this.overlapsWith(nbBrick04R3)) {

                    nbBrick04R3.bounceFromBrick(this);
                    //nbBrick04R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick05R3:Bricks)
        {
            if (nbBrick05R3.visible)
            {
                if (this.overlapsWith(nbBrick05R3)) {

                    nbBrick05R3.bounceFromBrick(this);
                    nbBrick05R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick06R3:Bricks)
        {
            if (nbBrick06R3.visible)
            {
                if (this.overlapsWith(nbBrick06R3)) {

                    nbBrick06R3.bounceFromBrick(this);
                    nbBrick06R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick07R3:Bricks)
        {
            if (nbBrick07R3.visible)
            {
                if (this.overlapsWith(nbBrick07R3)) {

                    nbBrick07R3.bounceFromBrick(this);
                    nbBrick07R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }

        for (ClassBrick nbBrick08R3:Bricks)
        {
            if (nbBrick08R3.visible)
            {
                if (this.overlapsWith(nbBrick08R3)) {

                    nbBrick08R3.bounceFromBrick(this);
                    nbBrick08R3.visible = false;

                    //insert event for playing brick break sound here
                }
            }
        }
        */
    }

    public void setCurrentPoint(float xCoord, float yCoord)
    {
        //-(void) setCurrentPoint:(CGPoint)newPoint
        //{
        previousPoint.x=currentPoint.x;
        previousPoint.y=currentPoint.y;


        //	    currentPoint=newPoint;
        currentPoint.x=xCoord;
        currentPoint.y=yCoord;

        if(currentPoint.x<0)
        {
            currentPoint.x=0+width/2;
            //ballXVelocity=0.0f;
            ballXVelocity*=-1;
        }

        if(currentPoint.y<0)
        {
            currentPoint.y=0+height/2;
            //ballYVelocity=0.0f;
            ballYVelocity*=-1;

        }

        // if(currentPoint.x>bounds.size.width-image.size.width)
        if (currentPoint.x>(displayWidth-width/2))
        {
            //currentPoint.x=self.bounds.size.width-image.size.width;
            currentPoint.x=displayWidth-width/2;

            // ballXVelocity=0;
            ballXVelocity*=-1;
        }

        //if(currentPoint.y>self.bounds.size.height-image.size.height)
        if (currentPoint.y>(displayHeight-height/2))
        {
            // currentPoint.y=self.bounds.size.height-image.size.height;
            currentPoint.y=(displayHeight-height/2);
            //ballYVelocity=0;
            ballYVelocity*=-1;
        }
/*
		CGRect currentImageRect=CGRectMake(currentPoint.x, currentPoint.y, currentPoint.x+image.size.width, currentPoint.y+image.size.height);


		CGRect previousImageRect=CGRectMake(previousPoint.x, previousPoint.y, previousPoint.x+image.size.width, previousPoint.y+image.size.height);


		[self setNeedsDisplayInRect:CGRectUnion(currentImageRect, previousImageRect)];
*/


    }
}
