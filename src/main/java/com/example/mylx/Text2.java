package com.example.mylx;

import android.util.Log;

/**
 * Created by yipan on 2017/10/26.
 */

public class Text2 extends Text1 {
    public Text2(){
        this("I am Jack.");
        Log.d("ss", "I am Jack. ");

    }

    public Text2(String s) {
        super(s);
        System.out.print("How are you?");
        Log.d("ss", "How are you? ");

    }
}
