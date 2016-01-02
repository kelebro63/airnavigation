package com.example.airnavigate.MVP;

import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/**
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 * <p>
 * By convention each UseCase implementation will return the result using a {@link rx.Subscriber}
 * that will performLogin its job in a background thread and will post the result in the UI thread.
 */
public abstract class Interactor {

    private final Scheduler backgroundThreadScheduler;
    private final Scheduler mainThreadScheduler;

    //this might presumable be not completely concurrent-safe. we might want to _re-create_ composite subscription,
    //because it's drawn useless after unsubscribe
    private List<Subscription> subscriptions = new ArrayList<>();

    private Map<String, Subscription> taggedSubscriptions = new HashMap<>();

    protected Interactor(@MainThread Scheduler mainThreadScheduler,
                         @BackgroundThread Scheduler backgroundThreadScheduler) {
        this.mainThreadScheduler = mainThreadScheduler;
        this.backgroundThreadScheduler = backgroundThreadScheduler;
    }

    /**
     * Must be called by subclasses to actually do the job
     */
    protected void subscribe(Observable observable, Subscriber subscriber) {
        subscriptions.add(observable
                .subscribeOn(backgroundThreadScheduler)
                .observeOn(mainThreadScheduler)
                .subscribe(subscriber));
    }

    /**
     * Must be called by subclasses to actually do the job.
     * <br> This implementation always removes previous ongoing operation, identified by tag, before executing new one
     */
    protected void subscribe(String tag, Observable observable, Subscriber subscriber) {
        Subscription subscription = taggedSubscriptions.get(tag);
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }


        taggedSubscriptions.put(
                tag,
                observable
                        .subscribeOn(backgroundThreadScheduler)
                        .observeOn(mainThreadScheduler)
                        .subscribe(subscriber));
    }


    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscriptions.isEmpty()) {
            for (Subscription s : subscriptions) {
                if (s != null && !s.isUnsubscribed()) {
                    s.unsubscribe();
                }
            }
            subscriptions.clear();
            //Cr.log_e(this, "Unsubscribed from all subscriptions");
        }

        if (!taggedSubscriptions.isEmpty()) {
            Set<String> keys = taggedSubscriptions.keySet();
            for (String tag : keys) {
                Subscription subscription = taggedSubscriptions.get(tag);
                if (subscription != null && !subscription.isUnsubscribed()) {
                    subscription.unsubscribe();
                }
            }
            taggedSubscriptions.clear();
        }
    }

}
