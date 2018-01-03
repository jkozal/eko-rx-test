package com.example.jacek.rxtest.handlers.connection;

import com.example.jacek.rxtest.events.EventHandler;
import com.example.jacek.rxtest.events.EventDelegate;
import com.example.jacek.rxtest.events.EkoEvent;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EkoConnectivityHandler extends EventHandler implements EkoConnectivityHandlerInterface {

    public EkoConnectivityHandler(EventDelegate<EkoEvent> delegate) {
        super(delegate);
    }

    @Override
    public void onConnect() {
        delegate.sendEvent(
            new EkoEvent<>(ConnectionState.CONNECTED));
    }

    @Override
    public void onReconnect() {
        delegate.sendEvent(
            new EkoEvent<>(ConnectionState.RECONNECTED));
    }

    @Override
    public void onDisconnect() {
        delegate.sendEvent(
            new EkoEvent<>(ConnectionState.DISCONNECTED));
    }
}
