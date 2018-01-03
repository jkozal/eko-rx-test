package com.example.jacek.rxtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jacek.rxtest.events.EventReceiver;
import com.example.jacek.rxtest.events.connection.ConnectionEkoEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private EventReceiver networkStateReceiver;
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
        networkStateReceiver = app.getEventManager().getConnectionSubscriber().subscribe(AndroidSchedulers.mainThread(), new MainConsumer());
    }

    @Override
    protected void onPause() {
        super.onPause();
        networkStateReceiver.stop();
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

    private class MainConsumer implements Consumer<ConnectionEkoEvent> {

        @Override
        public void accept(ConnectionEkoEvent event) throws Exception {
            txt.setText(event.getObject().name());
        }
    }
}