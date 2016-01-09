
package com.example.airnavigate.Views.Main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Drawer.NavDrawerFragment;

/**
 * Encapsulates toolbar appearance and behaviour
 * */
public class ToolbarControls implements FragmentManager.OnBackStackChangedListener {

    final MainActivity activity;
    final DrawerLayout drawerLayout;
    final NavDrawerFragment drawer;
    final FragmentManager fm;
    final Toolbar toolbar;
    final ActionBarDrawerToggle drawerToggle;
    final TextView toolbarTitle;

    Mode mode = Mode.MENU;//default


    ToolbarControls(MainActivity activity, DrawerLayout drawerLayout, NavDrawerFragment drawer, FragmentManager fm, Toolbar toolbar) {
        this.drawerLayout = drawerLayout;
        this.drawer = drawer;
        this.fm = fm;
        this.activity = activity;
        this.toolbar = toolbar;
        drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, R.string.drawer_action_open, R.string.drawer_action_close);
        drawerLayout.setDrawerListener(drawerToggle);
        toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
    }

    public void setTitle(String title) {
        toolbarTitle.setText(title);
    }


    @Override
    public void onBackStackChanged() {
        if (fm.getBackStackEntryCount() > 0) {
            backNavigation();
        } else {
            burgerNavigation();
        }
        updateTitle();
    }

    private void updateTitle() {
//        Fragment fragmentById = fm.findFragmentById(R.id.content_frame);
//        if (fragmentById instanceof TitleAwareFragment) {
//            setTitle(((TitleAwareFragment) fragmentById).getToolbarTitle());
//        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void setup() {
        //activity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = activity.getSupportActionBar();
        if (supportActionBar == null) {
            throw new IllegalStateException("Support action bar not set!");
        }
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(false);
    }

    void restoreState(Bundle savedState) {
        drawerToggle.syncState();
        if (savedState != null) {
            mode = (Mode) savedState.getSerializable("mode");
        }

        //change operation mode according to icon
        switch (mode) {
            case MENU:
                burgerNavigation();
                break;
            case BACK:
                backNavigation();
                break;
        }
    }

    void saveInstanceState(Bundle to) {
        //we only need to save the icon, I guess
        to.putSerializable("mode", mode);
    }


    private void burgerNavigation() {
        mode = Mode.MENU;
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        toolbar.setNavigationOnClickListener((view) -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void backNavigation() {
        mode = Mode.BACK;
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener((v -> activity.onBackPressed()));
    }

    enum Mode {
        MENU, BACK
    }


}