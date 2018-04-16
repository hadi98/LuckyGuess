package com.hadibastanfar.luckyguess;

import  android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entry);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, EntryActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();
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

                Intent gameIntent = new Intent(EntryActivity.this, GameActivity.class);
                EntryActivity.this.startActivity(gameIntent);

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
}
