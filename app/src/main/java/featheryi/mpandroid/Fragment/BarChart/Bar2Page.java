package featheryi.mpandroid.Fragment.BarChart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Bar2Page extends PageView {

    View view;
    Context context;

    public Bar2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_bar2, null);

        addView(view);
    }

    @Override
    public void refreshView() {

    }
}
