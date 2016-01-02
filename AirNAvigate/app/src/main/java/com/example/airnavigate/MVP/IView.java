package com.example.airnavigate.MVP;


/**
 * A marker interface for View in MVP
 */
public interface IView {

    /**
     * Display an error in any possible way: dialog, validation message, anything
     */
    void displayError(Throwable error);
}
