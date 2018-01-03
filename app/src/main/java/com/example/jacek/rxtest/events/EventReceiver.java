package com.example.jacek.rxtest.events;

import io.reactivex.disposables.Disposable;

/**
 * Created by jacek on 3/1/2018 AD.
 */

public class EventReceiver {

    private Disposable disposable;

    public EventReceiver(Disposable disposable) {
        this.disposable = disposable;
    }

    public void stop() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
