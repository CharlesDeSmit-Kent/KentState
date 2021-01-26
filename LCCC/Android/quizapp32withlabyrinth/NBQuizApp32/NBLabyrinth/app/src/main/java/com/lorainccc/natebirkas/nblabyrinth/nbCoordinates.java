package com.lorainccc.natebirkas.nblabyrinth;

public class nbCoordinates {
    private float x;
    private float y;
    private float z;

    public nbCoordinates(float v1, float v2, float v3)
    {
        x=v1;
        y=v2;
        z=v3;
    };

    public float getX()
    {
        return (x);
    }
    public float getY()
    {
        return (y);
    }

    public float getZ()
    {
        return (z);
    }

    public void setX(float v1)
    {
        x=v1;
    }

    public void setY(float v1)
    {
        y=v1;
    }

    public void setZ(float v1)
    {
        z=v1;
    }

}
