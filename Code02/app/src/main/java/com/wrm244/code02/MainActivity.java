package com.wrm244.code02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowToast = findViewById(R.id.btnShowToast);
        btnShowToast.setOnClickListener(view ->
                Toast.makeText(MainActivity.this,"Hello Word",Toast.LENGTH_SHORT).show());

        final TextView tvCount = findViewById(R.id.tvCount);
        Button btnCount = findViewById(R.id.btnCount);
        btnCount.setOnClickListener(view ->
                tvCount.setText(Integer.toString(++count)));

    }
}