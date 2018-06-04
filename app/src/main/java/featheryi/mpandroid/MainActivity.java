package featheryi.mpandroid;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import featheryi.mpandroid.Fragment.BarChartFragment;
import featheryi.mpandroid.Fragment.CandleStickChartFragment;
import featheryi.mpandroid.Fragment.FirstViewFragment;
import featheryi.mpandroid.Fragment.LineChartFragment;
import featheryi.mpandroid.Fragment.OtfeCandleChartFragment;
import featheryi.mpandroid.Fragment.OtfeLineChartFragment;
import featheryi.mpandroid.Fragment.PieChartFragment;
import featheryi.mpandroid.Fragment.RadarChartFragment;

/*
   implementation 'com.github.PhilJay:MPAndroidChart:v3.0.3'

   allprojects {
       repositories {
           maven { url 'https://jitpack.io' }
       }
   }
*/
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    Toolbar toolbar;
    public static ActionBar actionbar;
    NavigationView navigationView;

    public static FragmentManager fragmentManager;
    public static FragmentTransaction trans;
    public static FirstViewFragment firstViewFragment;
    public static LineChartFragment lineChartFragment;
    public static BarChartFragment barChartFragment;
    public static PieChartFragment pieChartFragment;
    public static RadarChartFragment radarChartFragment;
    public static CandleStickChartFragment candleStickChartFragment;
    public static OtfeLineChartFragment otfeLineChartFragment;
    public static OtfeCandleChartFragment otfeCandleChartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        init();

    }

    public void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        FirstView();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        使用Navigation 就一定會有 Navigation_head
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_LineChart:

                trans = fragmentManager.beginTransaction();
                lineChartFragment = LineChartFragment.newInstance();
                trans.replace(R.id.main_fragment, lineChartFragment);
                trans.commit();
                break;

            case R.id.nav_BarChart:

                trans = fragmentManager.beginTransaction();
                barChartFragment = BarChartFragment.newInstance();
                trans.replace(R.id.main_fragment, barChartFragment);
                trans.commit();
                break;

            case R.id.nav_PieChart:

                trans = fragmentManager.beginTransaction();
                pieChartFragment = PieChartFragment.newInstance();
                trans.replace(R.id.main_fragment, pieChartFragment);
                trans.commit();
                break;

            case R.id.nav_RadarChart:

                trans = fragmentManager.beginTransaction();
                radarChartFragment = RadarChartFragment.newInstance();
                trans.replace(R.id.main_fragment, radarChartFragment);
                trans.commit();
                break;

            case R.id.nav_CandleStickChart:

                trans = fragmentManager.beginTransaction();
                candleStickChartFragment = CandleStickChartFragment.newInstance();
                trans.replace(R.id.main_fragment, candleStickChartFragment);
                trans.commit();
                break;

            case R.id.nav_Otfe_LineChart:

                trans = fragmentManager.beginTransaction();
                otfeLineChartFragment = OtfeLineChartFragment.newInstance();
                trans.replace(R.id.main_fragment, otfeLineChartFragment);
                trans.commit();
                break;

            case R.id.nav_Otfe_CandleStickChart:

                trans = fragmentManager.beginTransaction();
                otfeCandleChartFragment = OtfeCandleChartFragment.newInstance();
                trans.replace(R.id.main_fragment, otfeCandleChartFragment);
                trans.commit();
                break;
        }

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    public void FirstView() {
        trans = fragmentManager.beginTransaction();
        firstViewFragment = FirstViewFragment.newInstance();
        trans.add(R.id.main_fragment, firstViewFragment);
        trans.commit();
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        OptionsMenu >> toorbar 的宣告
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        OptionsItem >> 監聽
        return super.onOptionsItemSelected(item);
    }
}
