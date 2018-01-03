package com.example.jacek.rxtest.events;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EkoEvent<T> {

    private T data;

    public EkoEvent(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
