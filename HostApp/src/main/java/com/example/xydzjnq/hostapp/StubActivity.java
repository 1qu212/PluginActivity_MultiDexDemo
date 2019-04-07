package com.example.xydzjnq.hostapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("StubActivity");
        setContentView(textView);
    }
}
