package florin.lccc.drawings2017;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;


public class Drawings extends Activity {

    OurView theView;
    LinearLayout theroot;
    int ourHeight;
    int ourWidth;
    EditText xTextCoord;
    EditText yTextCoord;
    Button redButton;
    Button greenButton;
    Dot theDot;
    Dots dots=new Dots();
    public static final int DOT_DIAMETER = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawings);

        theroot = (LinearLayout) (findViewById(R.id.root));

        calculateWindowSize();
        theView = new OurView(this, ourHeight, ourWidth);
        theroot.addView(theView, 0);

        xTextCoord = (EditText) findViewById(R.id.text1);
        yTextCoord = (EditText) findViewById(R.id.text2);

        redButton = (Button) findViewById(R.id.button1);
        greenButton = (Button) findViewById(R.id.button2);
        Button.OnClickListener ourListener = new Button.OnClickListener() {
            public void onClick(View v) {
                doButtons(v);
            }

            ;
        };

        redButton.setOnClickListener(ourListener);
        greenButton.setOnClickListener(ourListener);



/*
        View.OnTouchListener ourTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (MotionEvent.ACTION_DOWN != event.getAction()) {
                    makeDots(event.getX(), event.getY(), Color.CYAN, DOT_DIAMETER);
                }//close if
                return true;
            }//close onTouch
        };//close listener


        theView.setOnTouchListener(ourTouchListener);
*/
        OurTouchListener ourTouch=new OurTouchListener(theView);
        theView.setOnTouchListener(ourTouch);
    };//close onCreate


    public void doButtons(View v)
    {
        Random rand=new Random();

        xTextCoord.setText(String.valueOf(rand.nextInt(ourWidth)));
        yTextCoord.setText(String.valueOf(rand.nextInt(ourHeight)));

        float x=Float.parseFloat(xTextCoord.getText().toString());
        float y=Float.parseFloat(yTextCoord.getText().toString());

        if (v==greenButton) {
            //make dot obj not the graphic with green coord s

            //random diameter up to 40
            //
            makeDots(x, y, Color.GREEN, rand.nextInt(40) + 1);
        }

        if (v==redButton)
        {
            //make dot obj with red coords
            makeDots(x, y, Color.RED, rand.nextInt(40) + 1);
        }
        // theView.setDot(theDot);
        // theView.invalidate();

    }


    public void makeDots(float x, float y, int color, int diameter)
    {
        //theDot=new Dot(x,y,color,diameter);
        dots.AddDot(x,y,color,diameter);
        theView.setDots(dots);
        theView.invalidate();

    }



    public void calculateWindowSize()
    {
        DisplayMetrics displayMetrics=new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.widthPixels;
        int screnHeight=displayMetrics.heightPixels;

        ourHeight=3*screnHeight/5;
        ourWidth=screenWidth-theroot.getPaddingLeft()-theroot.getPaddingRight();


    }

}
