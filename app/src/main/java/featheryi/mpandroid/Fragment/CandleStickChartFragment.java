package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class CandleStickChartFragment extends Fragment {

    private static final String TAG = "CandleStickChartFragment"; //log 標記
    private static CandleStickChartFragment instance;
    View view;

    public CandleStickChartFragment() {

    }

    public static CandleStickChartFragment newInstance() {
        if (instance == null) {
            instance = new CandleStickChartFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_candlestickchart, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.nav_CandleStickChart));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
