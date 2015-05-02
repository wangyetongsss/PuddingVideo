package com.puddingvideo.Activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.puddingvideoproject.R;

/**
 * Created by lenovo on 2015/5/3.
 */
public class GridAdapter extends BaseAdapter {
    private Context context;
    private int num;

    public GridAdapter(Context context, int num) {
        this.context = context;
        this.num = num;
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//创建gridView的item

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder;
        convertView = LayoutInflater.from(context).inflate(R.layout.item_classify_gridview, null);
        //创建一个内部类的对象
        holder = new MyHolder();
        holder.text1 = (TextView) convertView.findViewById(R.id.text1_gridview);
        holder.text2 = (TextView) convertView.findViewById(R.id.text2_gridview);
        holder.text3 = (TextView) convertView.findViewById(R.id.text3_gridview);
        //设置值
        holder.text1.setText(num + "编号" + position);
        holder.text2.setText(num + "编号" + position);
        holder.text3.setText(num + "编号" + position);
        return convertView;
    }

    //创建一个内部类
    class MyHolder {
        private TextView text1, text2, text3;

    }
}
