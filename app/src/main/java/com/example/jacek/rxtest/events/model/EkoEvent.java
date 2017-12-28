package com.example.jacek.rxtest.events.model;

import com.example.jacek.rxtest.events.model.EkoEventId;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public abstract class EkoEvent {

    private EkoEventId id;
    private Object object;

    public EkoEvent(EkoEventId id, Object object) {
        this.id = id;
        this.object = object;
    }

    public EkoEventId getId() {
        return id;
    }

    public void setId(EkoEventId id) {
        this.id = id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
