package com.example.airnavigate.Views.Main.ThematicBloks;

import com.example.airnavigate.MVP.IView;
import com.example.airnavigate.Model.Topic;

import java.util.List;



interface ITopicsListView extends IView {
    void addTopicsToDisplay(List<Topic> news);

    void setTopicsToDisplay(List<Topic> news);

    void stopRefreshing();

    void setInitialLoading(boolean isLoading);
}
