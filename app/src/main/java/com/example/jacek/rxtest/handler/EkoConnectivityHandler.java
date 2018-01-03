package com.example.jacek.rxtest.handler;

import com.example.jacek.rxtest.events.EventPublisher;
import com.example.jacek.rxtest.events.connection.ConnectionState;
import com.example.jacek.rxtest.events.EventDelegate;
import com.example.jacek.rxtest.events.connection.ConnectionEkoEvent;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EkoConnectivityHandler implements EkoConnectivityHandlerInterface {

    private EventPublisher publisher;

    public EkoConnectivityHandler(EventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void onConnect() {
        publisher.sendEvent(
            new ConnectionEkoEvent(ConnectionState.CONNECTED));
    }

    @Override
    public void onReconnect() {
        publisher.sendEvent(
            new ConnectionEkoEvent(ConnectionState.RECONNECTED));
    }

    @Override
    public void onDisconnect() {
        publisher.sendEvent(
            new ConnectionEkoEvent(ConnectionState.DISCONNECTED));
    }
}
