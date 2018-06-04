package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class OtfeLineChartFragment extends Fragment {

    private static final String TAG = "OtfeLineChartFragment"; //log 標記
    private static OtfeLineChartFragment instance;
    View view;

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
        return view;
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
