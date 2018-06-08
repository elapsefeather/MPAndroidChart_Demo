package featheryi.mpandroid.Fragment.CandleStickChart;

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

public class CandleStickChartFragment extends Fragment {

    private static final String TAG = "CandleStickChartFragment"; //log 標記
    private static CandleStickChartFragment instance;
    View view;

    ArrayList<PageView> Candle_pagelist = new ArrayList<PageView>();
    ArrayList<String> Candle_tablist = new ArrayList<String>();
    android.support.design.widget.TabLayout Candle_tabLayout;
    ViewPager Candle_viewPager;
    SamplePagerAdapter Candle_pagerAdapter;

    public CandleStickChartFragment() {

    }

    public static CandleStickChartFragment newInstance() {
        if (instance == null) {
            instance = new CandleStickChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_candlestickchart, container, false);

        initData();
        initView();

        return view;
    }

    public void initData() {
        Candle_tablist.clear();
        Candle_tablist.add(getResources().getString(R.string.Candle1));
        Candle_tablist.add(getResources().getString(R.string.Candle2));

        Candle_pagelist.clear();
        Candle_pagelist.add(new Candle1Page(getActivity()));
        Candle_pagelist.add(new Candle2Page(getActivity()));

    }

    public void initView() {
        Candle_viewPager = (ViewPager) view.findViewById(R.id.Candle_ViewPager);
        Candle_pagerAdapter = new SamplePagerAdapter();
        Candle_pagerAdapter.setlist(Candle_pagelist);
        Candle_viewPager.setAdapter(Candle_pagerAdapter);

        Candle_tabLayout = (android.support.design.widget.TabLayout) view.findViewById(R.id.Candle_TabLayout);
        for (int i = 0; i < Candle_pagelist.size(); i++) {
            Candle_tabLayout.addTab(Candle_tabLayout.newTab().setText(Candle_tablist.get(i)));
        }

        Candle_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(Candle_tabLayout));
        Candle_tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(Candle_viewPager));
        Candle_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("onPageSelected", "position = " + position);
                Candle_pagelist.get(position).refreshView();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_CandleStickChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
