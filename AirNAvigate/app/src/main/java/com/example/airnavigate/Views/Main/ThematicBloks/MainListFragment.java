package com.example.airnavigate.Views.Main.ThematicBloks;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.airnavigate.Model.News;
import com.example.airnavigate.R;
import com.example.airnavigate.Utils.BlackThickDividerDecor;
import com.example.airnavigate.Views.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Bistrov Alexey on 17.12.2015.
 */
public class MainListFragment extends BaseFragment {



    @Bind(R.id.emptyStub)
    TextView emptyStub;

    @Bind(R.id.newsRecyclerView)
    RecyclerView newsRecyclerView;

    @Bind(R.id.newsRefreshLayout)
    SwipeRefreshLayout newsRefreshLayout;

//    @Bind(R.id.progressLoading)
//    HorizontalProgress progress;

//    @Inject
//    NewsListPresenter presenter;


    private NewsListAdapter adapter;

    private LinearLayoutManager layoutManager;
    public static final String TAG = "MainListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        DaggerHomeActivityFragmentComponent.builder().gokixxAppComponent(getAppComponent())
//                .homeActivityFragmentModule(new HomeActivityFragmentModule((HomeActivity) getActivity(), this))
//                .build()
//                .inject(this);
            initRecyclerView();
//
//        presenter.takeView(this);
//        presenter.requestNews(filter);

//        newsRefreshLayout.setOnRefreshListener(() -> {
//            if (!adapter.isLoading()) {
//                presenter.refreshItems(filter);
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_list_fragment;
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        newsRecyclerView.setLayoutManager(layoutManager);
        adapter = new NewsListAdapter();

     //   adapter.setItemClickListener(item -> presenter.openNextScreen(item, filter));
        newsRecyclerView.setAdapter(adapter);
        setNewsToDisplay(getNews());
        newsRecyclerView.addItemDecoration(new BlackThickDividerDecor());
        newsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (!adapter.isLoading() &&  //adapter is not already loading more news
                        layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1 //reached the last item
                        ) {
                    adapter.displayLoadingFooter();//indicate loading more news by showing footer
                    newsRecyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);//smooth scroll to footer
                    //presenter.requestNews(filter);//load more news
                }
            }
        });
    }

    public void setNewsToDisplay(List<News> news) {
        adapter.setItems(news);
        if (news != null && news.size() > 0) {
            newsRecyclerView.animate().alpha(1).setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        }
        updateContentVisibility();
    }

    private void updateContentVisibility() {
        emptyStub.setVisibility(adapter.isEmpty() ? View.VISIBLE : View.GONE);
        animateRecycler(adapter.isEmpty());
    }

    private void animateRecycler(boolean isEmpty) {
        float val = isEmpty ? 0 : 1;
        int duration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        newsRecyclerView.animate().alpha(val).setDuration(duration);
    }

    private ArrayList<News> getNews() {
        ArrayList<News> newsArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            News news = new News(i);
            news.setTitle("title" + i);
            news.setSubtitle("subTitle" + i);
            newsArrayList.add(news);
        }
        return newsArrayList;
    }
}
