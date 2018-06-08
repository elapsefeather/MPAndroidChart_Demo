package featheryi.mpandroid.Fragment.PeiChart;

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

public class PieChartFragment extends Fragment {

    private static final String TAG = "PieChartFragment"; //log 標記
    private static PieChartFragment instance;
    View view;

    ArrayList<PageView> Pei_pagelist = new ArrayList<PageView>();
    ArrayList<String> Pei_tablist = new ArrayList<String>();
    android.support.design.widget.TabLayout Pei_tabLayout;
    ViewPager Pei_viewPager;
    SamplePagerAdapter Pei_pagerAdapter;

    public PieChartFragment() {

    }

    public static PieChartFragment newInstance() {
        if (instance == null) {
            instance = new PieChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_piechart, container, false);

        initData();
        initView();

        return view;
    }

    public void initData() {
        Pei_tablist.clear();
        Pei_tablist.add(getResources().getString(R.string.Pei1));
        Pei_tablist.add(getResources().getString(R.string.Pei2));

        Pei_pagelist.clear();
        Pei_pagelist.add(new Pei1Page(getActivity()));
        Pei_pagelist.add(new Pei2Page(getActivity()));

    }

    public void initView() {
        Pei_viewPager = (ViewPager) view.findViewById(R.id.Pie_ViewPager);
        Pei_pagerAdapter = new SamplePagerAdapter();
        Pei_pagerAdapter.setlist(Pei_pagelist);
        Pei_viewPager.setAdapter(Pei_pagerAdapter);

        Pei_tabLayout = (android.support.design.widget.TabLayout) view.findViewById(R.id.Pie_TabLayout);
        for (int i = 0; i < Pei_pagelist.size(); i++) {
            Pei_tabLayout.addTab(Pei_tabLayout.newTab().setText(Pei_tablist.get(i)));
        }

        Pei_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(Pei_tabLayout));
        Pei_tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(Pei_viewPager));
        Pei_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Pei_pagelist.get(position).refreshView();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_PieChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
