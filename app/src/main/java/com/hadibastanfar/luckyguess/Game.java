package com.hadibastanfar.luckyguess;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

//        textView = findViewById(R.id.textView3);

        ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
        animation.setDuration(2000);
        animation.start();
    }

    public void yes(View view) {

        Button btnYes = findViewById(R.id.buYes);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        btnYes.startAnimation(myAnim);

    }

    public void no(View view) {

        Button btnYes = findViewById(R.id.buNo);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        btnYes.startAnimation(myAnim);

    }
}
