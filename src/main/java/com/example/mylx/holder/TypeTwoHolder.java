package com.example.mylx.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylx.R;
import com.example.mylx.bean.Users;

/**
 * Created by yipan on 2017/10/31.
 */

public class TypeTwoHolder extends BaseHolder implements View.OnClickListener {
    ImageView mUserImage;
    TextView mUserName;
    TextView mUserSize;
    private OnRemoveItem mOnRemoveItem;

    public ImageView getImageView(){
        return mUserImage;
    }

    public TypeTwoHolder(View itemView) {
        super(itemView);
        mUserImage = (ImageView) itemView.findViewById(R.id.user_image);
        mUserName = (TextView) itemView.findViewById(R.id.user_name);
        mUserSize = (TextView) itemView.findViewById(R.id.user_size);
        mUserImage.setOnClickListener(this);
    }

    @Override
    public void bindHolder(Users users) {
        mUserName.setText(users.name);
        mUserImage.setBackgroundResource(users.imageUrl);
        mUserSize.setText(users.size);
    }

    @Override
    public void onClick(View v) {
        if (mOnRemoveItem != null) {
            mOnRemoveItem.removeItem(v,getLayoutPosition());
        }
    }

    public interface OnRemoveItem{
        void removeItem(View v, int position);
    }
}
