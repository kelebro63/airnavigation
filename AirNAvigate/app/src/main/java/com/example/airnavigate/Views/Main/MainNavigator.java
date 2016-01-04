package com.example.airnavigate.Views.Main;

import android.support.annotation.Nullable;

import com.example.airnavigate.Views.Base.BaseActivity;
import com.example.airnavigate.Views.Main.Deputies.Article.DeputyArticleFragment;

import javax.inject.Inject;

/**
 * Created by Kelebro63 on 04.01.2016.
 */
public class MainNavigator {

  //  private final DetailsNavigator detailNavigator;
    private final BaseActivity activity;

    @Inject FragmentDispatcher fragmentDispatcher;

    @Inject
        public MainNavigator(BaseActivity activity) {
        this.activity = activity;
    }

    public void openArticle(long deputiesId, @Nullable String hashtag) {
        DeputyArticleFragment fragment = DeputyArticleFragment.newInstance(deputiesId, hashtag);
        fragmentDispatcher.navigateToDetailsLevel(fragment, fragment.provideTag());
    }
}
