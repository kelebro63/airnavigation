package com.example.airnavigate.Views.Main.Deputies;

import com.example.airnavigate.MVP.IView;
import com.example.airnavigate.Model.Deputy;

import java.util.List;


interface IDeputiesListView extends IView {
    void addDeputiesToDisplay(List<Deputy> news);

    void setDeputiesToDisplay(List<Deputy> news);

    void stopRefreshing();

    void setInitialLoading(boolean isLoading);
}
