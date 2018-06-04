package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class RadarChartFragment extends Fragment {

    private static final String TAG = "RadarChartFragment"; //log 標記
    private static RadarChartFragment instance;
    View view;

    public RadarChartFragment() {

    }

    public static RadarChartFragment newInstance() {
        if (instance == null) {
            instance = new RadarChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_radarchart, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_RadarChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
