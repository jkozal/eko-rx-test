package com.example.jacek.rxtest.events;

/**
 * Created by jacek on 29/12/2017 AD.
 */

public interface EventPublisher<T> {
    void sendEvent(T event);
}
