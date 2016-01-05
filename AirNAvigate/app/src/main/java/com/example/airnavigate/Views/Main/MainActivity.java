package com.example.airnavigate.Views.Main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.airnavigate.Modules.MainActivityModule;
import com.example.airnavigate.MyApplication;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseToolbarActivity;
import com.example.airnavigate.Views.Drawer.NavDrawerFragment;

import javax.inject.Inject;

public class MainActivity extends BaseToolbarActivity implements NavDrawerFragment.NavigationDrawerCallbacks
{

    NavDrawerFragment drawer;

    @Inject
    FragmentDispatcher mDispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDispatcher.onCreate();
        drawer = (NavDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer);
        drawer.setUp(
                R.id.drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        mDispatcher.displayNavigationDrawerItem(FragmentDispatcher.NavDrawerItems.THEMATIC_BLOCKS, true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setupActivityComponent() {
        //Uncomment those lines do measure dependencies creation time
        //Debug.startMethodTracing("SplashTrace");
        MyApplication.get(this)
                .getAppComponent()
                .initMainActivityComponent(new MainActivityModule(this))
                .inject(this);
        //Debug.stopMethodTracing();
    }



    @Override
    public void onNavigationDrawerItemSelected(int position, boolean calledByUserClick) {
        mDispatcher.displayNavigationDrawerItem(position, calledByUserClick);
    }

    @Override
    public boolean isSpecialCasePosition(int position) {
        return false;
    }

    @Override
    public void onReportDrawerStatus(boolean isOpened) {
        String test = "";
    }
}
