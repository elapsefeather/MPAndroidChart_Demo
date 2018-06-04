package featheryi.mpandroid;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

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
        drawer.setDrawerListener(toggle);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        使用Navigation 就一定會有 Navigation_head
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_LineChart:
                break;
            case R.id.nav_BarChart:
                break;
            case R.id.nav_PieChart:
                break;
            case R.id.nav_RadarChart:
                break;
            case R.id.nav_CandleStickChart:
                break;
            case R.id.nav_Otfe_LineChart:
                break;
            case R.id.nav_Otfe_CandleStickChart:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
