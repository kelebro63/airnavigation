package com.example.airnavigate.Views.Main.ThematicBloks;

import android.view.View;

import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.Views.Base.Adapter.BaseViewHolder;


abstract class AbstractTopicsHolder extends BaseViewHolder {
    public AbstractTopicsHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Topic topic);
}

