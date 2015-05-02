package com.puddingvideoproject.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.puddingvideo.Activity.MainActivity;
import com.puddingvideoproject.R;


/**
 * Created by lenovo on 2015/5/2.
 */
public class FragmentWelcome extends Fragment {
    private static final String KEY = "position";
    private int[] imgs = {R.mipmap.bg_splash, R.mipmap.bg_splash, R.mipmap.bg_splash};

    public static FragmentWelcome getFragment(int position) {
        FragmentWelcome fragmentWelcom = new FragmentWelcome();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY, position);
        fragmentWelcom.setArguments(bundle);

        return fragmentWelcom;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        int position = getArguments().getInt(KEY);

        ImageView imgv = (ImageView) view.findViewById(R.id.image_welcome);
        imgv.setBackgroundResource(imgs[position]);

        Button btn = (Button) view.findViewById(R.id.btnWelcome);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        if (position == 2) {
            btn.setVisibility(View.VISIBLE);
            btn.setText("点击进入");
        } else {
            btn.setVisibility(View.GONE);
        }


        return view;
    }
}
