package com.example.jacek.rxtest;

import android.app.Application;

import com.example.jacek.rxtest.events.EventDelegate;
import com.example.jacek.rxtest.events.EkoEvent;
import com.example.jacek.rxtest.handlers.connection.EkoConnectivityHandler;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jacek on 26/12/2017 AD.
 */

public class App extends Application {

    private EkoConnectivityHandler ekoConnectivityHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        ekoConnectivityHandler =
            new EkoConnectivityHandler(
                new EventDelegate<>(BehaviorSubject.<EkoEvent>create()));
    }

    public EkoConnectivityHandler getEkoConnectivityHandler() {
        return ekoConnectivityHandler;
    }
}
