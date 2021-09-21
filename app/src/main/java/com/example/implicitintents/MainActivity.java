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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}