package com.desmit.charlie.project2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by Charlie on 5/8/2017.
 */

public class OurSensorListener implements SensorEventListener {

    private XYZCoords CDaccel;



    public OurSensorListener(XYZCoords accelValuesInBall)
    {
        CDaccel=accelValuesInBall;

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub

    }

    public void onSensorChanged(SensorEvent ourEvent) {
        // TODO Auto-generated method stub
        CDaccel.setX(ourEvent.values[0]);
        Log.d("LifeCycleTest","accel X="+CDaccel.getX());
        CDaccel.setY(ourEvent.values[1]);
        Log.d("LifeCycleTest","accel Y="+CDaccel.getY());
        CDaccel.setZ(ourEvent.values[2]);
        Log.d("LifeCycleTest","accel Z="+CDaccel.getZ());
        Log.d("LifeCycleTest","acceleration pulled");

    }

}
