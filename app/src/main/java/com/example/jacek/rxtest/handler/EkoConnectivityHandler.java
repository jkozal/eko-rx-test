package com.example.jacek.rxtest.handler;

import com.example.jacek.rxtest.events.connection.ConnectionState;
import com.example.jacek.rxtest.events.model.EkoEventId;
import com.example.jacek.rxtest.events.EventDelegate;
import com.example.jacek.rxtest.events.connection.ConnectionEkoEvent;
import com.example.jacek.rxtest.events.connection.ConnectionEkoEventData;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EkoConnectivityHandler implements EkoConnectivityHandlerInterface {

    private EventDelegate delegate;

    public EkoConnectivityHandler(EventDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void onConnect() {
        delegate.sendEvent(
            new ConnectionEkoEvent(
                EkoEventId.ConnectionState, new ConnectionEkoEventData(ConnectionState.CONNECTED)));
    }

    @Override
    public void onReconnect() {
        delegate.sendEvent(
            new ConnectionEkoEvent(
                EkoEventId.ConnectionState, new ConnectionEkoEventData(ConnectionState.RECONNECTED)));
    }

    @Override
    public void onDisconnect() {
        delegate.sendEvent(
            new ConnectionEkoEvent(
                EkoEventId.ConnectionState, new ConnectionEkoEventData(ConnectionState.DISCONNECTED)));
    }
}
