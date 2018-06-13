package featheryi.mpandroid.Fragment.BarChart;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Bar1Page extends PageView {

    View view;
    Context context;
    private static final String TAG = "Bar1Page";

    TextView textView;
    BarChart barChart;
    BarData data;
    //    資料
    ArrayList<IBarDataSet> dataSets = null;
    ArrayList<BarEntry> valueSet1 = new ArrayList<>();
    ArrayList<BarEntry> valueSet2 = new ArrayList<>();
    //  X軸
    ArrayList<String> xAxis = new ArrayList<>();

    String content = "";

    public Bar1Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_bar1, null);

        new IntoTask().execute();

        addView(view);
    }

    public void init() {

        textView = (TextView) view.findViewById(R.id.Barchart_text);
        content = "長條圖圖表基礎設置\n" +
                "＊長條圖需要設置Ｘ軸\n" +
                "＊設置雙資料項圖\n" +
                "＊設置動畫效果\n" +
                "＊資料條可以分成多色彩 setColors\n" +
                "    或單色彩 setColor 顯示\n" +
                "\n";
        textView.setText(content);

        barChart = (BarChart) view.findViewById(R.id.Barchart);
        barChart.setDescription("My Chart");
        barChart.animateXY(2000, 2000);//        圖表動畫

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

            BarEntry v1e1 = new BarEntry(num1, i); // Jan
            valueSet1.add(v1e1);
            BarEntry v2e1 = new BarEntry(num2, i); // Jan
            valueSet2.add(v2e1);
        }
    }

    public void notifyBarData() {

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(getResources().getColor(R.color.valuecolor1));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        data = new BarData(xAxis, dataSets);
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
