package featheryi.mpandroid.Util;

/**
 * Created by feather on 2017/12/29.
 */

import android.content.Context;
import android.widget.RelativeLayout;

public abstract class PageView extends RelativeLayout {

    public PageView(Context context) {
        super(context);
    }

    public abstract void refreshView();
}
