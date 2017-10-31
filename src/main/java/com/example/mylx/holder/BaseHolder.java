package com.example.mylx.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mylx.bean.Users;

/**
 * Created by yipan on 2017/10/31.
 */

public abstract class BaseHolder extends RecyclerView.ViewHolder {

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(Users users);
}
