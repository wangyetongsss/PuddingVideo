package com.puddingvideoproject.Fragment;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.puddingvideoproject.R;


/**
 * Created by lenovo on 2015/5/2.
 */
public class Fragment_organize extends Fragment {
    private static final String KEY = "position";

    public static Fragment_organize getFragment(int position) {
        Fragment_organize fragment_organize = new Fragment_organize();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY, position);
        fragment_organize.setArguments(bundle);

        return fragment_organize;
    }

    //设置主页面的布局文件
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_organize, null);
        return view;
    }
}
