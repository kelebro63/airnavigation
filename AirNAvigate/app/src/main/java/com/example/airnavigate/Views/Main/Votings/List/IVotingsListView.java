package com.example.airnavigate.Views.Main.Votings.List;

import com.example.airnavigate.MVP.IView;
import com.example.airnavigate.Model.Voting;

import java.util.List;


interface IVotingsListView extends IView {
    void addVotingsToDisplay(List<Voting> news);

    void setVotingsToDisplay(List<Voting> news);

    void stopRefreshing();

    void setInitialLoading(boolean isLoading);
}
