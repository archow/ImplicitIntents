package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MessagingActivity extends AppCompatActivity {
    private TextView mMessagingTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        mMessagingTv = findViewById(R.id.messaging_tv);

        Intent receivedIntent = getIntent();
        if (receivedIntent != null) {
            String receivedString = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
            mMessagingTv.setText(receivedString);
        }
    }
}