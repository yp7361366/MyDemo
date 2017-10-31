package com.example.mylx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylx.R;
import com.example.mylx.bean.Users;
import com.example.mylx.holder.BaseHolder;
import com.example.mylx.holder.TypeOneHolder;
import com.example.mylx.holder.TypeThreeHolder;
import com.example.mylx.holder.TypeTwoHolder;
import com.example.mylx.myinterface.OnRecyclerViewItemClickListener;
import com.example.mylx.myinterface.OnRecyclerViewItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yipan on 2017/10/26.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements  View.OnLongClickListener, View.OnClickListener {

    private List<Users> mList = new ArrayList<>();
    private Context mContext;
    private final LayoutInflater inflater;
    private OnRecyclerViewItemClickListener mListener;
    private OnRecyclerViewItemLongClickListener mLongListener;
    private OnRemoveItem mOnRemoveItem;

    public MyRecycleAdapter(Context mContext){
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void removeitem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mList.size() - position);
    }
    public void addItem(int position,Users users){
        mList.add(position,users);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mList.size() - position);
    }


    public void addList(List<Users> list){
        mList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case Users.ITEMTYPE_ONE:
                return new TypeOneHolder(inflater.inflate(R.layout.item_typeone ,parent, false));
            case Users.ITEMTYPE_TWO:
                return new TypeTwoHolder(inflater.inflate(R.layout.item_typetwo ,parent, false));
            case Users.ITEMTYPE_THREE:
                return new TypeThreeHolder(inflater.inflate(R.layout.item_typethree ,parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((BaseHolder)holder).bindHolder(mList.get(position));
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(this);
        int type = holder.getItemViewType();
        switch (type){
            case 2:
                ((TypeTwoHolder)holder).getImageView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnRemoveItem != null) {
                            mOnRemoveItem.removeItem(v,holder.getLayoutPosition());
                        }
                    }
                });
                break;
        }
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return mList.get(position).itemtype;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mListener = listener;
    }

    public void setOnItemLongClickListener(OnRecyclerViewItemLongClickListener listener) {
        this.mLongListener = listener;
    }

    public void setOnItemRemoveClickListener(OnRemoveItem listener) {
        this.mOnRemoveItem = listener;
    }
    @Override
    public boolean onLongClick(View v) {
        if (mLongListener != null) {
            mLongListener.onItemLongClick(v, (Integer) v.getTag());
        }
        return true;  //false 长按后会继续调用点击事件，true不会
    }

    @Override
    public void onClick(View v) {
        if (null != mListener) {
            mListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    public interface OnRemoveItem{
        void removeItem(View v, int position);
    }

//    public interface OnRecyclerViewItemClickListener {
//        void onItemClick(View view, int position);
//    }

}
