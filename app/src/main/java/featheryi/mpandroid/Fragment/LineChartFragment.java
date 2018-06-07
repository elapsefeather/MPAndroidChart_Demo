package featheryi.mpandroid.Fragment;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class LineChartFragment extends Fragment {

    private static final String TAG = "LineChartFragment"; //log 標記
    private static LineChartFragment instance;
    View view;

    LineChart lineChart;
    TextView textView;

    String textcontent = "";
    float num;
    ArrayList<Entry> entries = new ArrayList<>();
    ArrayList<String> labels = new ArrayList<String>();
    LineDataSet dataset;
    LineData data;

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

        new IntoTask().execute();

        return view;
    }

    public void init() {
        textView = (TextView) view.findViewById(R.id.LineChart_text);
        textcontent = "折線圖基礎設置\n\n" +
                "基礎設置內容：\n" +
                "   放置圖表內容、設置ＸＹ軸顯是、無資訊顯示、" +
                "拖曳/雙擊設置、折線圖範圍色彩顯示\n\n";
        textView.setText(textcontent);

//        與圖表框架相關設定
        lineChart = (LineChart) view.findViewById(R.id.LineChart);
        lineChart.setDescription("備註");
        lineChart.setNoDataTextDescription("暂时尚无数据");
        lineChart.setTouchEnabled(true);    // 可觸碰
        lineChart.setDragEnabled(true);     // 可拖曳
        lineChart.setScaleYEnabled(false);  //Y軸顯示
        lineChart.setScaleXEnabled(true);   //X軸顯示
//        data = new LineData();//X軸值,資料內容

        dataset = new LineDataSet(entries, "Days in a month");//資料值,資料稱(圖利顯示)
        data = new LineData(labels, dataset);//X軸值,資料內容
        lineChart.setData(data); // 放入空資料
        lineChart.invalidate();

//        與圖表相關內容（必須再放置資料之後設定）
        dataset.setDrawFilled(true); // 線下顏色
    }

    public void newLineData() {
        for (int i = 0; i <= 15; i++) {

            num = (int) (Math.random() * 1000) + 1;
            entries.add(new Entry(num, i));
            labels.add("" + i);
        }
        dataset = new LineDataSet(entries, "Days in a month");//資料值,資料稱(圖利顯示)
        data = new LineData(labels, dataset);//X軸值,資料內容

        InfoSetting();
    }

    public void InfoSetting() {

//        與圖表相關內容（必須再放置資料之後設定）
        dataset.setDrawFilled(true); // 線下顏色
    }

    public void notifyLineData() {
        lineChart.setData(data);
        lineChart.invalidate();
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
            newLineData();
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
            notifyLineData();
        }
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
