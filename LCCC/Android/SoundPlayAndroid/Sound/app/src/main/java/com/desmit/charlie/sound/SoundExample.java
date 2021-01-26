package com.desmit.charlie.sound;

import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class SoundExample extends AppCompatActivity {

    Button playButton1;
    Button playButton2;
    Button stopButton1;
    Button stopButton2;
    MediaPlayer ourMediaPlayer;
    SoundPool ourShortSound;
    Boolean isPlaying=false;
    int explosionID;
    int streamID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_example);

        playButton1=(Button) findViewById(R.id.play1);
        stopButton1=(Button) findViewById(R.id.stop1);
        playButton2=(Button) findViewById(R.id.play2);
        stopButton2=(Button) findViewById(R.id.stop2);

        //with media player
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
        //end with SoundPool

        playButton1.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        doPlay1(v);

                    }
                }
        );

        playButton2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        doPlay2(v);

                    }
                }
        );


        stopButton1.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        doStop1(v);
                    }
                }
        );

        stopButton2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        doStop2(v);
                    }
                }
        );
    }//close onCreate

    // @SuppressWarnings("deprecation")
    //  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
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
    public void onStop(){
        super.onStop();
        ourMediaPlayer.release();
        ourShortSound.unload(explosionID);
    }





}
