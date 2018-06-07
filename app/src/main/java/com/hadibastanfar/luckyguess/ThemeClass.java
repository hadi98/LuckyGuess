package com.hadibastanfar.luckyguess;

import java.util.ArrayList;
import java.util.List;

public class ThemeClass {
    public int leftButton;
    public int rightButton;
    public int frame;
    public int backGround;
    public int cards;
    public int guide;
    public int numbers;
    List<ThemeClass> layoutContainer = new ArrayList<>();
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

    public void layoutPresets(){
        ThemeClass layoutMaroon = new ThemeClass();
        layoutMaroon.cards = R.id.txvCards;
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

}
