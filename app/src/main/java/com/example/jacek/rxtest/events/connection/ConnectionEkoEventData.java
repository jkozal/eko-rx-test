package com.example.jacek.rxtest.events.connection;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class ConnectionEkoEventData {

    private ConnectionState state;

    public ConnectionEkoEventData(ConnectionState state) {
        this.state = state;
    }

    public ConnectionState getState() {
        return state;
    }

    public void setState(ConnectionState state) {
        this.state = state;
    }
}
