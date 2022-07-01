package com.example.code04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etMessage = findViewById(R.id.message);
        Button btSent = findViewById(R.id.send_message);
        btSent.setOnClickListener(view -> {
            String message = etMessage.getText().toString().trim();
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
        });
    }
}