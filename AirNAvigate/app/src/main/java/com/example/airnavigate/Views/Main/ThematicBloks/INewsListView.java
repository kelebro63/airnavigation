package com.example.airnavigate.Views.Main.ThematicBloks;

import com.example.airnavigate.MVP.IView;
import com.example.airnavigate.Model.News;

import java.util.List;



interface INewsListView extends IView {
    void addNewsToDisplay(List<News> news);

    void setNewsToDisplay(List<News> news);

    void stopRefreshing();

    void setInitialLoading(boolean isLoading);
}
