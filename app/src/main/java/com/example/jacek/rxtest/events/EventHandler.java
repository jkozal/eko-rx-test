package com.example.jacek.rxtest.events;

import com.example.jacek.rxtest.handlers.connection.ConnectionState;

import io.reactivex.functions.Consumer;

/**
 * Created by jacek on 9/1/2018 AD.
 */

public abstract class EventHandler<T>  {

    protected EventDelegate<T> delegate;

    public EventHandler(EventDelegate<T> delegate) {
        this.delegate = delegate;
    }

    public EventSubscriber<Consumer<T>> getSubscriber() {
        return delegate;
    }
}
