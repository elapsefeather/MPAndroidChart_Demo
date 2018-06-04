package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class OtfeCandleChartFragment extends Fragment {

    private static final String TAG = "OtfeCandleChartFragment"; //log 標記
    private static OtfeCandleChartFragment instance;
    View view;

    public OtfeCandleChartFragment() {

    }

    public static OtfeCandleChartFragment newInstance() {
        if (instance == null) {
            instance = new OtfeCandleChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_otfe_candle_chart, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_OtfeCandleStickChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
