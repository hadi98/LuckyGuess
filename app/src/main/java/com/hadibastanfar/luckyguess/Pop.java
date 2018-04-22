package com.hadibastanfar.luckyguess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Pop extends Activity {

    private SharedPreferences sharedPrefLang;
    private SharedPreferences sharedPrefPUWfirstTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.6));



    }

    public void selectEN(View view) {

        sharedPrefLang = getSharedPreferences("selectedLang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefLang.edit();
        editor.putBoolean("farsi", false);
        editor.apply();

        sharedPrefPUWfirstTime = getSharedPreferences("firsTime", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorFTC = sharedPrefPUWfirstTime.edit();
        editorFTC.putBoolean("checktrue", false);
        editorFTC.apply();

        Intent intentLangselected = new Intent(this, EntryActivity.class);
        startActivity(intentLangselected);
    }

    public void selectFA(View view) {

        sharedPrefLang = getSharedPreferences("selectedLang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefLang.edit();
        editor.putBoolean("farsi", true);
        editor.apply();

        sharedPrefPUWfirstTime = getSharedPreferences("firsTime", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorFTC = sharedPrefPUWfirstTime.edit();
        editorFTC.putBoolean("checktrue", false);
        editorFTC.apply();

        Intent intentLangselected = new Intent(this, EntryActivity.class);
        startActivity(intentLangselected);
    }
}
