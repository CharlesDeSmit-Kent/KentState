package florin.lccc.drawings2017;

/**
 *
 */
public class Dot {

    private float x,y;
    private int color;
    private int diameter;

    public Dot(float x, float oury, int color, int diameter)
    {
        this.x=x;
        y=oury;
        //this.y=oury;
        this.color=color;
        this.diameter=diameter;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public int getColor()
    {
        return color;
    }

    public int getDiameter()
    {
        return diameter;
    }
}
