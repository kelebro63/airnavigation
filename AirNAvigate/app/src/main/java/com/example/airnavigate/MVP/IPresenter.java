package com.example.airnavigate.MVP;

/**
 * Common Presenter interface.
 * */
public interface IPresenter<V extends IView> {
    /**
     * Initialize presenter with a view, which will receive updates
     * */
    void takeView(V view);

    /**
     * Destroy presenter - cancel any ongoing operation and detach from view
     * */
    void destroy();
}
