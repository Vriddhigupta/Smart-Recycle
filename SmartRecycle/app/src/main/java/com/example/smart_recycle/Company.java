package com.example.smart_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Company extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        TextView name = findViewById(R.id.company);
        TextView state_name = findViewById(R.id.state_name);
        TextView city_name = findViewById(R.id.city_name);
        TextView Phone = findViewById(R.id.phone);

        String company_name = "not set";
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            company_name = extras.getString("companyname");
        }
        name.setText(company_name);

        String state = "not set";
        if(extras!=null)
        {
            state = extras.getString("state");
        }
        state_name.setText(state);

        String city = "not set";
        if(extras!=null)
        {
            city = extras.getString("city");
        }
        city_name.setText(city);

        String Phone_no = "not set";
        if(extras!=null)
        {
            Phone_no = extras.getString("phone");
        }
        Phone.setText(Phone_no);

        Button btn_book = (Button) findViewById(R.id.btn_book);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Company.this , booking.class));
            }
        });
    }
}