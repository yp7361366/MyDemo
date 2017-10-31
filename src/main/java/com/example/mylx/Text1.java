package com.example.mylx;

import android.util.Log;

/**
 * Created by yipan on 2017/10/26.
 */

public class Text1 {
    public Text1(){
        System.out.print("Hi!");
        Log.d("ss", "Hi! ");
    }

    public Text1(String s){
        this();
        System.out.print("I am "+s);
        Log.d("ss", "I am "+s);

    }
}
