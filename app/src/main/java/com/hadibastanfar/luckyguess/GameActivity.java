package com.hadibastanfar.luckyguess;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import ir.adad.client.Adad;

public class GameActivity extends AppCompatActivity {

    public  ThemeClass themeClass;
    public Typeface farsi_font;
    public ConstraintLayout theLayout;
    public TextView textViewCards,question,header,numberReveal;
    public View announcementView;
    public int tapCounter,guessedNumber = 0;
    public Button buttonTryAgain, buttonYes, buttonNo;
    public ThemeClass theme;
    public Animation  bounce ,bounceVerySlow,bounceVerySlow1,bounceVerySlow2,bounceVerySlow3
                     ,zoomIn,zoomOut,fadeOut,fadeIn,shrinkLeft,shrinkRight;
    private SharedPreferences sharedPrefLang;
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
            "Ok Now! check the card carefully and see if the number you picked in your mind is in the card above or not? "
            ,"Great! getting closer."
            ,"Very Nice! keep going and look carefully."
            ,"Just a few more cards."
            ,"Only 2 card Remains!"
            ,"JUST!!! 1 more card."
            ,"This is the last card I hope you checked all the cards carefully so my guess would be correct."
            ,"And the number you picked is..."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);


        themeClass = new ThemeClass();
        //Execute mainLayout
        theLayout = findViewById(R.id.mainLayout);

        //Execute Layouts
        themeClass.layoutPresets();

        //Execute Animations
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceVerySlow = AnimationUtils.loadAnimation(this, R.anim.bounce_very_slow);
        bounceVerySlow1 = AnimationUtils.loadAnimation(this, R.anim.bounce_very_slow);
        bounceVerySlow2 = AnimationUtils.loadAnimation(this, R.anim.bounce_very_slow);
        bounceVerySlow3 = AnimationUtils.loadAnimation(this, R.anim.bounce_very_slow);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        shrinkLeft = AnimationUtils.loadAnimation(this, R.anim.shrink_left);
        shrinkRight = AnimationUtils.loadAnimation(this, R.anim.shrink_right);

        //Execute TextViews and Views
        announcementView = findViewById(R.id.numberRevealView);
        numberReveal = findViewById(R.id.numberReveal);
        header = findViewById(R.id.headerAnnouncementText);
        question = findViewById(R.id.midPositionText);

        //Execute Buttons
        textViewCards = findViewById(R.id.txvCards);
        buttonTryAgain = findViewById(R.id.tryAgain);
        buttonYes = findViewById(R.id.buYes);
        buttonNo = findViewById(R.id.buNo);

        //Set the first card at the onCreate
        textViewCards.setText(R.string.card_1);

        //Execute SharedPreferences
        sharedPrefLang = getSharedPreferences("selectedLang",Context.MODE_PRIVATE);

        //Implemented Persian Font
        farsi_font = Typeface.createFromAsset(getAssets(), "fonts/farsi.ttf");
        question.setText(questionsEN[0]);
        if (sharedPrefLang.getBoolean("farsi", true)){
            fontFA();
        }
    }

    public void yes(View view) {
        increment();
        midText();
        buttonYes.startAnimation(bounce);

        switch (tapCounter){

            case 1:
                guessedNumber += 1;
                textViewCards.setText(R.string.card_2);
                theme = themeClass.layoutContainer.get(0);
                setTheme(theme);
                break;

            case 2:
                guessedNumber += 2;
                textViewCards.setText(R.string.card_3);
                theme = themeClass.layoutContainer.get(1);
                setTheme(theme);
                break;


            case 3:
                guessedNumber += 4;
                textViewCards.setText(R.string.card_4);
                theme = themeClass.layoutContainer.get(2);
                setTheme(theme);
                break;

            case 4:
                guessedNumber += 8;
                textViewCards.setText(R.string.card_5);
                theme = themeClass.layoutContainer.get(3);
                setTheme(theme);
                break;

            case 5:
                guessedNumber += 16;
                textViewCards.setText(R.string.card_6);
                theme = themeClass.layoutContainer.get(4);
                setTheme(theme);
                break;

            case 6:
                guessedNumber += 32;
                textViewCards.setText(R.string.card_7);
                theme = themeClass.layoutContainer.get(5);
                setTheme(theme);
                break;

            case 7:
                guessedNumber += 64;
                theme = themeClass.layoutContainer.get(6);
                setTheme(theme);

                //Buttons shrink and disappear
                buttonYes.startAnimation(shrinkLeft);
                buttonNo.startAnimation(shrinkRight);
                question.startAnimation(zoomIn);
                textViewCards.startAnimation(zoomIn);

                buttonYes.setEnabled(false);
                buttonNo.setEnabled(false);

                zoomIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        header.startAnimation(bounceVerySlow);
                        header.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bounceVerySlow.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        announcementView.startAnimation(bounceVerySlow1);
                        announcementView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bounceVerySlow1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        numberReveal.setText("" + guessedNumber);
                        numberReveal.startAnimation(bounceVerySlow2);
                        numberReveal.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bounceVerySlow2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        buttonTryAgain.startAnimation(bounceVerySlow3);
                        buttonTryAgain.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                break;
        }
    }

    public void no(View view) {
        increment();
        midText();
        buttonNo.startAnimation(bounce);
//        Toast.makeText(this,"Increment is: " + tapCounter,Toast.LENGTH_SHORT).show();

        switch (tapCounter){

            case 1:
                textViewCards.setText(R.string.card_2);
                theme = themeClass.layoutContainer.get(0);
                setTheme(theme);
                break;

            case 2:
                textViewCards.setText(R.string.card_3);
                theme = themeClass.layoutContainer.get(1);
                setTheme(theme);
                break;

            case 3:
                textViewCards.setText(R.string.card_4);
                theme = themeClass.layoutContainer.get(2);
                setTheme(theme);
                break;

            case 4:
                textViewCards.setText(R.string.card_5);
                theme = themeClass.layoutContainer.get(3);
                setTheme(theme);
                break;

            case 5:
                textViewCards.setText(R.string.card_6);
                theme = themeClass.layoutContainer.get(4);
                setTheme(theme);
                break;

            case 6:
                textViewCards.setText(R.string.card_7);
                theme = themeClass.layoutContainer.get(5);
                setTheme(theme);
                break;

            case 7:
                theme = themeClass.layoutContainer.get(6);
                setTheme(theme);

                //Buttons shrink and disappear
                buttonYes.startAnimation(shrinkLeft);
                buttonNo.startAnimation(shrinkRight);
                question.startAnimation(zoomIn);
                textViewCards.startAnimation(zoomIn);

                buttonYes.setEnabled(false);
                buttonNo.setEnabled(false);

                zoomIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        header.startAnimation(bounceVerySlow);
                        header.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bounceVerySlow.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        announcementView.startAnimation(bounceVerySlow1);
                        announcementView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bounceVerySlow1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        numberReveal.setText("" + guessedNumber);
                        numberReveal.startAnimation(bounceVerySlow2);
                        numberReveal.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                bounceVerySlow2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        buttonTryAgain.startAnimation(bounceVerySlow3);
                        buttonTryAgain.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                break;
        }
    }

    public void reset(View view) {

        Adad.showInterstitialAd(GameActivity.this);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttonTryAgain.startAnimation(myAnim);

        myAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                recreate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
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

    public void midText(){
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
            }
        }
    }

    public void fontFA(){
        header.setText("اینم عددی که تو ذهنت انتخاب کردی...");

        textViewCards.setTypeface(farsi_font);
        numberReveal.setTypeface(farsi_font);
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
