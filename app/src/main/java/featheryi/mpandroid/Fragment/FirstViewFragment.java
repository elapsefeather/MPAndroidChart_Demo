package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class FirstViewFragment extends Fragment {

    private static final String TAG = "FirstViewFragment"; //log 標記
    private static FirstViewFragment instance;
    View view;

    public FirstViewFragment() {

    }

    public static FirstViewFragment newInstance() {
        if (instance == null) {
            instance = new FirstViewFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_firstview, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.actionbar.setTitle(getString(R.string.app_name));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
