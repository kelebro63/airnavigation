package com.example.airnavigate.Views.Drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Navigation Drawer fragment
 */
public class NavDrawerFragment extends BaseFragment {


//    @Bind(R.id.drawerRecyclerView)
//    RecyclerView recyclerView;
//
//    @Inject
//    DrawerAdapter adapter;


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
        createDrawer();
        //   adapter.restoreState(savedInstanceState);
        return view;
    }

    private void createDrawer() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(lm);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public void openItem(@NavigationConstants.MenuItemId int menuIdToOpen) {
       // adapter.openItem(menuIdToOpen);
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
}
