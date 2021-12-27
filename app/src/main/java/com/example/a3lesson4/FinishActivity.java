package com.example.a3lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    private TextView txtText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        txtText = findViewById(R.id.txt_finish);
    }
}