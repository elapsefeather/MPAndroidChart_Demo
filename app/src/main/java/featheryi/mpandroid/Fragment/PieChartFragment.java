package featheryi.mpandroid.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class PieChartFragment extends Fragment {

    private static final String TAG = "PieChartFragment"; //log 標記
    private static PieChartFragment instance;
    View view;

    private PieChart mChart;
    private String[] x = new String[]{"A类事物", "B类事物", "C类事物"};
    // 凑成100 % 100
    private float[] y = {10f, 60f, 30f};

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

        mChart = (PieChart) view.findViewById(R.id.PieChart);

        // 以3个对应数据集做测试
        setData(x.length);

        return view;
    }

    private void setData(int count) {

        // 准备x"轴"数据：在i的位置，显示x[i]字符串
        ArrayList<String> xVals = new ArrayList<String>();

        // 真实的饼状图百分比分区。
        // Entry包含两个重要数据内容：position和该position的数值。
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int xi = 0; xi < count; xi++) {
            xVals.add(xi, x[xi]);

            // y[i]代表在x轴的i位置真实的百分比占
            yVals.add(new Entry(y[xi], xi));
        }

        PieDataSet yDataSet = new PieDataSet(yVals, "百分比占");

        // 每个百分比占区块绘制的不同颜色
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.parseColor("#FFBB77"));
        colors.add(Color.parseColor("#A3D1D1"));
        colors.add(Color.parseColor("#CA8EC2"));
        yDataSet.setColors(colors);

        // 将x轴和y轴设置给PieData作为数据源
        PieData data = new PieData(xVals, yDataSet);

        // 设置成PercentFormatter将追加%号
        data.setValueFormatter(new PercentFormatter());

        // 文字的颜色
        data.setValueTextColor(Color.BLACK);
        data.setValueTextSize(12f);

        // 最终将全部完整的数据喂给PieChart
        mChart.setData(data);
        mChart.invalidate();
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
