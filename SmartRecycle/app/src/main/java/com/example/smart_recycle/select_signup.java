package com.example.smart_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class select_signup extends AppCompatActivity {
    Button company;
    Button consumer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_signup);

        company = findViewById(R.id.company);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_signup.this,register.class);
                startActivity(intent);
            }
        });
        consumer = findViewById(R.id.consumer);
        consumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_signup.this,sign_up.class);
                startActivity(intent);
            }
        });
    }
}