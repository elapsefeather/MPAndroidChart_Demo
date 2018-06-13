package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class OtfeLineChartFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "OtfeLineChartFragment"; //log 標記
    private static OtfeLineChartFragment instance;
    View view;

    Button AddEntry, RemoveLastEntry, AddDataSet, RemoveLastDataSet, ClearChart, SetEmptyLineData;
    LineChart lineChart;
    TextView textView;

    String textcontent = "";
    ArrayList<Entry> entries = new ArrayList<>();
    LineData data = new LineData();

    public OtfeLineChartFragment() {

    }

    public static OtfeLineChartFragment newInstance() {
        if (instance == null) {
            instance = new OtfeLineChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_otfe_linechart, container, false);

        init();

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.OtfeLineChart_btn_addEntry:
                addEntry();
                break;
            case R.id.OtfeLineChart_btn_removeLastEntry:
                break;
            case R.id.OtfeLineChart_btn_addDataSet:
                break;
            case R.id.OtfeLineChart_btn_removeLastDataSet:
                break;
            case R.id.OtfeLineChart_btn_clearChart:
                clearChart();
                break;
            case R.id.OtfeLineChart_btn_setEmptyLineData:
                setEmptyLineData();
                break;
        }
    }

    public void addEntry() {
        float num = (int) (Math.random() * 1000) + 1;
        LineData lineData = lineChart.getLineData();
        if (lineData == null) {
            lineChart.setData(new LineData());
        }

        int lineDataCount = lineData.getDataSetCount();
        textView.setText(lineDataCount+"");
        lineData.addEntry(new Entry(num, lineDataCount), lineDataCount-1);

        lineChart.notifyDataSetChanged();
        lineChart.invalidate();
    }

    public void clearChart() {
//        清空圖表
        lineChart.clear();
    }

    public void setEmptyLineData() {
        lineChart.setData(new LineData());
        lineChart.invalidate();
    }

    public void init() {
        textView = (TextView) view.findViewById(R.id.OtfeLineChart_text);
        textcontent = "\n" +
                "\n";
        textView.setText(textcontent);

        AddEntry = (Button) view.findViewById(R.id.OtfeLineChart_btn_addEntry);
        AddEntry.setOnClickListener(this);

        RemoveLastEntry = (Button) view.findViewById(R.id.OtfeLineChart_btn_removeLastEntry);
        RemoveLastEntry.setOnClickListener(this);

        AddDataSet = (Button) view.findViewById(R.id.OtfeLineChart_btn_addDataSet);
        AddDataSet.setOnClickListener(this);

        RemoveLastDataSet = (Button) view.findViewById(R.id.OtfeLineChart_btn_removeLastDataSet);
        RemoveLastDataSet.setOnClickListener(this);

        ClearChart = (Button) view.findViewById(R.id.OtfeLineChart_btn_clearChart);
        ClearChart.setOnClickListener(this);

        SetEmptyLineData = (Button) view.findViewById(R.id.OtfeLineChart_btn_setEmptyLineData);
        SetEmptyLineData.setOnClickListener(this);

//        與圖表框架相關設定
        lineChart = (LineChart) view.findViewById(R.id.OtfeLineChart);
        lineChart.setDescription("備註");
        lineChart.setNoDataTextDescription("暂时尚无数据");
        lineChart.setTouchEnabled(true);    // 可觸碰
        lineChart.setDragEnabled(true);     // 可拖曳
        lineChart.setScaleYEnabled(false);  //Y軸顯示
        lineChart.setScaleXEnabled(true);   //X軸顯示
        lineChart.setData(data);
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_OtfeLineChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
