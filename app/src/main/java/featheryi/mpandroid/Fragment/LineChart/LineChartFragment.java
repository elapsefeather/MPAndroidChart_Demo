package featheryi.mpandroid.Fragment.LineChart;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;
import featheryi.mpandroid.Util.SamplePagerAdapter;

public class LineChartFragment extends Fragment {

    private static final String TAG = "LineChartFragment"; //log 標記
    private static LineChartFragment instance;
    View view;

    ArrayList<PageView> Line_pagelist = new ArrayList<PageView>();
    ArrayList<String> Line_tablist = new ArrayList<String>();
    android.support.design.widget.TabLayout Line_tabLayout;
    ViewPager Line_viewPager;
    SamplePagerAdapter Line_pagerAdapter;

    public LineChartFragment() {
    }

    public static LineChartFragment newInstance() {
        if (instance == null) {
            instance = new LineChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_linechart, container, false);

        initData();
        initView();

        return view;
    }

    public void initData() {
        Line_tablist.clear();
        Line_tablist.add(getResources().getString(R.string.Line1));
        Line_tablist.add(getResources().getString(R.string.Line2));

        Line_pagelist.clear();
        Line_pagelist.add(new Line1Page(getActivity()));
        Line_pagelist.add(new Line2Page(getActivity()));
    }

    public void initView() {
        Line_viewPager = (ViewPager) view.findViewById(R.id.Line_ViewPager);
        Line_pagerAdapter = new SamplePagerAdapter();
        Line_pagerAdapter.setlist(Line_pagelist);
        Line_viewPager.setAdapter(Line_pagerAdapter);

        Line_tabLayout = (android.support.design.widget.TabLayout) view.findViewById(R.id.Line_TabLayout);
        for (int i = 0; i < Line_pagelist.size(); i++) {
            Line_tabLayout.addTab(Line_tabLayout.newTab().setText(Line_tablist.get(i)));
        }

        Line_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(Line_tabLayout));
        Line_tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(Line_viewPager));
        Line_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Line_pagelist.get(position).refreshView();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_LineChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
