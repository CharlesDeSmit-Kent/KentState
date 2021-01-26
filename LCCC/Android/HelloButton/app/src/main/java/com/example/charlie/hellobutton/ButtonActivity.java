package com.example.charlie.hellobutton;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends Activity implements View.OnClickListener {
    Button ourButton;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        counter=0;
        ourButton=new Button(this);
        ourButton.setText("Touch Me");
        ourButton.setOnClickListener(this);
        setContentView(ourButton);
    }
    public void onClick(View v)
    {
        counter++;
        ourButton.setText("Hello! Button pressed "+counter+" time(s)");
    }
}