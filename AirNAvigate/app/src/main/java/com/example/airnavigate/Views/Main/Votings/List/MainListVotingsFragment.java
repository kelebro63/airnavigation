package com.example.airnavigate.Views.Main.Votings.List;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.airnavigate.Dao.Voting;

import com.example.airnavigate.Modules.MainActivityFragmentModule;
import com.example.airnavigate.MyApplication;
import com.example.airnavigate.R;
import com.example.airnavigate.Utils.BlackThickDividerDecor;
import com.example.airnavigate.Views.Base.BaseFragment;
import com.example.airnavigate.Views.Widgets.HorizontalProgress;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by Bistrov Alexey on 17.12.2015.
 */
public class MainListVotingsFragment extends BaseFragment implements IVotingsListView {



    @Bind(R.id.emptyStub)
    TextView emptyStub;

    @Bind(R.id.votingsRecyclerView)
    RecyclerView votingsRecyclerView;

    @Bind(R.id.votingsRefreshLayout)
    SwipeRefreshLayout votingsRefreshLayout;

    @Bind(R.id.progressLoading)
    HorizontalProgress progress;

    @Inject
    VotinsListPresenter presenter;


    private VotingsListAdapter adapter;
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
        presenter.requestVotings();

        votingsRefreshLayout.setOnRefreshListener(() -> {
            if (!adapter.isLoading()) {
                presenter.refreshItems();
            }
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
        return R.layout.main_list_votings_fragment;
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        votingsRecyclerView.setLayoutManager(layoutManager);
        adapter = new VotingsListAdapter();
        votingsRecyclerView.addItemDecoration(new BlackThickDividerDecor());
        votingsRecyclerView.setAdapter(adapter);
        votingsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (!adapter.isLoading() &&  //adapter is not already loading more news
                        layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1 //reached the last item
                        ) {
                    adapter.displayLoadingFooter();//indicate loading more news by showing footer
                    votingsRecyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);//smooth scroll to footer
                    presenter.requestVotings();//load more news
                }
            }
        });
    }

    @Override
    public void addVotingsToDisplay(List<Voting> votings) {
        adapter.addAll(votings);
        updateContentVisibility();
    }

    private void updateContentVisibility() {
        emptyStub.setVisibility(adapter.isEmpty() ? View.VISIBLE : View.GONE);
        animateRecycler(adapter.isEmpty());
    }

    public void setVotingsToDisplay(List<Voting> votings) {
        adapter.setItems(votings);
        if (votings != null && votings.size() > 0) {
            votingsRecyclerView.animate().alpha(1).setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        }
        updateContentVisibility();
    }

    @Override
    public void stopRefreshing() {
        votingsRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setInitialLoading(boolean isLoading) {

    }



    private void animateRecycler(boolean isEmpty) {
        float val = isEmpty ? 0 : 1;
        int duration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        votingsRecyclerView.animate().alpha(val).setDuration(duration);
    }



    @Override
    public void displayError(Throwable error) {

    }
}
