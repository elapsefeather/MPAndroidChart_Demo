package featheryi.mpandroid.Fragment.CandleStickChart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;
import java.util.List;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Candle1Page extends PageView {

    View view;
    Context context;

    CandleStickChart candleStickChart;
    ArrayList<String> xVals = new ArrayList<>();
    ArrayList<CandleEntry> ceList = new ArrayList<>();
    String[] XVALUE = {"0", "1", "2", "3", "4"};

    public Candle1Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_candle1, null);

        init();     //宣告
        setchart(); //設置圖表
        setAxis();  //設置xy軸
        setlegend();//設置圖例
        setdata();  //塞資料

        addView(view);
    }


    public void setdata() {
        //內容資料
        for (int i = 0; i < XVALUE.length; i++) {
            xVals.add(XVALUE[i]);
        }
//                                 (i, high, low, open, close)
        ceList.add(new CandleEntry(0, 4.62f, 2.02f, 2.70f, 4.13f));
        ceList.add(new CandleEntry(1, 5.50f, 2.70f, 3.35f, 4.96f));
        ceList.add(new CandleEntry(2, 5.25f, 3.02f, 3.50f, 4.50f));
        ceList.add(new CandleEntry(3, 6.00f, 3.25f, 4.40f, 5.00f));
        ceList.add(new CandleEntry(4, 5.57f, 2.00f, 2.80f, 4.50f));

        //資料顯示設定
        CandleDataSet cds = new CandleDataSet(ceList, "Entries");
        cds.setColor(Color.rgb(80, 80, 80));
        cds.setShadowColor(Color.DKGRAY);   //影線顏色
        cds.setShadowWidth(0.7f);   //影線
        cds.setDecreasingColor(Color.RED);  //上漲色
        cds.setDecreasingPaintStyle(Paint.Style.FILL);  //實心
        cds.setIncreasingColor(Color.rgb(122, 242, 84));    //下掉色
        cds.setIncreasingPaintStyle(Paint.Style.STROKE);    //空心
        cds.setNeutralColor(Color.BLUE); //未變動色
        cds.setValueTextColor(Color.RED);
        cds.setDrawValues(false);//在图表中的元素上面是否显示数值
        cds.setHighlightLineWidth(1f);//选中蜡烛时的线宽
        cds.setLabel("CandleStickChart");//图表名称，可以通过mChart.getLegend().setEnable(true)显示在标注上
        cds.setShadowColorSameAsCandle(true);

        CandleData candleData = new CandleData(xVals);
        candleData.addDataSet(cds);

        //放入圖表、更新
        candleStickChart.setData(candleData);
        candleStickChart.invalidate();
    }

    public void setlegend() {

        //圖例
        // get the legend (only possible after setting data)
        Legend l = candleStickChart.getLegend();  // 设置比例图标示
        l.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);  //显示位置
        l.setForm(Legend.LegendForm.SQUARE);// 样式
        l.setFormSize(6f);// 字号
        l.setTextColor(Color.WHITE);// 颜色
//        l.setTypeface(mTf);// 字体

        List<String> labels = new ArrayList<>();
        labels.add("红涨");
        labels.add("绿跌");
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        l.setExtra(colors, labels);//设置标注的颜色及内容，设置的效果如下图
        l.setEnabled(false);//决定显不显示标签
    }

    public void setAxis() {

        //XY軸
        XAxis xAxis = candleStickChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setSpaceBetweenLabels(12);//轴刻度间的宽度，默认值是4
        xAxis.setGridColor(Color.parseColor("#123456"));//X轴刻度线颜色
        xAxis.setTextColor(Color.parseColor("#123456"));//X轴文字颜色

        YAxis leftAxis = candleStickChart.getAxisLeft();
        leftAxis.setEnabled(true);
        leftAxis.setLabelCount(7, false);
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setGridColor(Color.parseColor("#123456"));//y轴刻度线颜色
        leftAxis.setTextColor(Color.parseColor("#123456"));//y轴文字颜色

        YAxis rightAxis = candleStickChart.getAxisRight();//右邊Y軸設置
        rightAxis.setEnabled(false);
    }

    public void setchart() {

//        candleStickChart.setStartAtZero(true);
//        candleStickChart.setDrawYValues(false); // disable the drawing of values into the mChart
//        candleStickChart.setDrawBorder(false);   //是否在折线图上添加边框
        candleStickChart.setDescription("");// 数据描述
        candleStickChart.setNoDataTextDescription("You need to provide data for the mChart.");  //如果没有数据的时候，会显示这个，类似listview的emtpyview
//        candleStickChart.setDrawVerticalGrid(false); // enable / disable grid lines
//        candleStickChart.setDrawHorizontalGrid(false);
        candleStickChart.setDrawGridBackground(false); // 是否显示表格颜色
        candleStickChart.setBackgroundColor(Color.parseColor("#123456"));// 设置背景
        candleStickChart.setGridBackgroundColor(Color.parseColor("#E8E8E8"));//设置表格背景色
//        candleStickChart.setGridColor(Color.parseColor("#FFF0D4")); // 表格线的颜色，在这里是是给颜色设置一个透明度
//        candleStickChart.setGridWidth(1.25f);// 表格线的线宽
        candleStickChart.setTouchEnabled(true); // enable touch gestures
        candleStickChart.setDragEnabled(true);// 是否可以拖拽
        candleStickChart.setScaleEnabled(true);// 是否可以缩放
        candleStickChart.setPinchZoom(false);// if disabled, scaling can be done on x- and y-axis separately
        candleStickChart.setScaleYEnabled(false);// if disabled, scaling can be done on x-axis
        candleStickChart.setScaleXEnabled(false);// if disabled, scaling can be done on  y-axis
//        candleStickChart.setValueTypeface(mTf);// 设置字体
        candleStickChart.getLegend().setEnabled(true);//圖表名鞥
        candleStickChart.animateX(2500); // 立即执行的动画,x轴
    }

    public void init() {

        candleStickChart = (CandleStickChart) view.findViewById(R.id.CandleStickChart);
    }

    @Override
    public void refreshView() {

    }
}
