package com.puddingvideoproject.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.puddingvideo.Activity.adapter.GridAdapter;
import com.puddingvideo.Activity.customview.MyGridView;
import com.puddingvideoproject.R;

/**
 * Created by lenovo on 2015/5/3.
 */
public class Fragment_classify extends Fragment {
    private static final String KEY = "position";
    private PullToRefreshScrollView scrollview_classify;//设置整体的滚动事件
    private GridAdapter gridadapter;
    private int num = 10;

//
    public static Fragment_classify getFragment(int position) {
        Fragment_classify fragment_classify = new Fragment_classify();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY, position);
        fragment_classify.setArguments(bundle);

        return fragment_classify;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建一个视图。关于主页面番组的分类页面.初始化数值
        View view = inflater.inflate(R.layout.fragment_classify, null);
        scrollview_classify = (PullToRefreshScrollView) view.findViewById(R.id.scrollview_classify);
        //设置下拉刷新
        scrollview_classify.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
               num += 10;
                //刷新
                gridadapter.notifyDataSetChanged();
                //完成加载
                scrollview_classify.onRefreshComplete();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                Toast.makeText(getActivity(), "没有数据了", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //设置gridAdapter和linearlayout的点击事件
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        MyGridView myGridview = (MyGridView) view.findViewById(R.id.mygridview_classify);
        //创建适配器
        gridadapter = new GridAdapter(getActivity(), num);
        //设置适配器
        myGridview.setAdapter(gridadapter);
    }
}
