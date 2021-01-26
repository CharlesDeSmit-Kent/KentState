package com.example.charlie.lifecycle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle; import android.util.Log;
import android.widget.TextView;

public class LifeCycle extends AppCompatActivity {
    String ourString;
    TextView ourTextView;
    private void log(String bubu){
        Log.d("LifeCycleTest",bubu);
        ourString+=bubu;
        ourString+="\n";
        ourTextView.setText(ourString);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        ourString="";
        ourTextView=new TextView(this);
        ourTextView.setText(ourString);
        setContentView(ourTextView);
        log("created");     }
    @Override
    protected void onResume()     {
        super.onResume();
        log("resumed");     }
    @Override
    protected void onPause() {
        super.onPause();
        log("paused");
        if(isFinishing()) {
          log("finishing");
        }
    }
}