package featheryi.mpandroid.PeiChart;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Pei1Page extends PageView {

    View view;
    Context context;

    private PieChart PieChart;
    private String[] x = new String[]{"A类事物", "B类事物", "C类事物"};
    // 凑成100 % 100
    private float[] y = {10f, 60f, 30f};


    public Pei1Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_pei1, null);

        PieChart = (PieChart) view.findViewById(R.id.PieChart);

        // 以3个对应数据集做测试
        setData(x.length);

        addView(view);
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
        PieChart.setData(data);
        PieChart.invalidate();
    }

    @Override
    public void refreshView() {

    }
}
