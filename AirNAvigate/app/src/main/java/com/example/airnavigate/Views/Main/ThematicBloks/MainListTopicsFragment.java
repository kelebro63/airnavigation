package com.example.airnavigate.Views.Main.ThematicBloks;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.airnavigate.Dao.Topic;
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
public class MainListTopicsFragment extends BaseFragment implements ITopicsListView {



    @Bind(R.id.emptyStub)
    TextView emptyStub;

    @Bind(R.id.topicsRecyclerView)
    RecyclerView topicsRecyclerView;

    @Bind(R.id.topicsRefreshLayout)
    SwipeRefreshLayout topicsRefreshLayout;

//    @Bind(R.id.progressLoading)
//    HorizontalProgress progress;

    @Inject
    TopicsListPresenter presenter;


    private TopicsListAdapter adapter;

    private LinearLayoutManager layoutManager;
    public static final String TAG = "MainListTopicsFragment";

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
        presenter.requestTopics(filter);

        topicsRefreshLayout.setOnRefreshListener(() -> {
            if (!adapter.isLoading()) {
                presenter.refreshItems(filter);
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
        return R.layout.main_list_topics_fragment;
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        topicsRecyclerView.setLayoutManager(layoutManager);
        adapter = new TopicsListAdapter();

        adapter.setItemClickListener(item -> presenter.openNextScreen(item, filter));
        topicsRecyclerView.setAdapter(adapter);
        topicsRecyclerView.addItemDecoration(new BlackThickDividerDecor());
        topicsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (!adapter.isLoading() &&  //adapter is not already loading more news
//                        layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1 //reached the last item
//                        ) {
//                    adapter.displayLoadingFooter();//indicate loading more news by showing footer
//                    topicsRecyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);//smooth scroll to footer
//                    //presenter.requestDeputies(filter);//load more news
//                }
            }
        });
    }

    @Override
    public void addTopicsToDisplay(List<Topic> news) {
        adapter.addAll(news);
        updateContentVisibility();
    }

    public void setTopicsToDisplay(List<Topic> news) {
        adapter.setItems(news);
        if (news != null && news.size() > 0) {
            topicsRecyclerView.animate().alpha(1).setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        }
        updateContentVisibility();
    }

    @Override
    public void stopRefreshing() {
        topicsRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setInitialLoading(boolean isLoading) {

    }

    private void updateContentVisibility() {
        emptyStub.setVisibility(adapter.isEmpty() ? View.VISIBLE : View.GONE);
        animateRecycler(adapter.isEmpty());
    }

    private void animateRecycler(boolean isEmpty) {
        float val = isEmpty ? 0 : 1;
        int duration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        topicsRecyclerView.animate().alpha(val).setDuration(duration);
    }



    @Override
    public void displayError(Throwable error) {

    }
}
