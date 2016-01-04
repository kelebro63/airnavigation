package com.example.airnavigate.Views.Main.Deputies.List;

import android.view.View;

import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Views.Base.Adapter.BaseViewHolder;


abstract class AbstractDeputiesHolder extends BaseViewHolder {
    public AbstractDeputiesHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Deputy deputy);
}

