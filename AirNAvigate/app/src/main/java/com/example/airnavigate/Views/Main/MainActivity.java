package com.example.airnavigate.Views.Main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.example.airnavigate.Modules.MainActivityModule;
import com.example.airnavigate.MyApplication;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseToolbarActivity;
import com.example.airnavigate.Views.Drawer.NavDrawerFragment;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseToolbarActivity implements NavDrawerFragment.NavigationDrawerCallbacks
{

    ToolbarControls toolbarControls;
    NavDrawerFragment drawer;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Inject
    FragmentDispatcher mDispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
        toolbarControls = new ToolbarControls(this, drawerLayout, drawer, getSupportFragmentManager(), toolbar);
        toolbarControls.setup();
        mDispatcher.onCreate();
        drawer = (NavDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer);
        drawer.setUp(
                R.id.drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        mDispatcher.displayNavigationDrawerItem(FragmentDispatcher.NavDrawerItems.THEMATIC_BLOCKS, true);
        mDispatcher.addOnBackStackChangedListener(toolbarControls);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toolbarControls.restoreState(savedInstanceState);
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        toolbarControls.saveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        mDispatcher.removeOnBackStackChangedListener(toolbarControls);
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toolbarControls.onConfigurationChanged(newConfig);
    }

//    @Override
//    public void setCurrentTitle(String currentTitle) {
//        toolbarControls.setTitle(currentTitle);
//    }
}
