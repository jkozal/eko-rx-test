package com.example.jacek.rxtest.events;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by jacek on 29/12/2017 AD.
 */

public interface EventSubscriber {
    EventReceiver subscribe(Scheduler scheduler, Consumer consumer);
}
