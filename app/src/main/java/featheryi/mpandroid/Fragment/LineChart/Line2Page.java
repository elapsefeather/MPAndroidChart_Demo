package featheryi.mpandroid.Fragment.LineChart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Line2Page extends PageView {

    View view;
    Context context;

    public Line2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_line2, null);

        addView(view);
    }

    @Override
    public void refreshView() {

    }
}
