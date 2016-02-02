package com.example.airnavigate.Views.Main.Votings.List;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.airnavigate.Model.Voting;
import com.example.airnavigate.Modules.MainActivityFragmentModule;
import com.example.airnavigate.MyApplication;
import com.example.airnavigate.R;
import com.example.airnavigate.Utils.BlackThickDividerDecor;
import com.example.airnavigate.Views.Base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by Bistrov Alexey on 17.12.2015.
 */
public class MainListVotingsFragment extends BaseFragment implements IVotingsListView {



    @Bind(R.id.emptyStub)
    TextView emptyStub;

    @Bind(R.id.newsRecyclerView)
    RecyclerView newsRecyclerView;

    @Bind(R.id.newsRefreshLayout)
    SwipeRefreshLayout topicsRefreshLayout;

//    @Bind(R.id.progressLoading)
//    HorizontalProgress progress;

    @Inject
    VotinsListPresenter presenter;



    private LinearLayoutManager layoutManager;
    public static final String TAG = "MainListVotingsFragment";

    /**
     * A title used to filter the news in search
     */
    private String filter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupActivityFragmentComponent();
        initRecyclerView();
//
        presenter.takeView(this);
        presenter.requestVotings(1);

        topicsRefreshLayout.setOnRefreshListener(() -> {

        });
    }

    public void setupActivityFragmentComponent() {
        //Uncomment those lines do measure dependencies creation time
        //Debug.startMethodTracing("SplashTrace");
        MyApplication.get(getActivity())
                .getAppComponent()
                .initMainActivityFragmentComponent(new MainActivityFragmentModule(this))
                .inject(this);
        //Debug.stopMethodTracing();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_list_fragment;
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        newsRecyclerView.setLayoutManager(layoutManager);

        newsRecyclerView.addItemDecoration(new BlackThickDividerDecor());
        newsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (!adapter.isLoading() &&  //adapter is not already loading more news
//                        layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1 //reached the last item
//                        ) {
//                    adapter.displayLoadingFooter();//indicate loading more news by showing footer
//                    newsRecyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);//smooth scroll to footer
//                    //presenter.requestDeputies(filter);//load more news
//                }
            }
        });
    }

    @Override
    public void addVotingsToDisplay(List<Voting> deputies) {

    }

    public void setVotingsToDisplay(List<Voting> deputies) {

    }

    @Override
    public void stopRefreshing() {
        topicsRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setInitialLoading(boolean isLoading) {

    }



    private void animateRecycler(boolean isEmpty) {
        float val = isEmpty ? 0 : 1;
        int duration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        newsRecyclerView.animate().alpha(val).setDuration(duration);
    }



    @Override
    public void displayError(Throwable error) {

    }
}
