package featheryi.mpandroid.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class RadarChartFragment extends Fragment {

    private static final String TAG = "RadarChartFragment"; //log 標記
    private static RadarChartFragment instance;
    View view;

    RadarChart RadarChart;
    ArrayList<Entry> entries = new ArrayList();
    ArrayList<Entry> entries2 = new ArrayList();

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

        init();

        return view;
    }

    public void init() {
        RadarChart = (RadarChart) view.findViewById(R.id.RadarChart);

        RadarData data = new RadarData(labelSets(), dataSets());
        RadarChart.setData(data);

        RadarChart.setWebLineWidthInner(0.5f);
        RadarChart.setDescriptionColor(Color.RED);
        RadarChart.invalidate();//刷新數據
        RadarChart.animate();//動畫效果
    }

    public ArrayList<String> labelSets() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Value1");
        labels.add("Value2");
        labels.add("Value3");
        labels.add("Value4");
        labels.add("Value5");

        return labels;
    }

    public ArrayList<IRadarDataSet> dataSets() {
        for (int i = 0; i < 5; i++) {
            entries.add(new Entry(2f * i, i));
            entries2.add(new Entry(3f * (4 - i), i));
        }

        RadarDataSet dataset_comp1 = new RadarDataSet(entries, "Company1");
        RadarDataSet dataset_comp2 = new RadarDataSet(entries2, "Company2");
        //設置線顏色
        dataset_comp1.setColor(Color.parseColor("#CA8EC2"));
        dataset_comp2.setColor(Color.parseColor("#4F9D9D"));

        //填充繪製圖表區域的顏色
        dataset_comp1.setDrawFilled(true);
        dataset_comp2.setDrawFilled(true);
        dataset_comp1.setFillColor(Color.parseColor("#CA8EC2"));
        dataset_comp2.setFillColor(Color.parseColor("#4F9D9D"));

        ArrayList<IRadarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset_comp1);
        dataSets.add(dataset_comp2);

        return dataSets;
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
