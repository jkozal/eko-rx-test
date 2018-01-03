package com.example.jacek.rxtest.events;

import com.example.jacek.rxtest.events.model.EkoEvent;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jacek on 28/12/2017 AD.
 */

public class EventDelegate<T> implements EventPublisher<T>, EventSubscriber {

    private BehaviorSubject<T> processor;

    public EventDelegate(BehaviorSubject<T> processor) {
        this.processor = processor;
    }

    public void sendEvent(T event) {
        processor.onNext(event);
    }

    public EventReceiver subscribe(Scheduler scheduler, Consumer consumer) {
        Disposable disposable = processor.observeOn(scheduler).subscribe(consumer);
        return new EventReceiver(disposable);
    }
}
