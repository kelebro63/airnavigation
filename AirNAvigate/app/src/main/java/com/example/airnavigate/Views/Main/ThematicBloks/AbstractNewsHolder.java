package com.example.airnavigate.Views.Main.ThematicBloks;

import android.view.View;

import com.example.airnavigate.Model.Topic;
import com.example.airnavigate.Views.Base.Adapter.BaseViewHolder;


abstract class AbstractNewsHolder extends BaseViewHolder {
    public AbstractNewsHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Topic topic);
}

