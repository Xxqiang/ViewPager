package com.xxqiang.viewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xxqiang.view.ViewpagerIndicator;

public class MainActivity extends FragmentActivity  {

    private ViewPager mViewpager;
    private ViewpagerIndicator mIndicator;
    private List<String> mTitles = Arrays.asList("推荐1","上肢2","下肢3","推荐4","上肢5","下肢6","推荐7","上肢8","下肢9 ");
    private List<VpSimpleFragment> mContents = new ArrayList<VpSimpleFragment>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        mIndicator.setVisibleTabCount(4);
        mIndicator.setTabItems(mTitles);
        mIndicator.setViewPager(mViewpager,0);
        mViewpager.setAdapter(mAdapter);

    }

    private void initData() {
        for (String title: mTitles){
            VpSimpleFragment fragment=VpSimpleFragment.newInstance(title);
            mContents.add(fragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mContents.size();
            }
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }
        };

    }

    private void initView() {
        mViewpager= (ViewPager) findViewById(R.id.id_viewpager);
        mIndicator= (ViewpagerIndicator) findViewById(R.id.id_indicator);
    }
}
