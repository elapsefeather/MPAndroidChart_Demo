package featheryi.mpandroid.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import featheryi.mpandroid.MainActivity;
import featheryi.mpandroid.R;

public class FirstViewFragment extends Fragment {

    private static final String TAG = "FirstViewFragment"; //log 標記
    private static FirstViewFragment instance;
    View view;

    TextView title, content;

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
        view = inflater.inflate(R.layout.fragment_firstview, container, false);

        init();
        setInfoText();

        return view;
    }

    public void setInfoText() {
        title.setText("MPAndroidChart\nAndroid 開源圖表資源");
        String content_text = "" +
                "圖表類型：\n" +
                "   折線圖、圓餅圖、柱狀圖、雷達圖、蠟燭圖\n\n" +
                "功能介紹：\n" +
                "   XY軸繪製、自定義軸線樣式、軸線值、" +
                "基礎圖表交互(可針對圖表進行拖動和缩放操作限制)\n\n" +
                "示範版本：v2.2.4";

        content.setText(content_text);
    }

    public void init() {
        title = (TextView) view.findViewById(R.id.first_title);
        content = (TextView) view.findViewById(R.id.first_content);
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
