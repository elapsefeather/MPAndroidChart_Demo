package featheryi.mpandroid.Fragment.CandleStickChart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Candle2Page extends PageView {

    View view;
    Context context;

    public Candle2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_candle2,null);

        addView(view);
    }

    @Override
    public void refreshView() {

    }
}
