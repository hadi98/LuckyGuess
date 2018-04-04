package com.hadibastanfar.luckyguess;


import android.os.Bundle;
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

    private View indicator1;
    private View indicator2;
    private View indicator3;
    private View indicator4;

    public int color01;

    public TextView txv;
    public String[] titles = {

            "This is the first slide 1"
            ,"This is the second slide 2"
            ,"This is the third slide 3"
            ,"This is the fourth slide 4"
            ,"This is the fifth slide 5"
    };


    public int[] colors;

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slide);

        // Instantiate tapCounter ViewPager and tapCounter PagerAdapter.
        mPager = findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        colors  = new int[]{getResources().getColor(R.color.usc_gold)
                , getResources().getColor(R.color.pastel_blue)
                ,getResources().getColor(R.color.medium_vermilion)
                ,getResources().getColor(R.color.lilac_luster)
                ,getResources().getColor(R.color.dark_slate_gray)};

        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);
        indicator4 = findViewById(R.id.indicator4);

        mPager = findViewById(R.id.pager);
        mPager.setOnPageChangeListener(new WizardPageChangeListener());
        updateIndicators(0);

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
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
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int position) {
            updateIndicators(position);

        }

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