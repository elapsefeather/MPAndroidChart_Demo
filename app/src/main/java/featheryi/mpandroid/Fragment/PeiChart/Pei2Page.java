package featheryi.mpandroid.Fragment.PeiChart;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Pei2Page extends PageView {

    public static String TAG = "Pei2Page";
    Context context;
    View view;

    private PieChart PieChart;
    TextView textView;
    // 凑成100 % 100
    private float[] y = {10f, 60f, 30f};
    private String[] x = new String[]{"A类事物", "B类事物", "C类事物"};
    ArrayList<String> xVals = new ArrayList<String>();
    ArrayList<Entry> yVals = new ArrayList<Entry>();
    ArrayList<Integer> colors = new ArrayList<Integer>();
    PieData data;
    String textcontent = "";

    public Pei2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_pei2, null);

        init();
        setData(x.length);

        addView(view);
    }

    public void init() {
        textView = (TextView) view.findViewById(R.id.PieChart2_text);
        textcontent = "圓餅圖設置\n\n" +
                "＊內部圓環設置：\n" +
                "    @分為內部圓及半透明圓\n" +
                "    @可設置中心文字內容、大小、色彩\n" +
                "    @內部圓間距、透明度、色彩、半徑\n" +
                "＊圖例設置：\n" +
                "    @圖例的大小、形狀、標籤字體\n" +
                "    @圖例換行、間距、偏移量\n" +
                "\n";
        textView.setText(textcontent);

        PieChart = (PieChart) view.findViewById(R.id.PieChart2);
        // 設置 pieChart 內部圓環屬性
        PieChart.setDrawHoleEnabled(true);               //是否顯示PieChart內部圓環(true:下面屬性才有意義)
        PieChart.setHoleRadius(28f);                     //設置PieChart內部圓的半徑(這裡設置28.0f)
        PieChart.setTransparentCircleRadius(31f);        //設置PieChart內部透明圓的半徑(這裡設置31.0f)
        PieChart.setTransparentCircleColor(Color.BLACK); //設置PieChart內部透明圓與內部圓間距(31f-28f)填充顏色
        PieChart.setTransparentCircleAlpha(50);          //設置PieChart內部透明圓與內部圓間距(31f-28f)透明度[0~255]數值越小越透明
        PieChart.setHoleColor(Color.WHITE);              //設置PieChart內部圓的顏色
        PieChart.setDrawCenterText(true);                //是否繪製PieChart內部中心文本（true：下面屬性才有意義）
        PieChart.setCenterText("Test");                  //設置PieChart內部圓文字的內容
        PieChart.setCenterTextSize(15f);                 //設置PieChart內部圓文字的大小
        PieChart.setCenterTextColor(Color.RED);          //設置PieChart內部圓文字的顏色

        // 獲取pieCahrt圖列
        Legend l = PieChart.getLegend();
        l.setEnabled(true);                     //是否啟用圖列（true：下面屬性才有意義）
        l.setForm(Legend.LegendForm.CIRCLE);  //設置圖例的形狀
        l.setFormSize(10f);                     //設置圖例的大小
        l.setFormToTextSpace(2f);             //設置每個圖例實體中標籤和形狀之間的間距
        l.setWordWrapEnabled(true);            //設置圖列換行(注意使用影響性能,僅適用legend位於圖表下面)
        l.setXEntrySpace(5f);                 //設置圖例實體之間延X軸的間距（setOrientation = HORIZONTAL有效）
        l.setYEntrySpace(4f);                  //設置圖例實體之間延Y軸的間距（setOrientation = VERTICAL有效）
        l.setYOffset(0f);                      //設置比例塊Y軸偏移量
        l.setTextSize(14f);                    //設置圖例標籤文本的大小
        l.setTextColor(getResources().getColor(R.color.textcolor_black)); //設置圖例標籤文本的顏色
    }

    private void setData(int count) {
        xVals.clear();
        yVals.clear();
        for (int xi = 0; xi < count; xi++) {
            xVals.add(xi, x[xi]);
            yVals.add(new Entry(y[xi], xi));
        }

        PieDataSet yDataSet = new PieDataSet(yVals, "百分比占");

        // 每个百分比占区块绘制的不同颜色
        colors.add(getResources().getColor(R.color.valuecolor1));
        colors.add(getResources().getColor(R.color.valuecolor2));
        colors.add(getResources().getColor(R.color.valuecolor3));
        yDataSet.setColors(colors);

        data = new PieData(xVals, yDataSet);
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
