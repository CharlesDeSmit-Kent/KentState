package com.desmit.charlie.project2;

import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    RendererView CDourView;
    StringBuilder CDbuilder=new StringBuilder();
    ClassShip CDship;
    ClassShip CDship2;
    BallClass CDball;
    public int CDwindowWidth;
    public int CDwindowHeight;
    MediaPlayer ourMediaPlayer;
    SoundPool ourShortSound;
    Boolean isPlaying=false;
    int explosionID;
    int streamID;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //in app compat activity you also need below
        getSupportActionBar().hide();


        FloatPoint CDcoords=new FloatPoint(100,100);
        CDship=new ClassShip(this, CDcoords, "viper.png");

        FloatPoint CDcoords2=new FloatPoint(0,0);
        CDball=new BallClass(this,CDcoords2, "ball.png");

        FloatPoint CDcoords3=new FloatPoint(450,1000);
        CDship2=new ClassShip(this, CDcoords3, "ball.png");

        CDourView=new RendererView(this,CDship,CDship2, CDball);

        setContentView(CDourView);

        Rect CDdim=new Rect();

        CDourView.getWindowVisibleDisplayFrame(CDdim);

        CDball.CDcurrentPoint.CDx=CDdim.centerX();
        CDball.CDcurrentPoint.CDy=CDdim.centerY();
        CDball.CDdisplayHeight=CDdim.height();
        CDball.CDdisplayWidth=CDdim.width();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //ship.x=ourView.getWidth()/2;
        //ship.y=ourView.getHeight()/2;

        CDourView.setOnTouchListener(new View.OnTouchListener()
        {


            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

                if (MotionEvent.ACTION_DOWN!= event.getAction())
                {
                    return false;
                }
                else
                {
					/*		ship.
					dots.addDot(event.getX(), event.getY(), Color.CYAN, 5);
					dotView.invalidate();  */
                    Log.d("LifeCycleTest","touched the screen");

                    CDship.CDmoveToPoint.CDx=event.getX();
                    CDship.CDmoveToPoint.CDy=event.getY();

                    return true;

                }//close else
            };//close onTouch
        });//close
        ourMediaPlayer=new MediaPlayer();
        try
        {
            AssetFileDescriptor afd = getAssets().openFd("ingamemusic.mp3");

            ourMediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());

        }
        catch(IOException e)
        {
            //done nothing;
            Toast.makeText(this, "File not Found", Toast.LENGTH_LONG).show();
        }
        //end with media player

        //with SoundPool old version
        //ourShortSound=new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

        ourShortSound=ourSoundBuild();

        try
        {
            AssetFileDescriptor secondFile = getAssets().openFd("explosion.mp3");
            explosionID=ourShortSound.load(secondFile, 1);

        }catch (IOException e)
        {
            Toast.makeText(this, "File not Found", Toast.LENGTH_LONG).show();
        }
        playMediaPlayer();
        isPlaying=true;

    }//close on create

    private static SoundPool ourSoundBuild() {
        SoundPool soundPool;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(25)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            //for older version android systems
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        return soundPool;
    }

    public void playMediaPlayer()
    {
        if (ourMediaPlayer!=null) {
            try {
                ourMediaPlayer.prepare();    //prepare needs a try
                ourMediaPlayer.seekTo(0);
            } catch (IOException e) {
                //done nothing;
                Toast.makeText(this, "Can not Prepare", Toast.LENGTH_LONG).show();
            }
            ourMediaPlayer.setLooping(true);
            ourMediaPlayer.setVolume(1.0f,1.0f);//left and right 0.0f min 1.0 max
            ourMediaPlayer.start();
        };
    }

    public void playSoundPool()
    {

        if (ourShortSound!=null) {
            streamID = ourShortSound.play(explosionID, 1.0f, 1.0f, 0, 0, 1);
            //1.0f and 1.0f sound volume left right
            //0 priority
            //0 number of times (once) if -1 infinite loop.

        }
    }

    public void doPlay1(View v)
    {
        //Toast.makeText(this, "We pressed Button Play", Toast.LENGTH_LONG).show();


        playSoundPool();


    }
    public void doPlay2(View v)
    {
        //   Toast.makeText(this, "We pressed Button Play2", Toast.LENGTH_LONG).show();
        if (isPlaying) doStop2(v); //you must stop it before you play it again
        playMediaPlayer();
        isPlaying=true;

    }

    public void doStop2(View v)
    {

        ourMediaPlayer.stop();
        isPlaying=false;
    }

    public void doStop1(View v)
    {

        ourShortSound.stop(streamID);

    }



    @Override
    protected void onResume(){
        super.onResume();

        log("resumed");
        CDourView.resume();//close onResume
    }
    @Override
    protected void onPause(){
        super.onPause();
        log("pausing");
        CDourView.pause();

    }
    @Override
    public void onStop(){
        super.onStop();
        ourMediaPlayer.release();
        ourShortSound.unload(explosionID);
    }

    private void log(String text){
        Log.d("LifeCycleTest",text);
        CDbuilder.append(text);
        CDbuilder.append('\n');
        //	textView.setText(builder.toString());
    }

}//close activity
