package com.example.jacek.rxtest;

import android.app.Application;

import com.example.jacek.rxtest.handler.EkoConnectivityHandler;
import com.example.jacek.rxtest.events.EventDelegate;
import com.example.jacek.rxtest.events.model.EkoEvent;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jacek on 26/12/2017 AD.
 */

public class App extends Application {

    private EventDelegate delegate;
    private EkoConnectivityHandler ekoConnectivityObject;

    @Override
    public void onCreate() {
        super.onCreate();
        delegate = new EventDelegate(BehaviorSubject.<EkoEvent>create());
        ekoConnectivityObject = new EkoConnectivityHandler(delegate);
    }

    public EventDelegate getDelegate() {
        return delegate;
    }

    // just for demo, will not be present
    @Deprecated
    public EkoConnectivityHandler getEkoConnectivityObject() {
        return ekoConnectivityObject;
    }
}
