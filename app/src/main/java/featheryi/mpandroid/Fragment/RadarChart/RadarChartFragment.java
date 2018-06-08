package featheryi.mpandroid.Fragment.RadarChart;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;
import featheryi.mpandroid.Util.SamplePagerAdapter;

public class RadarChartFragment extends Fragment {

    private static final String TAG = "RadarChartFragment"; //log 標記
    private static RadarChartFragment instance;
    View view;

    ArrayList<PageView> Radar_pagelist = new ArrayList<PageView>();
    ArrayList<String> Radar_tablist = new ArrayList<String>();
    android.support.design.widget.TabLayout Radar_tabLayout;
    ViewPager Radar_viewPager;
    SamplePagerAdapter Radar_pagerAdapter;

    public RadarChartFragment() {

    }

    public static RadarChartFragment newInstance() {
        if (instance == null) {
            instance = new RadarChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_radarchart, container, false);

        initData();
        initView();

        return view;
    }

    public void initData() {
        Radar_tablist.clear();
        Radar_tablist.add(getResources().getString(R.string.Radar1));
        Radar_tablist.add(getResources().getString(R.string.Radar2));

        Radar_pagelist.clear();
        Radar_pagelist.add(new Radar1Page(getActivity()));
        Radar_pagelist.add(new Radar2Page(getActivity()));

    }

    public void initView() {
        Radar_viewPager = (ViewPager) view.findViewById(R.id.Radar_ViewPager);
        Radar_pagerAdapter = new SamplePagerAdapter();
        Radar_pagerAdapter.setlist(Radar_pagelist);
        Radar_viewPager.setAdapter(Radar_pagerAdapter);

        Radar_tabLayout = (android.support.design.widget.TabLayout) view.findViewById(R.id.Radar_TabLayout);
        for (int i = 0; i < Radar_pagelist.size(); i++) {
            Radar_tabLayout.addTab(Radar_tabLayout.newTab().setText(Radar_tablist.get(i)));
        }

        Radar_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(Radar_tabLayout));
        Radar_tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(Radar_viewPager));
        Radar_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("onPageSelected", "position = " + position);
                Radar_pagelist.get(position).refreshView();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_RadarChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
