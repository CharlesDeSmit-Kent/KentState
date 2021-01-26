package com.example.charlie.project1;


import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import java.util.LinkedList;

public class MainBreakoutActivity extends AppCompatActivity {

    public int CDwindowHeight;
    public int CDwindowWidth;
    ClassOurSurfaceView CDourView;
    ClassBall CDball;
    ClassPaddle CDpaddle;
    ClassPowerUpBall CDextraBall;
    MediaPlayer CDMediaPlayer;
    SoundPool CDShortSound;
    Boolean isPlaying=false;
    int explosionID;
    int streamID;
    public LinkedList<ClassBrick> CDBricks=new LinkedList<ClassBrick>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //in app compat activity you also need below
        getSupportActionBar().hide();
        // windowHeight=getWindowManager().getDefaultDisplay().getHeight();
        //windowWidth=getWindowManager().getDefaultDisplay().getWidth();

        FloatPoint CDcoords2=new FloatPoint(100,100);
        CDball=new ClassBall(this, CDcoords2,"ball.png");
        CDpaddle=new ClassPaddle(this,CDcoords2,"Paddle.png");
        CDextraBall=new ClassPowerUpBall(this,CDcoords2,"ball.png");

        CDball.CDpaddle=CDpaddle;
        CDball.CDBricks=CDBricks;

        CDourView=new ClassOurSurfaceView(this,CDball,CDpaddle,CDextraBall,CDBricks);
        setContentView(CDourView);

        Rect dim=new Rect();
        CDourView.getWindowVisibleDisplayFrame(dim);
        CDwindowHeight=dim.height();
        CDwindowWidth=dim.width();

        //after we create the view
        CDball.CDwindowHeight=CDwindowHeight;
        CDball.CDwindowWidth=CDwindowWidth;
        CDball.CDx=CDwindowWidth/2;
        CDball.CDy=CDwindowHeight/2;

        CDpaddle.CDwindowHeight=CDwindowHeight;
        CDpaddle.CDwindowWidth=CDwindowWidth;
        CDpaddle.CDx=CDwindowWidth/2;
        CDpaddle.CDy=CDwindowHeight-6*CDpaddle.CDmyHeight;
        CDpaddle.CDtouchX=CDpaddle.CDx;
        CDpaddle.CDtouchY=CDpaddle.CDy;

        CDextraBall.CDwindowHeight=CDwindowHeight;
        CDextraBall.CDwindowWidth=CDwindowWidth;
        CDextraBall.CDx=-100+CDwindowWidth/2;
        CDextraBall.CDy=CDwindowHeight/2;

        ClassOurTouchListener theTouch=new ClassOurTouchListener(CDpaddle);

        CDourView.setOnTouchListener(theTouch);

        setupBricks();

        CDMediaPlayer=new MediaPlayer();
        try
        {
            AssetFileDescriptor afd = getAssets().openFd("ingamemusic.mp3");

            CDMediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());

        }
        catch(IOException e)
        {
            //done nothing;
            Toast.makeText(this, "File not Found", Toast.LENGTH_LONG).show();
        }
        //end with media player

        //with SoundPool old version
        //ourShortSound=new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

        CDShortSound=ourSoundBuild();

        try
        {
            AssetFileDescriptor secondFile = getAssets().openFd("explosion.mp3");
            explosionID=CDShortSound.load(secondFile, 1);

        }catch (IOException e)
        {
            Toast.makeText(this, "File not Found", Toast.LENGTH_LONG).show();
        }
        if (isPlaying) doStop2(); //you must stop it before you play it again
        playMediaPlayer();
        isPlaying=true;

    }
    public void setupBricks()
    {
        FloatPoint CDcoords;
        ClassBrick CDoneBrick;
        for (int i=0; i<10; i++)
        {
            //Random CDrand1 = new Random();
            //int CDnx = CDrand1.nextInt(10);
            //Random CDrand2 = new Random();
            //int CDny = CDrand2.nextInt(10)+1;
            CDcoords = new FloatPoint(10,10);
            CDoneBrick = new ClassBrick(this, CDcoords, "Paddle.png");
            CDoneBrick.CDHP=0;
            CDoneBrick.CDmyWidth=CDwindowWidth/10;
            CDoneBrick.CDmyHeight=CDoneBrick.CDourImage.getHeight()*10;
            CDoneBrick.CDwindowWidth=CDwindowWidth;
            CDoneBrick.CDwindowHeight=CDwindowHeight;
            CDoneBrick.CDx=i*CDoneBrick.CDmyWidth+CDoneBrick.CDmyWidth/2;
            CDoneBrick.CDy=CDoneBrick.CDmyHeight*3;
            CDoneBrick.CDourId=i;
            CDBricks.add(CDoneBrick);

        }
        for (int k=0; k<8; k++) {
            //Random CDrand1 = new Random();
            //int CDnx = CDrand1.nextInt(10);
            //Random CDrand2 = new Random();
            //int CDny = CDrand2.nextInt(10)+1;
            CDcoords = new FloatPoint(10,10);
            CDoneBrick = new ClassBrick(this, CDcoords, "Paddle2.png");
            CDoneBrick.CDHP=1;
            CDoneBrick.CDmyWidth=CDwindowWidth/10;
            CDoneBrick.CDmyHeight=CDoneBrick.CDourImage.getHeight()*10;
            CDoneBrick.CDwindowWidth=CDwindowWidth;
            CDoneBrick.CDwindowHeight=CDwindowHeight;
            CDoneBrick.CDx=k*CDoneBrick.CDmyWidth+3*CDoneBrick.CDmyWidth/2;
            CDoneBrick.CDy=CDoneBrick.CDmyHeight*4;
            CDoneBrick.CDourId=k+10;
            CDBricks.add(CDoneBrick);
        }
        for (int j=0; j<6; j++) {
            //Random CDrand1 = new Random();
            //int CDnx = CDrand1.nextInt(10);
            //Random CDrand2 = new Random();
            //int CDny = CDrand2.nextInt(10)+1;
            CDcoords = new FloatPoint(10,10);
            CDoneBrick = new ClassBrick(this, CDcoords, "Paddle.png");
            CDoneBrick.CDHP=0;
            CDoneBrick.CDmyWidth=CDwindowWidth/10;
            CDoneBrick.CDmyHeight=CDoneBrick.CDourImage.getHeight()*10;
            CDoneBrick.CDwindowWidth=CDwindowWidth;
            CDoneBrick.CDwindowHeight=CDwindowHeight;
            CDoneBrick.CDx=j*CDoneBrick.CDmyWidth+5*CDoneBrick.CDmyWidth/2;
            CDoneBrick.CDy=CDoneBrick.CDmyHeight*5;
            CDoneBrick.CDourId=j+18;
            CDBricks.add(CDoneBrick);
        }

    }

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
        if (CDMediaPlayer!=null) {
            try {
                CDMediaPlayer.prepare();
                CDMediaPlayer.seekTo(0);
            } catch (IOException e) {
                Toast.makeText(this, "Can not Prepare", Toast.LENGTH_LONG).show();
            }
            CDMediaPlayer.setLooping(true);
            CDMediaPlayer.setVolume(1.0f,1.0f);//left and right 0.0f min 1.0 max
            CDMediaPlayer.start();
        };
    }

    public void playSoundPool()
    {

        if (CDShortSound!=null) {
            streamID = CDShortSound.play(explosionID, 1.0f, 1.0f, 0, 0, 1);

        }
    }

    public void doPlay1()
    {

        playSoundPool();


    }
    public void doPlay2()
    {
        if (isPlaying) doStop2();
        playMediaPlayer();
        isPlaying=true;

    }
    public void doStop2()
    {

        CDMediaPlayer.stop();
        isPlaying=false;
    }

    public void doStop1()
    {

        CDShortSound.stop(streamID);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        CDourView.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        CDourView.pause();

    }
    @Override
    public void onStop(){
        super.onStop();
        CDMediaPlayer.release();
        CDShortSound.unload(explosionID);
    }
}
