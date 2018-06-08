package featheryi.mpandroid.Util;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by feather on 2017/12/29.
 */

public class SamplePagerAdapter extends PagerAdapter {

    ArrayList<PageView> pageList;

    public void setlist(ArrayList<PageView> pageList) {
        this.pageList = pageList;
    }

    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(pageList.get(position));

        return pageList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}