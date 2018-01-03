package com.example.jacek.rxtest.events.connection;

import com.example.jacek.rxtest.events.model.EkoEvent;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class ConnectionEkoEvent extends EkoEvent {

    public ConnectionEkoEvent(ConnectionState data) {
        super(data);
    }

    @Override
    public ConnectionState getObject() {
        return (ConnectionState) super.getObject();
    }
}
