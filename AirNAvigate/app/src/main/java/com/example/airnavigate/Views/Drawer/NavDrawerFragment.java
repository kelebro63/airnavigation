package com.example.airnavigate.Views.Drawer;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseFragment;
import com.example.airnavigate.Views.Main.FragmentDispatcher;

import java.util.ArrayList;

/**
 * Navigation Drawer fragment
 */
public class NavDrawerFragment extends BaseFragment implements DrawerAdapter.DrawerAdapterCallbacks{

    /**
     * Remember the position of the selected item.
     */
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";


    private NavigationDrawerCallbacks mCallbacks;

    /**
     * Helper component that ties the action bar to the navigation drawer.
     */
    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private DrawerAdapter mDrawerAdapter;
    private RecyclerView mDrawerListView;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = FragmentDispatcher.NavDrawerItems.RECIPES;
    private boolean mFromSavedInstanceState;
   // private boolean mUserLearnedDrawer;


    public NavDrawerFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read in the flag indicating whether or not the user has demonstrated awareness of the
        // drawer. See PREF_USER_LEARNED_DRAWER for details.
        //mUserLearnedDrawer = getPreferences().hasUserLearnedDrawer();

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        // Select either the default item (1) or the last selected item.
        selectItem(mCurrentSelectedPosition, false);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.navdrawer_fragment;
    }

//    @Override
//    protected void updateLocaleSpecificUi() {
//        onCreateAdapter();
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mDrawerListView = (RecyclerView) view.findViewById(R.id.drawerRecyclerView);
        mDrawerListView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        onCreateAdapter();
        return view;
    }

    private void onCreateAdapter() {
        mDrawerAdapter = createKitchenDrawerAdapter();
        mDrawerListView.setAdapter(mDrawerAdapter);
        //mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
        mDrawerAdapter.setSelected(mCurrentSelectedPosition);
    }

    private DrawerAdapter createKitchenDrawerAdapter() {
        ArrayList<DrawerItem> items = new ArrayList<>();
        //top item
        items.add(new DrawerItem(
                DrawerItem.Type.TOP,
                new DrawerItem.TwoStateIcon(0, 0),
                ""));
        //main items
        items.add(new DrawerItem(
                DrawerItem.Type.MAIN_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_recipes, R.drawable.ic_nd_recipes_selected),
                getString(R.string.MENU_RECIPES)));
        items.add(new DrawerItem(
                DrawerItem.Type.MAIN_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_howto, R.drawable.ic_nd_howto_selected),
                getString(R.string.MENU_COOKING_TIPS)));
        items.add(new DrawerItem(
                DrawerItem.Type.MAIN_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_myfavorites, R.drawable.ic_nd_myfavorites_selected),
                getString(R.string.MENU_FAVORITES)));
        items.add(new DrawerItem(
                DrawerItem.Type.MAIN_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_shopping, R.drawable.ic_nd_shopping_selected),
                getString(R.string.MENU_SHOPPINGLIST)));
        //header
        items.add(new DrawerItem(
                DrawerItem.Type.HEADER,
                new DrawerItem.TwoStateIcon(0, 0),
                getString(R.string.MORE)));
        //more
        items.add(new DrawerItem(
                DrawerItem.Type.MORE_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_essentials, R.drawable.ic_nd_essentials_selected),
                getString(R.string.MENU_BASICS)));
        items.add(new DrawerItem(
                DrawerItem.Type.MORE_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_aboutus, R.drawable.ic_nd_aboutus_selected),
                getString(R.string.MENU_ABOUT)));
        items.add(new DrawerItem(
                DrawerItem.Type.MORE_ITEM,
                new DrawerItem.TwoStateIcon(R.drawable.ic_nd_settings, R.drawable.ic_nd_settings_selected),
                getString(R.string.MENU_SETTINGS)));

        return new DrawerAdapter(getActivity().getApplicationContext(), items, this);

    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }
//                if (!mUserLearnedDrawer) {
//                    // The user manually opened the drawer; store this flag to prevent auto-showing
//                    // the navigation drawer automatically in the future.
//                    mUserLearnedDrawer = true;
//                    getPreferences().setUserLearnedDrawer(mUserLearnedDrawer);
//                }

                mCallbacks.onReportDrawerStatus(false); // report drawer closed
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

//                if (!mUserLearnedDrawer) {
//                    // The user manually opened the drawer; store this flag to prevent auto-showing
//                    // the navigation drawer automatically in the future.
//                    mUserLearnedDrawer = true;
//                    getPreferences().setUserLearnedDrawer(mUserLearnedDrawer);
//                }

                mCallbacks.onReportDrawerStatus(true); // report drawer opened
            }
        };

        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public boolean checkForLearnedAboutDrawer(){
        // If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
        // per the navigation drawer design guidelines.
//        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
//            mDrawerLayout.openDrawer(mFragmentContainerView);
//            return false;
//        }
        return true;
    }

    public void selectItem(int position, boolean calledByUserClick) {
        if (
                mDrawerListView != null
                        && mDrawerListView.getAdapter() != null
                        && !mDrawerAdapter.isEnabled(position)
                ) {
            //position is not enabled, thus should not be handled
            return;
        }

        if (mDrawerListView != null && !mCallbacks.isSpecialCasePosition(position)) {
            //mDrawerListView.setItemChecked(position, true);
            mDrawerAdapter.setSelected(position);
            mCurrentSelectedPosition = position;
        }


        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }

        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position,calledByUserClick);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    public int getCurrentSelectedPosition(){
        return mCurrentSelectedPosition;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    @Override
    public void onPositionSelected(int position) {
        selectItem(position,true);
    }

    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position, boolean calledByUserClick);

        boolean isSpecialCasePosition(int position);

        void onReportDrawerStatus(boolean isOpened);
    }

    public void setNavDrawerIndicator(boolean toSet_){
        mDrawerToggle.setDrawerIndicatorEnabled(toSet_);
    }
}