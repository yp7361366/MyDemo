package com.example.mylx;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.mylx.adapter.MyRecycleAdapter;
import com.example.mylx.bean.Users;
import com.example.mylx.myinterface.OnRecyclerViewItemClickListener;
import com.example.mylx.myinterface.OnRecyclerViewItemLongClickListener;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private String str = "private 修饰只能类内部调用";
    public String str2 = "public修饰所有类都可以调用";
    String str4 = "default修饰或者没有修饰符只能本包下下访问";
    protected String str3 = "protected修饰自身，子类以及同一包中的类可以访问";
    private RecyclerView recycle_view;
    private LinearLayoutManager manager;
    private ArrayList<Users> list;
    private int colors[] = {android.R.color.holo_red_light, android.R.color.holo_green_light,
            android.R.color.holo_blue_light
    };
    private MyRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* SumTest sumTest = new SumTest();
        int anInt = sumTest.getAnInt();
        boolean aBoolean = sumTest.getABoolean();
        Log.d(TAG, "count="+anInt);
        Log.d(TAG, "boolean="+aBoolean);

//        Text2 text2 = new Text2("Tom.");
        ClassDemo classDemo = new ClassDemo();
        ClassDemo classDemo1 = new ClassDemo();
        Log.d(TAG, "sum = "+classDemo.sum);*/
        recycle_view = (RecyclerView) findViewById(R.id.recycle_view);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = recycle_view.getAdapter().getItemViewType(position);
                if (type == Users.ITEMTYPE_THREE) {
                    return gridLayoutManager.getSpanCount();
                }else {
                    return 1;
                }
            }
        });
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycle_view.setLayoutManager(gridLayoutManager);
//        recycle_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter = new MyRecycleAdapter(this);
        recycle_view.setAdapter(adapter);
        initDate();
//        adapter.setOnItemClickListener(new MyRecycleAdapter.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this,"第" + position + "item",Toast.LENGTH_SHORT).show();
//            }
//        });
        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"第" + position + "item",Toast.LENGTH_SHORT).show();

            }
        });
        adapter.setOnItemLongClickListener(new OnRecyclerViewItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"Long第" + position + "item",Toast.LENGTH_SHORT).show();
//                adapter.removeitem(position);
                Users users = new Users();
                users.name = "新增" + position;
                users.size = position + "*";
                users.itemtype = 2;
                users.imageUrl = android.R.color.holo_orange_light;
                adapter.addItem(position,users);
                return false;
            }
        });
        adapter.setOnItemRemoveClickListener(new MyRecycleAdapter.OnRemoveItem() {
            @Override
            public void removeItem(View v, int position) {
                adapter.removeitem(position);
            }
        });

    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Users users = new Users();
            users.itemtype = (int) ((Math.random() * 3) + 1);
            users.name = "user" +  users.itemtype + i;
            users.size = i + "";
            users.imageUrl = colors[users.itemtype - 1];
            if (users.itemtype == 3) {
                users.imagedownUrl = colors[2];
            }
            list.add(users);
        }
        adapter.addList(list);
        adapter.notifyDataSetChanged();
    }

}
