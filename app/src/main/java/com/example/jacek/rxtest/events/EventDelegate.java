package com.example.jacek.rxtest.events;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jacek on 9/1/2018 AD.
 */

public class EventDelegate<T> implements EventPublisher<T>, EventSubscriber<Consumer<T>> {

    private BehaviorSubject<T> processor;

    public EventDelegate(BehaviorSubject<T> processor) {
        this.processor = processor;
    }

    @Override
    public void sendEvent(T event) {
        processor.onNext(event);
    }

    public EventReceiver subscribe(Scheduler scheduler, Consumer<T> consumer) {
        Disposable disposable = processor.observeOn(scheduler).subscribe(consumer);
        return new EventReceiver(disposable);
    }
}
