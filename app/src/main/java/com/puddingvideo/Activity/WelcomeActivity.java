package com.puddingvideo.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.puddingvideoproject.Fragment.FragmentWelcome;
import com.puddingvideoproject.R;


public class WelcomeActivity extends FragmentActivity {
    private ViewPager vp;
    private ImageView imgv1, imgv2, imgv3;
    private ImageView[] imgvs = new ImageView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        vp = (ViewPager) findViewById(R.id.vp_welcome);
        vp.setAdapter(new MyAdapeter(getSupportFragmentManager()));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int arg0) {
                for (int i = 0; i < imgvs.length; i++) {
                    if (i == arg0) {
                        imgvs[i].setImageResource(R.mipmap.page_now);
                    } else {
                        imgvs[i].setImageResource(R.mipmap.page);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        init();
    }

    private void init() {
        imgv1 = (ImageView) findViewById(R.id.image1_welcome);
        imgv2 = (ImageView) findViewById(R.id.image2_welcome);
        imgv3 = (ImageView) findViewById(R.id.image3_welcome);
        imgvs[0] = imgv1;
        imgvs[1] = imgv2;
        imgvs[2] = imgv3;
    }


    private class MyAdapeter extends FragmentPagerAdapter {


        public MyAdapeter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return FragmentWelcome.getFragment(i);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
