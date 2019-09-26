package com.example.appbind;

import android.content.Context;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {
    @BindingAdapter("app:changeColor")
    public static void changeTextColor(TextView view, Integer likes){
        Context context = view.getContext();
        int color = 0;
        if(likes < 10){
            color = context.getColor(R.color.baixo);
        }else if(likes < 25){
            color = context.getColor(R.color.medio);
        }else{
            color = context.getColor(R.color.alto);
        }

        view.setTextColor(color);
    }
}
