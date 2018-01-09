package com.example.jacek.rxtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jacek.rxtest.events.EkoEvent;
import com.example.jacek.rxtest.events.EventReceiver;
import com.example.jacek.rxtest.handlers.connection.ConnectionState;

import io.reactivex.android.schedulers.AndroidSchedulers;
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
        networkStateReceiver = app.getEkoConnectivityHandler().getSubscriber().subscribe(AndroidSchedulers.mainThread(), new MainConsumer());
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
                app.getEkoConnectivityHandler().onConnect();
            }
        });

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.getEkoConnectivityHandler().onDisconnect();
            }
        });
    }

    private class MainConsumer implements Consumer<ConnectionState> {

        @Override
        public void accept(ConnectionState state) throws Exception {
            txt.setText(state.name());
        }
    }
}