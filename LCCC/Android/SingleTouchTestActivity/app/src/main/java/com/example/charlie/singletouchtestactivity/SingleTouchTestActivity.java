package com.example.charlie.singletouchtestactivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
public class SingleTouchTestActivity extends Activity implements OnTouchListener{
    /** Called when the activity is first created. */
StringBuilder builder=new StringBuilder();
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_touch_test);
        textView=new TextView(this);
        textView.setText("Touch and drag (one finger only)");
        textView.setOnTouchListener(this);
        setContentView(textView);     }
    //no Override because is and abstract method that needs to be implemented
        public boolean onTouch(View v, MotionEvent event){
            builder.setLength(0);
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    builder.append("down, ");
                    break;
            case MotionEvent.ACTION_MOVE:
                builder.append("move, ");
            case MotionEvent.ACTION_CANCEL:
                builder.append("cancel, ");
                //same as move , not a really cancel event
                break;
            case MotionEvent.ACTION_UP:
                builder.append("up, ");
            break;
        }
            builder.append(event.getX());
            builder.append(event.getY());
            String text=builder.toString();
            Log.d("TouchTest", text);
            textView.setText(text);
            return true;
        }
}
