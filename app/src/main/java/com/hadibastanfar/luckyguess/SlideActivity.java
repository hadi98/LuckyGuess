package com.hadibastanfar.luckyguess;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


public class SlideActivity extends AppCompatActivity {

    public TextView okText;
    public boolean okVisibility = false;

    private View indicator1;
    private View indicator2;
    private View indicator3;
    private View indicator4;

    public Drawable[] imgs;

    public String[] titles = {
            "Pick a number between 0 and 107"
            ,"Then look carefully at the 7 different card that will be shown to you step by step "
            ,"If You see the number in the card just tap Yes if not then tap NO"
            ,"And when all the 7 cards are shown the number you you had in mind will appear on the cards frame"
    };

    public int[] colors;

    /**
      The number of pages (wizard steps) to show in this demo.
      */
    private static final int NUM_PAGES = 4;
    /**
       The pager widget, which handles animation and allows swiping horizontally to access previous
       and next wizard steps.
      */
    private ViewPager mPager;
    /**
       The pager adapter, which provides the pages to the view pager widget.
      */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slide);

        okText = findViewById(R.id.oktxv);
        okText.setVisibility(View.INVISIBLE);

        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);
        indicator4 = findViewById(R.id.indicator4);

        colors  = new int[]{

                 getResources().getColor(R.color.stoneBlue)
                ,getResources().getColor(R.color.deadOrange)
                ,getResources().getColor(R.color.seaBlue)
                ,getResources().getColor(R.color.jungleGreen)

        };

        imgs = new Drawable[]{
                 getResources().getDrawable(R.drawable.thinking)
                ,getResources().getDrawable(R.drawable.lookingcarefuly)
                ,getResources().getDrawable(R.drawable.yesorno)
                ,getResources().getDrawable(R.drawable.correct)
        };

        // Instantiate tapCounter ViewPager and tapCounter PagerAdapter.
        mPager = findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager = findViewById(R.id.pager);
        mPager.setOnPageChangeListener(new WizardPageChangeListener());
        updateIndicators(0);
    }

    @Override
    public void onBackPressed() {

        Intent intentbackpressed = new Intent(this,Entry.class);
        startActivity(intentbackpressed);

//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
    }

    /**
     * A simple pager adapter that represents 5 SlideFragment objects, in
     * sequence.
     */



    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            SlideFragment fragment = new SlideFragment();
            fragment.data = titles[position];
            fragment.color = colors[position];
            fragment.backg = imgs[position];

            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

    }

    private class WizardPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int position) {



        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(final int position) {
            updateIndicators(position);
            if (position == 3){
                okVisibility = true;
            }

            if (okVisibility == true){

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        okText.setVisibility(View.VISIBLE);
                    }
                },1500);
            }
        }
    }

    public void ok(View view){
        Intent intentok = new Intent(this,Game.class);
        startActivity(intentok);
    }

    public void updateIndicators(int position) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int resizeValue = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 15, metrics);
        int defaultValue = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 9, metrics);
        switch (position) {
            case 0:
                indicator1.getLayoutParams().height = resizeValue;
                indicator1.getLayoutParams().width = resizeValue;
                indicator1.requestLayout();

                indicator2.getLayoutParams().height = defaultValue;
                indicator2.getLayoutParams().width = defaultValue;
                indicator2.requestLayout();

                indicator3.getLayoutParams().height = defaultValue;
                indicator3.getLayoutParams().width = defaultValue;
                indicator3.requestLayout();

                indicator4.getLayoutParams().height = defaultValue;
                indicator4.getLayoutParams().width = defaultValue;
                indicator4.requestLayout();

                break;

            case 1:
                indicator1.getLayoutParams().height = defaultValue;
                indicator1.getLayoutParams().width = defaultValue;
                indicator1.requestLayout();

                indicator2.getLayoutParams().height = resizeValue;
                indicator2.getLayoutParams().width = resizeValue;
                indicator2.requestLayout();

                indicator3.getLayoutParams().height = defaultValue;
                indicator3.getLayoutParams().width = defaultValue;
                indicator3.requestLayout();

                indicator4.getLayoutParams().height = defaultValue;
                indicator4.getLayoutParams().width = defaultValue;
                indicator4.requestLayout();
                break;

            case 2:
                indicator1.getLayoutParams().height = defaultValue;
                indicator1.getLayoutParams().width = defaultValue;
                indicator1.requestLayout();

                indicator2.getLayoutParams().height = defaultValue;
                indicator2.getLayoutParams().width = defaultValue;
                indicator2.requestLayout();

                indicator3.getLayoutParams().height = resizeValue;
                indicator3.getLayoutParams().width = resizeValue;
                indicator3.requestLayout();

                indicator4.getLayoutParams().height = defaultValue;
                indicator4.getLayoutParams().width = defaultValue;
                indicator4.requestLayout();
                break;

            case 3:
                indicator1.getLayoutParams().height = defaultValue;
                indicator1.getLayoutParams().width = defaultValue;
                indicator1.requestLayout();

                indicator2.getLayoutParams().height = defaultValue;
                indicator2.getLayoutParams().width = defaultValue;
                indicator2.requestLayout();

                indicator3.getLayoutParams().height = defaultValue;
                indicator3.getLayoutParams().width = defaultValue;
                indicator3.requestLayout();

                indicator4.getLayoutParams().height = resizeValue;
                indicator4.getLayoutParams().width = resizeValue;
                indicator4.requestLayout();
                break;
        }
    }
}