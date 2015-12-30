package com.example.airnavigate.Views.Main.ThematicBloks;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseFragment;

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
//        initRecyclerView();
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
       // newsRecyclerView.addItemDecoration(new BlackThickDividerDecor());
//        newsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (!adapter.isLoading() &&  //adapter is not already loading more news
//                        layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1 //reached the last item
//                        ) {
//                    adapter.displayLoadingFooter();//indicate loading more news by showing footer
//                    newsRecyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);//smooth scroll to footer
//                    presenter.requestNews(filter);//load more news
//                }
//            }
//        });
    }
}
