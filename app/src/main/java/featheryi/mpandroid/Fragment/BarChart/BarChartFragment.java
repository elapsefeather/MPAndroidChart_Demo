package featheryi.mpandroid.Fragment.BarChart;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;
import featheryi.mpandroid.Util.SamplePagerAdapter;

public class BarChartFragment extends Fragment {

    private static final String TAG = "BarChartFragment";
    private static BarChartFragment instance;
    View view;

    ArrayList<PageView> Bar_pagelist = new ArrayList<PageView>();
    ArrayList<String> Bar_tablist = new ArrayList<String>();
    android.support.design.widget.TabLayout Bar_tabLayout;
    ViewPager Bar_viewPager;
    SamplePagerAdapter Bar_pagerAdapter;

    public BarChartFragment() {

    }

    public static BarChartFragment newInstance() {
        if (instance == null) {
            instance = new BarChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_barchart, container, false);

        initData();
        initView();

        return view;
    }

    public void initData() {
        Bar_tablist.clear();
        Bar_tablist.add(getResources().getString(R.string.Bar1));
        Bar_tablist.add(getResources().getString(R.string.Bar2));

        Bar_pagelist.clear();
        Bar_pagelist.add(new Bar1Page(getActivity()));
        Bar_pagelist.add(new Bar2Page(getActivity()));
    }

    public void initView() {
        Bar_viewPager = (ViewPager) view.findViewById(R.id.Bar_ViewPager);
        Bar_pagerAdapter = new SamplePagerAdapter();
        Bar_pagerAdapter.setlist(Bar_pagelist);
        Bar_viewPager.setAdapter(Bar_pagerAdapter);

        Bar_tabLayout = (android.support.design.widget.TabLayout) view.findViewById(R.id.Bar_TabLayout);
        for (int i = 0; i < Bar_pagelist.size(); i++) {
            Bar_tabLayout.addTab(Bar_tabLayout.newTab().setText(Bar_tablist.get(i)));
        }

        Bar_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(Bar_tabLayout));
        Bar_tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(Bar_viewPager));
        Bar_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Bar_pagelist.get(position).refreshView();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_BarChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
