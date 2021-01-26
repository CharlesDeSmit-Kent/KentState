package com.lorainccc.natebirkas.nblabyrinth;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
//import android.widget.TextView;

public class OurSensorListener implements SensorEventListener {

    private nbCoordinates accel;



    public OurSensorListener(nbCoordinates accelValuesInBall)
    {
        accel=accelValuesInBall;

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub

    }

    public void onSensorChanged(SensorEvent ourEvent) {
        // TODO Auto-generated method stub
        accel.setX(ourEvent.values[0]);
        Log.d("LifeCycleTest","accel X="+accel.getX());
        accel.setY(ourEvent.values[1]);
        Log.d("LifeCycleTest","accel Y="+accel.getY());
        accel.setZ(ourEvent.values[2]);
        Log.d("LifeCycleTest","accel Z="+accel.getZ());
        Log.d("LifeCycleTest","acceleration pulled");

    }

}
