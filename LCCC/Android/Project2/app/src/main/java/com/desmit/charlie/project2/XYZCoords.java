package com.desmit.charlie.project2;

/**
 * Created by Charlie on 5/8/2017.
 */

public class XYZCoords {
    private float CDx;
    private float CDy;
    private float CDz;

    public XYZCoords(float CDv1, float CDv2, float CDv3)
    {
        CDx=CDv1;
        CDy=CDv2;
        CDz=CDv3;
    };

    public float getX()
    {
        return (CDx);
    }
    public float getY()
    {
        return (CDy);
    }

    public float getZ()
    {
        return (CDz);
    }

    public void setX(float CDv1)
    {
        CDx=CDv1;
    }

    public void setY(float CDv1)
    {
        CDy=CDv1;
    }

    public void setZ(float CDv1)
    {
        CDz=CDv1;
    }

}
