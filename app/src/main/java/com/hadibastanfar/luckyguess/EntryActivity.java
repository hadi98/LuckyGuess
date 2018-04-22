package com.hadibastanfar.luckyguess;

import android.content.Context;
import  android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;


public class EntryActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private SharedPreferences sharedPrefLang;
    private SharedPreferences sharedPrefPUWfirstTime;

    private Button play;
    private Button teachme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entry);

        play = findViewById(R.id.buLetsStart);
        teachme = findViewById(R.id.buHowToPlay);

        sharedPref = getSharedPreferences("guide", Context.MODE_PRIVATE);
        sharedPrefPUWfirstTime = getSharedPreferences("firsTime", Context.MODE_PRIVATE);
        sharedPrefLang = getSharedPreferences("selectedLang", Context.MODE_PRIVATE);

        if (sharedPrefPUWfirstTime.getBoolean("checktrue", true)){
            startActivity(new Intent(this, Pop.class));
        }

        if (sharedPrefLang.getBoolean("farsi", true)){
            Typeface farsi_font = Typeface.createFromAsset(getAssets(), "fonts/farsi.ttf");
            teachme.setTypeface(farsi_font);
            teachme.setText("راهنما");
            play.setTypeface(farsi_font);
            play.setText("شروع کن");
        }
    }

    public void letstart(View view) {

        LinearLayout currentLayout = findViewById(R.id.entry_layout);
        currentLayout.setBackgroundColor(getResources().getColor(R.color.maroonVeryLite));

        Button btnLUS = findViewById(R.id.buLetsStart);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce_slow);
        btnLUS.startAnimation(myAnim);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(sharedPref.getBoolean("firstTime",true)) {
                    Intent intentHTP = new Intent(EntryActivity.this, SlideActivity.class);
                    startActivity(intentHTP);
                }
                else {
                    Intent gameIntent = new Intent(EntryActivity.this, GameActivity.class);
                    EntryActivity.this.startActivity(gameIntent);
                }
            }
        },250);
    }

    public void howToPlay(View view) {

        LinearLayout currentLayout = findViewById(R.id.entry_layout);
        currentLayout.setBackgroundColor(getResources().getColor(R.color.seaBlueVeryLite));

        Button btnHTP = findViewById(R.id.buHowToPlay);

        final Animation myAnim1 = AnimationUtils.loadAnimation(this, R.anim.bounce_slow);
        btnHTP.startAnimation(myAnim1);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intentHTP = new Intent(EntryActivity.this, SlideActivity.class);
                startActivity(intentHTP);

            }
        },250);
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}