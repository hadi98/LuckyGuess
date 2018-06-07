package com.hadibastanfar.luckyguess;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SlideFragment extends Fragment {
     public TextView txv;
     public String data;
     public Drawable backg;
     public int color;
     public ImageView imageView;
     private SharedPreferences sharedPrefLang;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_slide, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPrefLang = this.getActivity().getSharedPreferences("selectedLang", Context.MODE_PRIVATE);

        Typeface fontFA = Typeface.createFromAsset(getActivity().getAssets(), "fonts/farsi.ttf");
//        Typeface fontEN = Typeface.createFromAsset(getActivity().getAssets(), "fonts/blur.ttf");

        imageView = view.findViewById(R.id.imgview);
        imageView.setBackground(backg);

        //so we have the view implemented we use the code below to change our background color from java code.
        view.setBackgroundColor(color);

        //we bring the text obj from our XML to java
        txv = view.findViewById(R.id.textview);

        //and we set it's text to any any value that is passed into data.
        txv.setText(data);

        if (sharedPrefLang.getBoolean("farsi", true)){

            txv.setTypeface(fontFA);

        }
//        else {
//
//            txv.setTypeface(fontEN);
//
//        }
    }
}

