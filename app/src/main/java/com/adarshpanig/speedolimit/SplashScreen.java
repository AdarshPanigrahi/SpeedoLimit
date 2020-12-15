package com.adarshpanig.speedolimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.hanks.htextview.animatetext.HText;
import pl.droidsonroids.gif.GifImageView;

public class SplashScreen extends AppCompatActivity {
    int x=0;
    LinearLayout linearLayout;
    AnimationDrawable animationDrawable,animationDrawable2;
    GifImageView car;
    TextView real,driver;
    HTextView hTextView,hTextView1,hTextView2;
    String[] sentences = {"Drive carefully, to live joyfully", "Fast Drive could be your Last Drive","Safe Drive, Safe Life","Drive carefully, to live joyfully"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        real = findViewById(R.id.real);
        driver = findViewById(R.id.driver);

        real.animate().translationY(0).setDuration(2000);
        driver.animate().translationY(0).setDuration(2000);
        //555555555555555555555555555555555555555555555555555555
        hTextView1 = findViewById(R.id.Htext2);
        hTextView = findViewById(R.id.Htext1);
        hTextView2 = findViewById(R.id.Htext3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hTextView.setTypeface(FontManager.getInstance(getAssets()).getFont("fonts/font-name.ttf"));
        // hTextView.setAnimateType(HTextViewType.SCALE);
        // for (String senten:sentences)

        final Handler handler = new Handler();

        final Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                hTextView.animateText(sentences[x]);
                handler.postDelayed(this,1500);
//                if (x<sentences.length)
//                    handler.removeCallbacks(runnableCode);
            }
        };
        handler.post(runnableCode);

        hTextView1.setAnimateType(HTextViewType.RAINBOW);
        hTextView1.animateText("S");
        hTextView2.setAnimateType(HTextViewType.RAINBOW);
        hTextView2.animateText("M");
        //4444444444444444444444444444444444444444444444444444444444

        linearLayout = findViewById(R.id.gradanim);
        car = findViewById(R.id.car);
        animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();
        car.animate().translationX(-10).setDuration(3500);
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    MediaPlayer mediaPlayer = new MediaPlayer().create(getApplicationContext(), R.raw.car_alarm_chirp);
                    mediaPlayer.start();
                    Thread.sleep(1000);
                    handler.removeCallbacks(runnableCode);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myThread.start();
    }

}
