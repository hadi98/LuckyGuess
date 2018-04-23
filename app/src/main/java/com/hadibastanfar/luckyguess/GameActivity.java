package com.hadibastanfar.luckyguess;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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

public class GameActivity extends AppCompatActivity {

    public ConstraintLayout theLayout;
    public TextView textViewCards;
    public TextView question;
    public TextView header;
    public TextView anouncement;
    public View anouncementV;
    public int tapCounter = 0;
    public int guessedNumber = 0;
    public Button buttonTryAgain, buttonYes, buttonNo;
    public ThemeClass car;
    public Animation bounce;
    public Animation bounceVerySlow;
    public Animation zoomIn;
    public Animation zoomOut;
    public Animation fadeOut;
    public Animation fadeIn;
    public Animation shrinkLeft;
    public Animation shrinkRight;

    public String[] questionsFA = {

            "خب حالا با دقت نگاه کن ببین عددی که تو ذهنت انتخاب کردی توی این کارت هست؟"
            ,"عالیه دارم نزدیک تر میشم D:"
            ,"خوبه ادامه بده و با دقت نگاه کن."
            ,"کم مونده ادامه بده."
            ,"خوبه فقظ 2 تا کارت بیشتر نمونده!!!"
            ,"فقط یدونه کارت دیگه!"
            ,"این دیگه کارت آخریه با دقت نگاه کن."
            ,"و این هم عددی که انتخاب کردی..."
    };
    public String[] questionsEN = {
            "Ok Now! check the card carefully and see if the number you picked in your mind is in the card above or not. "
            ,"Great! getting closer."
            ,"Very Nice! keep going and look carefully"
            ,"Just a few more cards."
            ,"Only 2 card Remains!"
            ,"JUST!!! 1 more card."
            ,"This is the last card I hope you checked all the cards carefully my guess would be correct."
            ,"And the number you picked is..."
    };

    private SharedPreferences sharedPrefLang;


    List<ThemeClass> layoutContainer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        setLayout();
        //Implemented Animations
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceVerySlow = AnimationUtils.loadAnimation(this, R.anim.bounce_slow);
        bounceVerySlow = AnimationUtils.loadAnimation(this, R.anim.bounce_very_slow);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        shrinkLeft = AnimationUtils.loadAnimation(this, R.anim.shrink_left);
        shrinkRight = AnimationUtils.loadAnimation(this, R.anim.shrink_right);

        //Implemented TextViews and Views
        anouncementV = findViewById(R.id.view);
        anouncement = findViewById(R.id.anouncementText);
        header = findViewById(R.id.headerText);
        question = findViewById(R.id.txvAsk);

        //Implemented Buttons
        textViewCards = findViewById(R.id.txvCards);
        buttonTryAgain = findViewById(R.id.tryAgain);
        buttonYes = findViewById(R.id.buYes);
        buttonNo = findViewById(R.id.buNo);
        theLayout = findViewById(R.id.mainLayout);


        //Set the first card at beginning
        textViewCards.setText(R.string.card_1);

        //Implemented SharedPreferences
        sharedPrefLang = getSharedPreferences("selectedLang",Context.MODE_PRIVATE);

        //Implemented Fonts
        Typeface farsi_font = Typeface.createFromAsset(getAssets(), "fonts/farsi.ttf");
        question.setText(questionsEN[0]);
        if (sharedPrefLang.getBoolean("farsi", true)){

            header.setText("اینم عددی که تو ذهنت انتخاب کردی...");

            textViewCards.setTypeface(farsi_font);
            anouncement.setTypeface(farsi_font);
            header.setTypeface(farsi_font);

            question.setText(questionsFA[0]);
            question.setTypeface(farsi_font);

            buttonYes.setText("آره");
            buttonYes.setTypeface(farsi_font);

            buttonNo.setText("نه");
            buttonNo.setTypeface(farsi_font);

            buttonTryAgain.setText("دوباره");
            buttonTryAgain.setTypeface(farsi_font);
        }
    }

    public void yes(View view) {
        increment();
        setquestions();
        buttonYes.startAnimation(bounce);
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
                car = layoutContainer.get(6);
                setTheme(car);

                //Buttons shrink and disappear
                buttonYes.startAnimation(shrinkLeft);
                buttonNo.startAnimation(shrinkRight);
                question.startAnimation(zoomIn);
                textViewCards.startAnimation(zoomIn);


                final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        header.startAnimation(bounceVerySlow);
                        header.setVisibility(View.VISIBLE);
                    }
                },850);

                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        anouncementV.startAnimation(bounceVerySlow);
                        anouncementV.setVisibility(View.VISIBLE);

                    }
                },2000);

                final Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        anouncement.startAnimation(bounceVerySlow);
                        anouncement.setVisibility(View.VISIBLE);
                        anouncement.setText(guessedNumber + "");

                    }
                },3100);

                final Handler handler4 = new Handler();
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonTryAgain.startAnimation(bounceVerySlow);
                        buttonTryAgain.setVisibility(View.VISIBLE);
                    }
                },4200);
                break;
        }
    }

    public void no(View view) {
        increment();
        setquestions();
        buttonNo.startAnimation(bounce);
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
                car = layoutContainer.get(6);
                setTheme(car);

                //Buttons shrink and disappear
                buttonYes.startAnimation(shrinkLeft);
                buttonNo.startAnimation(shrinkRight);
                question.startAnimation(zoomIn);
                textViewCards.startAnimation(zoomIn);


                final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        header.startAnimation(bounceVerySlow);
                        header.setVisibility(View.VISIBLE);
                    }
                },850);

                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        anouncementV.startAnimation(bounceVerySlow);
                        anouncementV.setVisibility(View.VISIBLE);

                    }
                },2000);

                final Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        anouncement.startAnimation(bounceVerySlow);
                        anouncement.setVisibility(View.VISIBLE);
                        anouncement.setText(guessedNumber + "");

                    }
                },3100);

                final Handler handler4 = new Handler();
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonTryAgain.startAnimation(bounceVerySlow);
                        buttonTryAgain.setVisibility(View.VISIBLE);
                    }
                },4200);
                break;
        }
    }

    public void reset(View view) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttonTryAgain.startAnimation(myAnim);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        },100);
    }
    public void increment(){
        tapCounter++;
    }
    @SuppressLint("NewApi")
    public void setTheme (ThemeClass theme) {
        theLayout.setBackgroundColor(getResources().getColor(theme.backGround));
        buttonYes.setBackground(getResources().getDrawable(theme.leftButton));
        buttonNo.setBackground(getResources().getDrawable(theme.rightButton));
        textViewCards.setBackground(getResources().getDrawable(theme.frame));
    }
    public void onBackPressed(){
        Intent entryIntent = new Intent(this, EntryActivity.class);
        startActivity(entryIntent);
    }
    public void setLayout(){
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

        ThemeClass layoutSeaBlue = new ThemeClass();

        layoutSeaBlue.backGround = R.color.seaBlueVeryLite;
        layoutSeaBlue.leftButton = R.drawable.button_left_seablue;
        layoutSeaBlue.rightButton = R.drawable.button_right_seablue;
        layoutSeaBlue.frame = R.drawable.frame_seablue;
        layoutContainer.add(layoutSeaBlue);

        ThemeClass layoutJungleGreen = new ThemeClass();

        layoutJungleGreen.backGround = R.color.jungleGreenVeryLite;
        layoutJungleGreen.leftButton = R.drawable.button_left_junglegreen;
        layoutJungleGreen.rightButton = R.drawable.button_right_junglegreen;
        layoutJungleGreen.frame = R.drawable.frame_junglegreen;
        layoutContainer.add(layoutJungleGreen);
    }

    public void setquestions(){
        if (sharedPrefLang.getBoolean("farsi", true)) {

            switch (tapCounter) {
                case 1:
                    question.setText(questionsFA[1]);
                    break;

                case 2:
                    question.setText(questionsFA[2]);
                    break;

                case 3:
                    question.setText(questionsFA[3]);
                    break;

                case 4:
                    question.setText(questionsFA[4]);
                    break;

                case 5:
                    question.setText(questionsFA[5]);
                    break;

                case 6:
                    question.setText(questionsFA[6]);
                    break;

                case 7:

                    final Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        }
                    },750);

//                    question.startAnimation(zoomIn);
//
                    break;
            }
        }else {

            switch (tapCounter) {
                case 1:
                    question.setText(questionsEN[1]);
                    break;

                case 2:
                    question.setText(questionsEN[2]);
                    break;

                case 3:
                    question.setText(questionsEN[3]);
                    break;

                case 4:
                    question.setText(questionsEN[4]);
                    break;

                case 5:
                    question.setText(questionsEN[5]);
                    break;

                case 6:
                    question.setText(questionsEN[6]);
                    break;

                case 7:

//                    question.setVisibility(View.INVISIBLE);

                    break;
            }
        }
    }
}
