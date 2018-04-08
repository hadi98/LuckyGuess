package com.hadibastanfar.luckyguess;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity {

    public ConstraintLayout theLayout;
    public TextView textViewCards;
    public int tapCounter = 0;
    public int guessedNumber = 0;
    public Button buttontryAgain, buttonYes, buttonNo;
    public ThemeClass car;

    List<ThemeClass> layoutContainer = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);


        theLayout = findViewById(R.id.mainLayout);

        ThemeClass layoutMaroon = new ThemeClass();

        layoutMaroon.backGround = R.color.maroonVeryLite;
        layoutMaroon.leftButton = R.drawable.button_left_maroon;
        layoutMaroon.rightButton = R.drawable.button_right_maroon;
        layoutMaroon.frame = R.drawable.frame_maroon;
        layoutContainer.add(layoutMaroon);

        ThemeClass layoutOldGold = new ThemeClass();

        layoutOldGold.backGround = R.color.oldGoldVeryLite;
        layoutOldGold.leftButton = R.drawable.button_left_oldgold;
        layoutOldGold.rightButton = R.drawable.button_right_oldgold;
        layoutOldGold.frame = R.drawable.frame_oldgold;
        layoutContainer.add(layoutOldGold);

        ThemeClass layoutStoneBlue = new ThemeClass();

        layoutStoneBlue.backGround = R.color.stoneBlueVeryLite;
        layoutStoneBlue.leftButton = R.drawable.button_left_stoneblue;
        layoutStoneBlue.rightButton = R.drawable.button_right_stoneblue;
        layoutStoneBlue.frame = R.drawable.frame_stoneblue;
        layoutContainer.add(layoutStoneBlue);

        ThemeClass layoutDarkClouds = new ThemeClass();

        layoutDarkClouds.backGround = R.color.stormPurpleVeryLite;
        layoutDarkClouds.leftButton = R.drawable.button_left_stormpurple;
        layoutDarkClouds.rightButton = R.drawable.button_right_stormpurple;
        layoutDarkClouds.frame = R.drawable.frame_stormpurple;
        layoutContainer.add(layoutDarkClouds);

        ThemeClass layoutDeadOrange = new ThemeClass();

        layoutDeadOrange.backGround = R.color.deadOrangeVeryLite;
        layoutDeadOrange.leftButton = R.drawable.button_left_deadorange;
        layoutDeadOrange.rightButton = R.drawable.button_right_deadorange;
        layoutDeadOrange.frame = R.drawable.frame_deadorange;
        layoutContainer.add(layoutDeadOrange);

        ThemeClass layoutJungleGreen = new ThemeClass();

        layoutJungleGreen.backGround = R.color.jungleGreenVeryLite;
        layoutJungleGreen.leftButton = R.drawable.button_left_junglegreen;
        layoutJungleGreen.rightButton = R.drawable.button_right_junglegreen;
        layoutJungleGreen.frame = R.drawable.frame_junglegreen;
        layoutContainer.add(layoutJungleGreen);

        ThemeClass layoutSeaBlue = new ThemeClass();

        layoutSeaBlue.backGround = R.color.seaBlueVeryLite;
        layoutSeaBlue.leftButton = R.drawable.button_left_seablue;
        layoutSeaBlue.rightButton = R.drawable.button_right_seablue;
        layoutSeaBlue.frame = R.drawable.frame_seablue;
        layoutContainer.add(layoutSeaBlue);




        textViewCards = findViewById(R.id.txvCards);

        textViewCards.setText(R.string.card_1);

        buttontryAgain = findViewById(R.id.tryAgain);
        buttonYes = findViewById(R.id.buYes);
        buttonNo = findViewById(R.id.buNo);

        /**ObjectAnimator animation = ObjectAnimator.ofFloat(textViewCards, "translationX", 100f);
        animation.setDuration(2000);
        animation.start();*/
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
                car = layoutContainer.get(0);
                setTheme(car);
                break;

            case 2:
                guessedNumber += 2;
                textViewCards.setText(R.string.card_3);
                car = layoutContainer.get(1);
                setTheme(car);
                break;


            case 3:
                guessedNumber += 4;
                textViewCards.setText(R.string.card_4);
                car = layoutContainer.get(2);
                setTheme(car);
                break;

            case 4:
                guessedNumber += 8;
                textViewCards.setText(R.string.card_5);
                car = layoutContainer.get(3);
                setTheme(car);
                break;

            case 5:
                guessedNumber += 16;
                textViewCards.setText(R.string.card_6);
                car = layoutContainer.get(4);
                setTheme(car);
                break;

            case 6:
                guessedNumber += 32;
                textViewCards.setText(R.string.card_7);
                car = layoutContainer.get(5);
                setTheme(car);
                break;

            case 7:
                guessedNumber += 64;
                textViewCards.setText(guessedNumber + "");
                buttontryAgain.setVisibility(View.VISIBLE);
                buttonYes.setVisibility(View.INVISIBLE);
                buttonNo.setVisibility(View.INVISIBLE);
                car = layoutContainer.get(6);
                setTheme(car);
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
                car = layoutContainer.get(0);
                setTheme(car);
                break;

            case 2:
                textViewCards.setText(R.string.card_3);
                car = layoutContainer.get(1);
                setTheme(car);
                break;

            case 3:
                textViewCards.setText(R.string.card_4);
                car = layoutContainer.get(2);
                setTheme(car);
                break;

            case 4:
                textViewCards.setText(R.string.card_5);
                car = layoutContainer.get(3);
                setTheme(car);
                break;

            case 5:
                textViewCards.setText(R.string.card_6);
                car = layoutContainer.get(4);
                setTheme(car);
                break;

            case 6:
                textViewCards.setText(R.string.card_7);
                car = layoutContainer.get(5);
                setTheme(car);
                break;

            case 7:
                textViewCards.setText("" + guessedNumber);
                buttontryAgain.setVisibility(View.VISIBLE);
                buttonYes.setVisibility(View.INVISIBLE);
                buttonNo.setVisibility(View.INVISIBLE);
                car = layoutContainer.get(6);
                setTheme(car);
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
        tapCounter ++;
    }


    public void setTheme (ThemeClass theme) {
        theLayout.setBackgroundColor(getResources().getColor(theme.backGround));
        buttonYes.setBackground(getResources().getDrawable(theme.leftButton));
        buttonNo.setBackground(getResources().getDrawable(theme.rightButton));
        textViewCards.setBackground(getResources().getDrawable(theme.frame));
    }

}
