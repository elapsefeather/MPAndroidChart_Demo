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

import java.util.ArrayList;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Bar2Page extends PageView {

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
    String content = "";

    public Bar2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_bar2, null);

        new IntoTask().execute();

        addView(view);
    }

    public void init() {

        textView = (TextView) view.findViewById(R.id.Barchart2_text);
        content = "長條圖圖表內容設置\n" +
                "＊可針對圖表資料顯示樣式做設定：\n" +
                "    @資料與頂部距離10f\n" +
                "    @資料間距設定15f\n" +
                "    @資料群間距設定50f\n" +
                "\n";
        textView.setText(content);

        barChart = (BarChart) view.findViewById(R.id.Barchart2);
        barChart.setDescription("My Chart");

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
        barDataSet1.setBarSpacePercent(15f);
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColor(getResources().getColor(R.color.valuecolor2));
        barDataSet2.setBarSpacePercent(15f);

        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);

        data = new BarData(xAxis, dataSets);
        data.setGroupSpace(50f);
        data.setDrawValues(true);//數據顯示
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
