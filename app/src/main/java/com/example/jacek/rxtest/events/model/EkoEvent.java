package com.example.jacek.rxtest.events.model;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public abstract class EkoEvent {

    private Object object;

    public EkoEvent(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
