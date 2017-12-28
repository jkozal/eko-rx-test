package com.example.jacek.rxtest.events;

import com.example.jacek.rxtest.events.model.EkoEvent;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EventDelegate {

    private BehaviorSubject<EkoEvent> processor;

    public EventDelegate(BehaviorSubject<EkoEvent> processor) {
        this.processor = processor;
    }

    public void sendEvent(EkoEvent event) {
        processor.onNext(event);
    }

    public Disposable subscribe(Scheduler scheduler, Consumer consumer) {
        return processor.observeOn(scheduler).subscribe(consumer);
    }
}
