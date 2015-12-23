package com.example.airnavigate.Views.Drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Navigation Drawer fragment
 */
public class NavDrawerFragment extends BaseFragment implements DrawerAdapter.DrawerAdapterCallbacks{


//    @Bind(R.id.drawerRecyclerView)
//    RecyclerView recyclerView;
//
//    @Inject
//    DrawerAdapter adapter;

    //kitchenStories
    private DrawerAdapter mDrawerAdapter;
    private RecyclerView recyclerView;
    private int mCurrentSelectedPosition = NavigationConstants.DRAWER_NEWS;
    private NavigationDrawerCallbacks mCallbacks;
    private DrawerLayout mDrawerLayout;


    @Override
    protected int getLayoutId() {
        return R.layout.navdrawer_fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Icepick.restoreInstanceState(this, savedInstanceState);
        initializeInjector();
    }

    private void initializeInjector() {
//        DrawerComponent component = DaggerDrawerComponent.builder()
//                .gokixxAppComponent(getAppComponent())
//                .drawerModule(new DrawerModule((HomeActivity) getActivity()))
//                .build();
//        component.inject(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //   adapter.saveState(outState);
    }

    @Override
    public void onStop() {
        //    adapter.onStop();
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        createDrawer(view);
        //   adapter.restoreState(savedInstanceState);
        return view;
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

    private void createDrawer(View view) {
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.drawerRecyclerView);
        recyclerView.setLayoutManager(lm);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public void openItem(@NavigationConstants.MenuItemId int menuIdToOpen) {
        if (mDrawerAdapter == null) {
            onCreateAdapter();
        }
        mDrawerAdapter.setSelected(menuIdToOpen);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public String provideTag() {
        return "NavDrawerFragment";
    }

    //***************************kitchenStories*******************
    private void onCreateAdapter() {
        mDrawerAdapter = createKitchenDrawerAdapter();
        recyclerView.setAdapter(mDrawerAdapter);
        //mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
        // mDrawerAdapter.setSelected(mCurrentSelectedPosition);
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

    @Override
    public void onPositionSelected(int position) {
        selectItem(position,true);
    }

    public void selectItem(int position, boolean calledByUserClick) {
        if (
                recyclerView != null
                        && recyclerView.getAdapter() != null
                        && !mDrawerAdapter.isEnabled(position)
                ) {
            //position is not enabled, thus should not be handled
            return;
        }

        if (mCallbacks != null) {
            if (recyclerView != null && !mCallbacks.isSpecialCasePosition(position)) {
                //mDrawerListView.setItemChecked(position, true);
               // mDrawerAdapter.setSelected(position);
                mCurrentSelectedPosition = position;
            }
        }

//        if (mDrawerLayout != null) {
//            mDrawerLayout.closeDrawer(mFragmentContainerView);
//        }

        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position,calledByUserClick);
        }

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
}
