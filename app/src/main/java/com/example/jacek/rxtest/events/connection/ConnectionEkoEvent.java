package com.example.jacek.rxtest.events.connection;

import com.example.jacek.rxtest.events.model.EkoEvent;
import com.example.jacek.rxtest.events.model.EkoEventId;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class ConnectionEkoEvent extends EkoEvent {

    public ConnectionEkoEvent(EkoEventId id, ConnectionEkoEventData data) {
        super(id, data);
    }

    @Override
    public ConnectionEkoEventData getObject() {
        return (ConnectionEkoEventData) super.getObject();
    }
}
