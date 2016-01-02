package com.example.airnavigate.Views.Base;


import com.example.airnavigate.MVP.IView;

import rx.Subscriber;

/**
 * Subscriber which automatically handles error display and report.
 * Other important methods are empty and available to be overriden. Override them if you need
 */
public class BaseSubscriber<T> extends Subscriber<T> {
    private final IView view;

    public BaseSubscriber(IView view) {
        this.view = view;
    }


    @Override
    public final void onCompleted() {

        onCompletedImpl();
    }

    @Override
    public final void onError(Throwable e) {
        view.displayError(e);
       // Cr.e(this, e);
        onErrorImpl(e);
    }

    @Override
    public final void onStart() {
        super.onStart();
        onStartImpl();
    }

    @Override
    public final void onNext(T t) {
        onNextImpl(t);
    }

    public void onStartImpl() {
        //intentionally left empty. don't change or change the Subscriber related method instead
    }

    public void onCompletedImpl() {
        //intentionally left empty. don't change or change the Subscriber related method instead
    }

    public void onErrorImpl(Throwable e) {
        //intentionally left empty. don't change or change the Subscriber related method instead
    }

    public void onNextImpl(T t) {
        //intentionally left empty. don't change or change the Subscriber related method instead
    }
}
