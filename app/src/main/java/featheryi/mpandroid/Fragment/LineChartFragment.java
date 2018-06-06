package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class LineChartFragment extends Fragment {

    private static final String TAG = "LineChartFragment"; //log 標記
    private static LineChartFragment instance;
    View view;

    LineChart lineChart;
    float num;

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

        lineChart = (LineChart) view.findViewById(R.id.LineChart);
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 1; i <= 15; i++) {

            num = (int) (Math.random() * 1000) + 1;
            entries.add(new Entry(num, i));
            labels.add("" + i);
        }

        LineDataSet dataset = new LineDataSet(entries, "Days in a month");
        LineData data = new LineData(labels, dataset);
        lineChart.setData(data); // 放入資料
        lineChart.setDescription("Description");
        dataset.setDrawFilled(true); // 線下顏色
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); // 顏色設定

        return view;
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
