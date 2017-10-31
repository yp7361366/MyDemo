package com.example.mylx;

/**
 * Created by yipan on 2017/10/26.
 */

public class SumTest {

    public int getAnInt (){
        int count = 0;
        for (int i = 0; i < 10 ; i++) {
            count = count++;//有i=i++是先将i加1，再将i的原始值赋值给i，所以如果i的值是不会改变的。
        }
        return count;
    }

    public boolean getABoolean(){
        String st = new String("aaa");
        String st2 = st.substring(0);

        return st == st2;
    }
}
