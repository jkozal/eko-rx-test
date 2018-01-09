package com.example.jacek.rxtest.handlers.connection;

import com.example.jacek.rxtest.events.EventDelegate;
import com.example.jacek.rxtest.events.EkoEvent;
import com.example.jacek.rxtest.events.EventHandler;
import com.example.jacek.rxtest.events.EventSubscriber;

import io.reactivex.functions.Consumer;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EkoConnectivityHandler extends EventHandler<ConnectionState> implements EkoConnectivityHandlerInterface {

    public EkoConnectivityHandler(EventDelegate<ConnectionState> delegate) {
        super(delegate);
    }

    @Override
    public void onConnect() {
        delegate.sendEvent(ConnectionState.CONNECTED);
    }

    @Override
    public void onReconnect() {
        delegate.sendEvent(ConnectionState.RECONNECTED);
    }

    @Override
    public void onDisconnect() {
        delegate.sendEvent(ConnectionState.DISCONNECTED);
    }
}
