package florin.lccc.thebreakout;

/**
 * Created by uc224 on 4/18/17.
 */
import android.content.Context;

public class ClassBrick extends MovingComponent {
    public Boolean visible=true;
    public int ourId;

    public ClassBrick(Context context, FloatPoint coords, String filename )
    {


        super(context, coords, filename);
        Vx=0.0f;
        Vy=0.0f;
        myHeight=ourImage.getHeight()*2;
        myWidth=ourImage.getWidth();
        //myWidth=windowWidth/10;
    }

    public void bounceFromBrick(MovingComponent ball)
    {
        //rudimentary  brick bounce
        if ((this.x+this.myWidth/2)<ball.x)ball.Vx*=-1;
        else if ((this.x-this.myWidth/2)>ball.x) ball.Vx*=-1;
        else if ((this.y-this.myHeight/2)>ball.y) ball.Vy*=-1;
        else if ((this.y+this.myHeight/2)<ball.y) ball.Vy*=-1;
        else ball.Vy*=-1;

    }

}