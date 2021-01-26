package com.lorainccc.natebirkas.nblabyrinth;

import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.LinkedList;

public class Breakout extends AppCompatActivity {

    public int windowHeight;
    public int windowWidth;
    ClassOurSurfaceView ourView;
    ClassBall ball;
    //ClassDead nbdead1;
    public LinkedList<ClassBrick> Bricks=new LinkedList<ClassBrick>();
    public ClassBrick nbBrick01;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        FloatPoint coords2=new FloatPoint(0,0);

        ball=new ClassBall(this, coords2, "ball.png");
        //paddle=new ClassPaddle(this, coords2, "nbPaddle.png");
        //nbdead1=new ClassDead(this, coords2, "nbDead.png");

        ball.Bricks=Bricks;
        //ball.nbdead=nbdead;

        ourView=new ClassOurSurfaceView(this,ball,Bricks);
        setContentView(ourView);

        Rect dim=new Rect();
        ourView.getWindowVisibleDisplayFrame(dim);
        windowHeight=dim.height();
        windowWidth=dim.width();

        //ball.windowHeight=windowHeight;
        //ball.windowWidth=windowWidth;
        ball.currentPoint.x=dim.centerX();
        ball.currentPoint.y=dim.centerY();
        ball.displayHeight=dim.height();
        ball.displayWidth=dim.width();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setupBricks();

    }


    public void setupBricks()
    {
        FloatPoint coords;
        coords = new FloatPoint(10, 10);
        //init the bricks
        ClassBrick nbBrick01;
        ClassBrick nbBrick02;
        ClassBrick nbBrick03;
        ClassBrick nbBrick04;
        ClassBrick nbBrick05;
        ClassBrick nbBrick06;
        ClassBrick nbBrick07;
        ClassBrick nbBrick08;
        ClassBrick nbBrick01R2;
        ClassBrick nbBrick02R2;
        ClassBrick nbBrick03R2;
        ClassBrick nbBrick04R2;
        ClassBrick nbBrick05R2;
        ClassBrick nbBrick06R2;
        ClassBrick nbBrick07R2;
        ClassBrick nbBrick08R2;
        ClassBrick nbBrick01R3;
        ClassBrick nbBrick02R3;
        ClassBrick nbBrick03R3;
        ClassBrick nbBrick04R3;
        ClassBrick nbBrick05R3;
        ClassBrick nbBrick06R3;
        ClassBrick nbBrick07R3;
        ClassBrick nbBrick08R3;

        //brick 01
        nbBrick01 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick01.myWidth=windowWidth/10;
        nbBrick01.myHeight=nbBrick01.ourImage.getHeight()*6;
        nbBrick01.windowWidth=windowWidth;
        nbBrick01.windowHeight=windowHeight;
        nbBrick01.x=1*nbBrick01.myWidth+nbBrick01.myWidth/2;
        nbBrick01.y=nbBrick01.myHeight*3;
        Bricks.add(nbBrick01);

        //brick 02
        nbBrick02 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick02.myWidth=windowWidth/10;
        nbBrick02.myHeight=nbBrick02.ourImage.getHeight()*6;
        nbBrick02.windowWidth=windowWidth;
        nbBrick02.windowHeight=windowHeight;
        nbBrick02.x=2*nbBrick02.myWidth+nbBrick02.myWidth/2;
        nbBrick02.y=nbBrick02.myHeight*3;
        Bricks.add(nbBrick02);

        //brick 03
        nbBrick03 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick03.myWidth=windowWidth/10;
        nbBrick03.myHeight=nbBrick03.ourImage.getHeight()*6;
        nbBrick03.windowWidth=windowWidth;
        nbBrick03.windowHeight=windowHeight;
        nbBrick03.x=3*nbBrick03.myWidth+nbBrick03.myWidth/2;
        nbBrick03.y=nbBrick03.myHeight*3;
        Bricks.add(nbBrick03);

        //brick 04
        nbBrick04 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick04.myWidth=windowWidth/10;
        nbBrick04.myHeight=nbBrick04.ourImage.getHeight()*6;
        nbBrick04.windowWidth=windowWidth;
        nbBrick04.windowHeight=windowHeight;
        nbBrick04.x=4*nbBrick04.myWidth+nbBrick04.myWidth/2;
        nbBrick04.y=nbBrick04.myHeight*3;
        Bricks.add(nbBrick04);

        //brick 05 extra life powerup
        nbBrick05 = new ClassBrick(this, coords, "nbBrick4.png");
        nbBrick05.myWidth=windowWidth/10;
        nbBrick05.myHeight=nbBrick05.ourImage.getHeight()*6;
        nbBrick05.windowWidth=windowWidth;
        nbBrick05.windowHeight=windowHeight;
        nbBrick05.x=5*nbBrick05.myWidth+nbBrick05.myWidth/2;
        nbBrick05.y=nbBrick05.myHeight*3;
        Bricks.add(nbBrick05);

        //brick 06
        nbBrick06 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick06.myWidth=windowWidth/10;
        nbBrick06.myHeight=nbBrick06.ourImage.getHeight()*6;
        nbBrick06.windowWidth=windowWidth;
        nbBrick06.windowHeight=windowHeight;
        nbBrick06.x=6*nbBrick06.myWidth+nbBrick06.myWidth/2;
        nbBrick06.y=nbBrick06.myHeight*3;
        Bricks.add(nbBrick06);

        //brick 07
        nbBrick07 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick07.myWidth=windowWidth/10;
        nbBrick07.myHeight=nbBrick07.ourImage.getHeight()*6;
        nbBrick07.windowWidth=windowWidth;
        nbBrick07.windowHeight=windowHeight;
        nbBrick07.x=7*nbBrick07.myWidth+nbBrick07.myWidth/2;
        nbBrick07.y=nbBrick07.myHeight*3;
        Bricks.add(nbBrick07);

        //brick 08
        nbBrick08 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick08.myWidth=windowWidth/10;
        nbBrick08.myHeight=nbBrick08.ourImage.getHeight()*6;
        nbBrick08.windowWidth=windowWidth;
        nbBrick08.windowHeight=windowHeight;
        nbBrick08.x=8*nbBrick08.myWidth+nbBrick08.myWidth/2;
        nbBrick08.y=nbBrick08.myHeight*3;
        Bricks.add(nbBrick08);

        //brick 01R2
        nbBrick01R2 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick01R2.myWidth=windowWidth/10;
        nbBrick01R2.myHeight=nbBrick01R2.ourImage.getHeight()*6;
        nbBrick01R2.windowWidth=windowWidth;
        nbBrick01R2.windowHeight=windowHeight;
        nbBrick01R2.x=1*nbBrick01R2.myWidth+nbBrick01R2.myWidth/2;
        nbBrick01R2.y=nbBrick01R2.myHeight*3+100;
        Bricks.add(nbBrick01R2);

        //brick 02R2 longer paddle powerup
        nbBrick02R2 = new ClassBrick(this, coords, "nbBrick3.png");
        nbBrick02R2.myWidth=windowWidth/10;
        nbBrick02R2.myHeight=nbBrick02R2.ourImage.getHeight()*6;
        nbBrick02R2.windowWidth=windowWidth;
        nbBrick02R2.windowHeight=windowHeight;
        nbBrick02R2.x=2*nbBrick02R2.myWidth+nbBrick02R2.myWidth/2;
        nbBrick02R2.y=nbBrick02R2.myHeight*3+100;
        Bricks.add(nbBrick02R2);

        //brick 03R2
        nbBrick03R2 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick03R2.myWidth=windowWidth/10;
        nbBrick03R2.myHeight=nbBrick03.ourImage.getHeight()*6;
        nbBrick03R2.windowWidth=windowWidth;
        nbBrick03R2.windowHeight=windowHeight;
        nbBrick03R2.x=3*nbBrick03R2.myWidth+nbBrick03R2.myWidth/2;
        nbBrick03R2.y=nbBrick03R2.myHeight*3+100;
        Bricks.add(nbBrick03R2);

        //brick 04R2
        nbBrick04R2 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick04R2.myWidth=windowWidth/10;
        nbBrick04R2.myHeight=nbBrick04.ourImage.getHeight()*6;
        nbBrick04R2.windowWidth=windowWidth;
        nbBrick04R2.windowHeight=windowHeight;
        nbBrick04R2.x=4*nbBrick04R2.myWidth+nbBrick04R2.myWidth/2;
        nbBrick04R2.y=nbBrick04R2.myHeight*3+100;
        Bricks.add(nbBrick04R2);

        //brick 05R2
        nbBrick05R2 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick05R2.myWidth=windowWidth/10;
        nbBrick05R2.myHeight=nbBrick05.ourImage.getHeight()*6;
        nbBrick05R2.windowWidth=windowWidth;
        nbBrick05R2.windowHeight=windowHeight;
        nbBrick05R2.x=5*nbBrick05R2.myWidth+nbBrick05R2.myWidth/2;
        nbBrick05R2.y=nbBrick05R2.myHeight*3+100;
        Bricks.add(nbBrick05R2);

        //brick 06R2 extra balls bonus
        nbBrick06R2 = new ClassBrick(this, coords, "nbBrick5.png");
        nbBrick06R2.myWidth=windowWidth/10;
        nbBrick06R2.myHeight=nbBrick06.ourImage.getHeight()*6;
        nbBrick06R2.windowWidth=windowWidth;
        nbBrick06R2.windowHeight=windowHeight;
        nbBrick06R2.x=6*nbBrick06R2.myWidth+nbBrick06R2.myWidth/2;
        nbBrick06R2.y=nbBrick06R2.myHeight*3+100;
        Bricks.add(nbBrick06R2);

        //brick 07R2
        nbBrick07R2 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick07R2.myWidth=windowWidth/10;
        nbBrick07R2.myHeight=nbBrick07.ourImage.getHeight()*6;
        nbBrick07R2.windowWidth=windowWidth;
        nbBrick07R2.windowHeight=windowHeight;
        nbBrick07R2.x=7*nbBrick07R2.myWidth+nbBrick07R2.myWidth/2;
        nbBrick07R2.y=nbBrick07R2.myHeight*3+100;
        Bricks.add(nbBrick07R2);

        //brick 08R2
        nbBrick08R2 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick08R2.myWidth=windowWidth/10;
        nbBrick08R2.myHeight=nbBrick08.ourImage.getHeight()*6;
        nbBrick08R2.windowWidth=windowWidth;
        nbBrick08R2.windowHeight=windowHeight;
        nbBrick08R2.x=8*nbBrick08R2.myWidth+nbBrick08R2.myWidth/2;
        nbBrick08R2.y=nbBrick08R2.myHeight*3+100;
        Bricks.add(nbBrick08R2);

        //brick 01R3
        nbBrick01R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick01R3.myWidth=windowWidth/10;
        nbBrick01R3.myHeight=nbBrick01.ourImage.getHeight()*6;
        nbBrick01R3.windowWidth=windowWidth;
        nbBrick01R3.windowHeight=windowHeight;
        nbBrick01R3.x=1*nbBrick01R3.myWidth+nbBrick01R3.myWidth/2;
        nbBrick01R3.y=nbBrick01R3.myHeight*3+200;
        Bricks.add(nbBrick01R3);

        //brick 02R3
        nbBrick02R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick02R3.myWidth=windowWidth/10;
        nbBrick02R3.myHeight=nbBrick02.ourImage.getHeight()*6;
        nbBrick02R3.windowWidth=windowWidth;
        nbBrick02R3.windowHeight=windowHeight;
        nbBrick02R3.x=2*nbBrick02R3.myWidth+nbBrick02R3.myWidth/2;
        nbBrick02R3.y=nbBrick02R3.myHeight*3+200;
        Bricks.add(nbBrick02R3);

        //brick 03R3
        nbBrick03R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick03R3.myWidth=windowWidth/10;
        nbBrick03R3.myHeight=nbBrick03.ourImage.getHeight()*6;
        nbBrick03R3.windowWidth=windowWidth;
        nbBrick03R3.windowHeight=windowHeight;
        nbBrick03R3.x=3*nbBrick03R3.myWidth+nbBrick03R3.myWidth/2;
        nbBrick03R3.y=nbBrick03R3.myHeight*3+200;
        Bricks.add(nbBrick03R3);

        //brick 04R3 shorter paddle special brick
        nbBrick04R3 = new ClassBrick(this, coords, "nbBrick2.png");
        nbBrick04R3.myWidth=windowWidth/10;
        nbBrick04R3.myHeight=nbBrick04.ourImage.getHeight()*6;
        nbBrick04R3.windowWidth=windowWidth;
        nbBrick04R3.windowHeight=windowHeight;
        nbBrick04R3.x=4*nbBrick04R3.myWidth+nbBrick04R3.myWidth/2;
        nbBrick04R3.y=nbBrick04R3.myHeight*3+200;
        Bricks.add(nbBrick04R3);

        //brick 05R3
        nbBrick05R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick05R3.myWidth=windowWidth/10;
        nbBrick05R3.myHeight=nbBrick05.ourImage.getHeight()*6;
        nbBrick05R3.windowWidth=windowWidth;
        nbBrick05R3.windowHeight=windowHeight;
        nbBrick05R3.x=5*nbBrick05R3.myWidth+nbBrick05R3.myWidth/2;
        nbBrick05R3.y=nbBrick05R3.myHeight*3+200;
        Bricks.add(nbBrick05R3);

        //brick 06R3
        nbBrick06R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick06R3.myWidth=windowWidth/10;
        nbBrick06R3.myHeight=nbBrick06.ourImage.getHeight()*6;
        nbBrick06R3.windowWidth=windowWidth;
        nbBrick06R3.windowHeight=windowHeight;
        nbBrick06R3.x=6*nbBrick06R3.myWidth+nbBrick06R3.myWidth/2;
        nbBrick06R3.y=nbBrick06R3.myHeight*3+200;
        Bricks.add(nbBrick06R3);

        //brick 07R3
        nbBrick07R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick07R3.myWidth=windowWidth/10;
        nbBrick07R3.myHeight=nbBrick07.ourImage.getHeight()*6;
        nbBrick07R3.windowWidth=windowWidth;
        nbBrick07R3.windowHeight=windowHeight;
        nbBrick07R3.x=7*nbBrick07R3.myWidth+nbBrick07R3.myWidth/2;
        nbBrick07R3.y=nbBrick07R3.myHeight*3+200;
        Bricks.add(nbBrick07R3);

        //brick 08R3
        nbBrick08R3 = new ClassBrick(this, coords, "nbBrick.png");
        nbBrick08R3.myWidth=windowWidth/10;
        nbBrick08R3.myHeight=nbBrick08.ourImage.getHeight()*6;
        nbBrick08R3.windowWidth=windowWidth;
        nbBrick08R3.windowHeight=windowHeight;
        nbBrick08R3.x=8*nbBrick08R3.myWidth+nbBrick08R3.myWidth/2;
        nbBrick08R3.y=nbBrick08R3.myHeight*3+200;
        Bricks.add(nbBrick08R3);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ourView.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        ourView.pause();

    }
}
