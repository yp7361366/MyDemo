package com.example.mylx.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylx.R;
import com.example.mylx.bean.Users;

/**
 * Created by yipan on 2017/10/31.
 */

public class TypeOneHolder extends BaseHolder {
    ImageView mUserImage;
    TextView mUserName;

    public TypeOneHolder(View itemView) {
        super(itemView);
        mUserImage = (ImageView) itemView.findViewById(R.id.user_image);
        mUserName = (TextView) itemView.findViewById(R.id.user_name);
    }

    @Override
    public void bindHolder(Users users) {
        mUserName.setText(users.name);
        mUserImage.setBackgroundResource(users.imageUrl);

    }
}
