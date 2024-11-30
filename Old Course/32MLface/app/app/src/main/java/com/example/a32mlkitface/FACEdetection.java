package com.example.a32mlkitface;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class FACEdetection extends Application {

    public static final String RESULT_TEXT = "result_text";
    public static final String RESULT_DIALOG = "result_dialog";

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);

    }
}
