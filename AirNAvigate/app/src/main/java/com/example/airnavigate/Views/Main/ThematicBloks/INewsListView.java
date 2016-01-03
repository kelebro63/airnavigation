package com.example.airnavigate.Views.Main.ThematicBloks;

import com.example.airnavigate.MVP.IView;
import com.example.airnavigate.Model.Topic;

import java.util.List;



interface INewsListView extends IView {
    void addNewsToDisplay(List<Topic> news);

    void setNewsToDisplay(List<Topic> news);

    void stopRefreshing();

    void setInitialLoading(boolean isLoading);
}
