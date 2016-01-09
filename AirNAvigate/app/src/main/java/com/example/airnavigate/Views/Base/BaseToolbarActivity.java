package com.example.airnavigate.Views.Base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.airnavigate.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public abstract class BaseToolbarActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    protected Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    protected abstract int getLayoutId();
}
