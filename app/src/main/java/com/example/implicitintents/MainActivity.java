package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mCallButton;
    private Button mMessagingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessagingButton = findViewById(R.id.messaging_btn);
        mCallButton = findViewById(R.id.call_btn);

        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //let's open up something to open browser
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
                if (implicitIntent.resolveActivity(getPackageManager()) != null) {
                    implicitIntent.setData(Uri.parse("https://www.google.com"));
                    startActivity(implicitIntent);
                } else {
                    //
                    Toast.makeText(MainActivity.this,
                            "No activity found",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        mMessagingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //let's use an implicit intent to give our user the OPTION to select our activity
                Intent messagingIntent = new Intent(Intent.ACTION_SEND);
                messagingIntent.putExtra(Intent.EXTRA_TEXT, "Some message to send");
                messagingIntent.setType("text/plain");
                messagingIntent.addCategory(Intent.CATEGORY_DEFAULT);

                startActivity(messagingIntent);
            }
        });
    }
}