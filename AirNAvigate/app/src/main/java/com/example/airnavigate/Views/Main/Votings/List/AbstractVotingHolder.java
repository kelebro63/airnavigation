package com.example.airnavigate.Views.Main.Votings.List;

import android.view.View;

import com.example.airnavigate.Model.Voting;
import com.example.airnavigate.Views.Base.Adapter.BaseViewHolder;


abstract class AbstractVotingHolder extends BaseViewHolder {
    public AbstractVotingHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Voting voting);
}

