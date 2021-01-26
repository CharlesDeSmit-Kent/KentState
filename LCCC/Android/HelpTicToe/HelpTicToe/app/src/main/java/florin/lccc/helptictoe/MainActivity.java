package florin.lccc.helptictoe;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageButton> buttons=new ArrayList<ImageButton>();
    EditText ourText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ourText=(EditText)findViewById((R.id.editText));

        Button.OnClickListener ourListener=new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                doButtons(v);
            }
        };
        String bubu=new String("imageButton");


        Resources res = this.getResources();
        int id;

        for (int i=1; i<=9;i++)
        {
            id = res.getIdentifier(bubu + String.valueOf(i), "id", this.getPackageName());
            ImageButton temp = ((ImageButton) findViewById(id));
            temp.setOnClickListener(ourListener);
            buttons.add(temp);
            buttons.get(i);

        }
    }//close onCreate

    public void doButtons(View b)
    {
        ImageButton ourButton=(ImageButton) b;
        ourButton.setImageResource(R.mipmap.tico);
        //ourText.setText(t.toString());
    }

}//close activity class
