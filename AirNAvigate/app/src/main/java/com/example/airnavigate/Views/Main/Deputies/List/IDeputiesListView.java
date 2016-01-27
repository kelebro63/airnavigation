package com.example.airnavigate.Views.Main.Deputies.List;

import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.MVP.IView;

import java.util.List;


interface IDeputiesListView extends IView {
    void addDeputiesToDisplay(List<Deputy> news);

    void setDeputiesToDisplay(List<Deputy> news);

    void stopRefreshing();

    void setInitialLoading(boolean isLoading);
}
