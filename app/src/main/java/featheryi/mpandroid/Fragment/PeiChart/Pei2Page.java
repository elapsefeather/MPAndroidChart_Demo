package featheryi.mpandroid.Fragment.PeiChart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Pei2Page extends PageView {

    Context context;
    View view;

    public Pei2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_pei2, null);

        addView(view);
    }

    @Override
    public void refreshView() {

    }
}
