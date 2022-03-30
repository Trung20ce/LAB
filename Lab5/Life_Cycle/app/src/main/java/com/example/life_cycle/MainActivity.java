package com.example.life_cycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static String STATE = "Trạng thái: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(STATE, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(STATE, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(STATE, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(STATE, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(STATE, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(STATE, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(STATE, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(STATE, "onSaveInstanceState");
    }

}