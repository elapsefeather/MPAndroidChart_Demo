package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class LineChartFragment extends Fragment {

    private static final String TAG = "LineChartFragment"; //log 標記
    private static LineChartFragment instance;
    View view;

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


        return view;
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
