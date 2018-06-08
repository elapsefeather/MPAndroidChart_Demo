package featheryi.mpandroid.Fragment.RadarChart;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import featheryi.mpandroid.R;
import featheryi.mpandroid.Util.PageView;

public class Radar2Page extends PageView {

    View view;
    Context context;

    public Radar2Page(Context context) {
        super(context);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.page_radar2, null);

        addView(view);
    }

    @Override
    public void refreshView() {

    }
}
