package com.example.jacek.rxtest;

import android.app.Application;

import com.example.jacek.rxtest.events.EventManager;
import com.example.jacek.rxtest.handler.EkoConnectivityHandler;

/**
 * Created by jacek on 26/12/2017 AD.
 */

public class App extends Application {

    private EkoConnectivityHandler ekoConnectivityObject;
    private EventManager eventManager;

    @Override
    public void onCreate() {
        super.onCreate();
        eventManager = new EventManager();
        ekoConnectivityObject = new EkoConnectivityHandler(eventManager.getConnectionPublisher());
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    // just for demo, will not be present
    @Deprecated
    public EkoConnectivityHandler getEkoConnectivityObject() {
        return ekoConnectivityObject;
    }
}
