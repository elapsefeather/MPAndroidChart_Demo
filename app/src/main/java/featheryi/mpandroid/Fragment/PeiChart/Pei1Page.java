package featheryi.mpandroid.Fragment.PeiChart;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Pei1Page extends PageView {

    public static String TAG = "Pei1Page";
    View view;
    Context context;

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

    public Pei1Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_pei1, null);

        init();
        setData(x.length);

        addView(view);
    }

    public void init() {
        PieChart = (PieChart) view.findViewById(R.id.PieChart);
        textView = (TextView) view.findViewById(R.id.PieChart_text);
        textcontent = "圓餅圖基礎設置\n\n" +
                "＊圓餅可旋轉、標籤會隨方向轉正\n" +
                "＊設置統一標籤樣式、色彩、字型大小\n" +
                "＊需成套配置資料列：\n" +
                "    @標籤名稱\n" +
                "    @X值為數量指標\n" +
                "    @Y值為百分比計算指標\n" +
                "    @色彩顯示列表\n" +
                "\n";
        textView.setText(textcontent);
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
