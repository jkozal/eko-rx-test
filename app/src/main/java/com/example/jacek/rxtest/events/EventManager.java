package com.example.jacek.rxtest.events;

import com.example.jacek.rxtest.events.connection.ConnectionEkoEvent;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jacek on 29/12/2017 AD.
 */

public class EventManager {

    private EventDelegate<ConnectionEkoEvent> connectionDelegate;
    // ..

    public EventManager() {
        connectionDelegate = new EventDelegate<>(BehaviorSubject.<ConnectionEkoEvent>create());
    }

    public EventSubscriber getConnectionSubscriber() {
        return connectionDelegate;
    }

    public EventPublisher<ConnectionEkoEvent> getConnectionPublisher() {
        return connectionDelegate;
    }
}
