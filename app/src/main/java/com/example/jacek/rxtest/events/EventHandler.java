package com.example.jacek.rxtest.events;

/**
 * Created by jacek on 3/1/2018 AD.
 */

public abstract class EventHandler {

    protected EventDelegate<EkoEvent> delegate;

    public EventHandler(EventDelegate<EkoEvent> delegate) {
        this.delegate = delegate;
    }

    public EventSubscriber getSubscriber() {
        return delegate;
    }
}
