package com.hadibastanfar.luckyguess;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    public TextView textViewCards;
    public int tapCounter = 0;
    public int guessedNumber = 0;
    public Button buttontryAgain, buttonYes, buttonNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        textViewCards = findViewById(R.id.txvCards);

        textViewCards.setText(R.string.card_1);

        buttontryAgain = findViewById(R.id.tryAgain);
        buttonYes = findViewById(R.id.buYes);
        buttonNo = findViewById(R.id.buNo);

//        ObjectAnimator animation = ObjectAnimator.ofFloat(textViewCards, "translationX", 100f);
//        animation.setDuration(2000);
//        animation.start();
    }

    @Override
    public void onBackPressed() {
        Intent intentbackpressed = new Intent(this,Entry.class);
        startActivity(intentbackpressed);
    }

    public void yes(View view) {

        increment();

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttonYes.startAnimation(myAnim);

//        Toast.makeText(this,"Increment is: " + tapCounter,Toast.LENGTH_SHORT).show();

        switch (tapCounter){

            case 1:
                guessedNumber += 1;
                textViewCards.setText(R.string.card_2);
                break;

            case 2:
                guessedNumber += 2;
                textViewCards.setText(R.string.card_3);
                break;

            case 3:
                guessedNumber += 4;
                textViewCards.setText(R.string.card_4);
                break;

            case 4:
                guessedNumber += 8;
                textViewCards.setText(R.string.card_5);
                break;

            case 5:
                guessedNumber += 16;
                textViewCards.setText(R.string.card_6);
                break;

            case 6:
                guessedNumber += 32;
                textViewCards.setText(R.string.card_7);
                break;

            case 7:
                guessedNumber += 64;
                textViewCards.setText(guessedNumber + "");
                buttontryAgain.setVisibility(View.VISIBLE);
                buttonYes.setVisibility(View.INVISIBLE);
                buttonNo.setVisibility(View.INVISIBLE);
                break;


        }
    }

    public void no(View view) {

        increment();


        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttonNo.startAnimation(myAnim);

//        Toast.makeText(this,"Increment is: " + tapCounter,Toast.LENGTH_SHORT).show();

        switch (tapCounter){

            case 1:
                textViewCards.setText(R.string.card_2);
                break;

            case 2:
                textViewCards.setText(R.string.card_3);
                break;

            case 3:
                textViewCards.setText(R.string.card_4);
                break;

            case 4:
                textViewCards.setText(R.string.card_5);
                break;

            case 5:
                textViewCards.setText(R.string.card_6);
                break;

            case 6:
                textViewCards.setText(R.string.card_7);
                break;

            case 7:
                textViewCards.setText("" + guessedNumber);
                buttontryAgain.setVisibility(View.VISIBLE);
                buttonYes.setVisibility(View.INVISIBLE);
                buttonNo.setVisibility(View.INVISIBLE);
                break;

        }
    }

    public void reset(View view) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttontryAgain.startAnimation(myAnim);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                buttontryAgain.setVisibility(View.INVISIBLE);
                buttonYes.setVisibility(View.VISIBLE);
                buttonNo.setVisibility(View.VISIBLE);
                tapCounter *= 0;
                guessedNumber *= 0;
                textViewCards.setText(R.string.card_1);

            }
        },100);
    }

    public void increment(){
        tapCounter += 1;
    }
}
