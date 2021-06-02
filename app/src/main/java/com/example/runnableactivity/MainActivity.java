package com.example.runnableactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    boolean running = true;
    String TAG = "THREAD";
    String TAG2 = "THREAD2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;

        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (i = 0; i < 20 && running; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    Log.v(TAG2, "Runnable time=" + i);
                    Log.v(TAG, "Tread time=" + 1);
                }
            }
        });
        wr.start();
        Log.v(TAG2, "Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;

        Log.v(TAG2, "Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG2, "Now I am in onPause");
    }
}