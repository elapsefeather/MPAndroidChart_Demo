package featheryi.mpandroid.Fragment.BarChart;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Bar3Page extends PageView {

    private static final String TAG = "Bar2Page";
    View view;
    Context context;

    TextView textView;
    BarChart barChart;
    BarData data;
    //    資料
    ArrayList<IBarDataSet> dataSets = new ArrayList<>();
    ArrayList<BarEntry> valueSet1 = new ArrayList<>();
    ArrayList<BarEntry> valueSet2 = new ArrayList<>();
    //  X軸
    ArrayList<String> xAxis = new ArrayList<>();
    XAxis xl;
    YAxis leftAxis;
    String content = "";

    public Bar3Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_bar3, null);

        new IntoTask().execute();

        addView(view);
    }

    public void init() {

        textView = (TextView) view.findViewById(R.id.Barchart3_text);
        content = "長條圖圖表內容設置\n" +
                "＊可針對XY軸顯示樣式做設定：\n" +
                "    @X軸顯示於下方、\n" +
                "       斜角20度、\n" +
                "       每個標籤間距15\n" +
                "       (小于距离将不显示，\n" +
                "       需要放大图标才能看到)\n" +
                "    @Y軸不畫線、\n" +
                "       顯示左邊隱藏右邊、\n" +
                "       最小顯示值0\n" +
                "＊高亮線設置：(配合Y軸設置)\n" +
                "    @高亮線寬度、色彩\n" +
                "    @提示字大小、色彩\n" +
                "    @可設置多條、顯示前後\n" +
                "＊針對數據設定：\n" +
                "    @不顯示數據標籤\n" +
                "\n";
        textView.setText(content);

        barChart = (BarChart) view.findViewById(R.id.Barchart3);
        barChart.setDescription("My Chart");

        xl = barChart.getXAxis();
        xl.setLabelRotationAngle(-20);//设置x轴字体显示角度
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置X轴的位置TOP, BOTTOM, BOTH_SIDED, TOP_INSIDE, BOTTOM_INSIDE
        xl.setSpaceBetweenLabels(15);
        //设置Lable之间的距离（字符），小于距离将不显示，需要放大图标才能看到

        leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);//是否画线
        leftAxis.setSpaceTop(10f);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)
        barChart.getAxisRight().setEnabled(false);

        //      高亮線
        LimitLine ll = new LimitLine(70f, "血压偏高");
        ll.setLineColor(Color.RED);
        ll.setLineWidth(4f);
        ll.setTextColor(Color.BLACK);
        ll.setTextSize(12f);
        leftAxis.addLimitLine(ll);

        LimitLine ll2 = new LimitLine(30f, "血压偏低");
        ll2.setLineColor(Color.RED);
        ll2.setLineWidth(2f);
        ll2.setTextColor(Color.BLACK);
        ll2.setTextSize(12f);
        leftAxis.addLimitLine(ll2);

//        放置空資料
        data = new BarData();
        barChart.setData(data);
        barChart.invalidate();
    }

    public void newBarData() {
        int num1 = 0, num2 = 0;
        xAxis.clear();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");

        for (int i = 0; i <= 5; i++) {
            num1 = (int) (Math.random() * 100) + 1;
            num2 = (int) (Math.random() * 100) + 1;

            BarEntry v1e1 = new BarEntry(num1, i);
            valueSet1.add(v1e1);
            BarEntry v2e1 = new BarEntry(num2, i);
            valueSet2.add(v2e1);
        }
    }

    public void notifyBarData() {

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(getResources().getColor(R.color.valuecolor1));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColor(getResources().getColor(R.color.valuecolor2));

        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);

        data = new BarData(xAxis, dataSets);
        data.setGroupSpace(10f);
        data.setDrawValues(false);//數據顯示
        barChart.setData(data);
        barChart.invalidate();
    }

    private class IntoTask extends AsyncTask<Void, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "init");
            init();
        }

        @Override
        protected Integer doInBackground(Void... params) {
            Log.i(TAG, "newLineData");
            newBarData();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.i(TAG, "notifyLineData");
            notifyBarData();
        }
    }

    @Override
    public void refreshView() {

    }
}
