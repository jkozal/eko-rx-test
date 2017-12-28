package com.example.jacek.rxtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jacek.rxtest.events.connection.ConnectionEkoEvent;
import com.example.jacek.rxtest.events.model.EkoEvent;
import com.example.jacek.rxtest.events.model.EkoEventId;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private Disposable eventsDisposable;
    private App app;

    private TextView txt;
    private Button connect;
    private Button disconnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = (App) getApplication();

        //just for demo
        initFields();
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventsDisposable = app.getDelegate().subscribe(AndroidSchedulers.mainThread(), new MainConsumer());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (eventsDisposable != null && !eventsDisposable.isDisposed()) {
            eventsDisposable.dispose();
        }
    }

    private void initFields() {
        txt = (TextView) findViewById(R.id.txt);
        connect = (Button) findViewById(R.id.connect);
        disconnect = (Button) findViewById(R.id.disconnect);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.getEkoConnectivityObject().onConnect();
            }
        });

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.getEkoConnectivityObject().onDisconnect();
            }
        });
    }

    private class MainConsumer implements Consumer<EkoEvent> {

        @Override
        public void accept(EkoEvent ekoEvent) throws Exception {
            switch(ekoEvent.getId()) { // to be considered what in case of 100 types of events
                case ConnectionState: {
                    ConnectionEkoEvent event = (ConnectionEkoEvent) ekoEvent;
                    txt.setText(event.getObject().getState().name());
                    break;
                }
            }
        }
    }
}