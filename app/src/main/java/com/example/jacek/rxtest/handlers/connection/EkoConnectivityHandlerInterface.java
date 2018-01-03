package com.example.jacek.rxtest.handlers.connection;

/**
 * Created by jacek on 28/12/2017 AD.
 * Gateway from EkoConnectivity, reacting to network events
 */

public interface EkoConnectivityHandlerInterface {
    void onConnect();
    void onReconnect();
    void onDisconnect();
}
