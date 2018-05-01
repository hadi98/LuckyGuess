package com.hadibastanfar.luckyguess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import ir.adad.client.Adad;


public class EntryActivity extends AppCompatActivity {

    private SharedPreferences sharedPref,sharedPrefLang, sharedPreFirstTime;
    private Button play,teachme;
    private Animation myAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entry);

        //Execute Animations
        myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce_slow);

        //Execute Buttons
        play = findViewById(R.id.buLetsStart);
        teachme = findViewById(R.id.buHowToPlay);

        //Execute SharedPreferences
        sharedPref = getSharedPreferences("guide", Context.MODE_PRIVATE);
        sharedPreFirstTime = getSharedPreferences("firsTime", Context.MODE_PRIVATE);
        sharedPrefLang = getSharedPreferences("selectedLang", Context.MODE_PRIVATE);

        //Check if it's the first time is that app is being opened
        if (sharedPreFirstTime.getBoolean("checktrue", true)){
            startActivity(new Intent(this, PopUpActivity.class));
        }

        //Check to see which Lang is selected
        if (sharedPrefLang.getBoolean("farsi", true)){
            Typeface farsi_font = Typeface.createFromAsset(getAssets(), "fonts/farsi.ttf");
            teachme.setTypeface(farsi_font);
            teachme.setText("راهنما");
            play.setTypeface(farsi_font);
            play.setText("شروع کن");
        }
    }

    public void letStart(View view) {
        Adad.showInterstitialAd(EntryActivity.this);
        LinearLayout currentLayout = findViewById(R.id.entry_layout);
        currentLayout.setBackgroundColor(getResources().getColor(R.color.maroonVeryLite));

        play.startAnimation(myAnim);
        myAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if(sharedPref.getBoolean("firstTime",true)) {
                    Intent intentHTP = new Intent(EntryActivity.this, SlideActivity.class);
                    startActivity(intentHTP);
                }
                else {
                    Intent gameIntent = new Intent(EntryActivity.this, GameActivity.class);
                    EntryActivity.this.startActivity(gameIntent);
                }
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void howToPlay(View view) {
        Adad.showInterstitialAd(EntryActivity.this);
        LinearLayout currentLayout = findViewById(R.id.entry_layout);
        currentLayout.setBackgroundColor(getResources().getColor(R.color.seaBlueVeryLite));

        teachme.startAnimation(myAnim);
        myAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intentHTP = new Intent(EntryActivity.this, SlideActivity.class);
                startActivity(intentHTP);

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}