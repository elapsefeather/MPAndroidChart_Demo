package featheryi.mpandroid.Fragment.BarChart;

import android.content.Context;
import android.graphics.Color;
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

        init();
//        new IntoTask().execute();
        addView(view);
    }

    public void init() {

        textView = (TextView) view.findViewById(R.id.Barchart_text);
        content = "長條圖圖表內容設置\n\n" +
                "長條圖需要設置Ｘ軸\n" +
                "設置雙資料項圖\n\n";
        textView.setText(content);

        barChart = (BarChart) view.findViewById(R.id.Barchart);
        barChart.setDescription("My Chart");
        barChart.animateXY(2000, 2000);//        圖表動畫

//        放置空資料
//        data = new BarData();
        data = new BarData(getBarXAxis(), getBarDataSet());
        barChart.setData(data);
        barChart.invalidate();
    }

    private ArrayList<IBarDataSet> getBarDataSet() {

        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getBarXAxis() {
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }

    public void newBarData() {

    }

    public void notifyBarData() {

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
