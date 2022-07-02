package com.example.code04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE_STRING=
            "com.example.code4.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试
        final EditText etMessage = findViewById(R.id.message);
        Button btSent = findViewById(R.id.send_message);
        btSent.setOnClickListener(view -> {
            String message = etMessage.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this,MessageActivity.class);
            intent.putExtra(MESSAGE_STRING,message);
            startActivity(intent);
        });
    }
}