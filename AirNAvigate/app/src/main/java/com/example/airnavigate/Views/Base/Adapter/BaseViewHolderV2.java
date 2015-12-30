package com.example.airnavigate.Views.Base.Adapter;

import android.view.View;

import butterknife.ButterKnife;


/**
 * View holder with view injection and item binding, out of box
 * */
public abstract class BaseViewHolderV2<M> extends BaseViewHolder {
    public BaseViewHolderV2(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(M item);
}
