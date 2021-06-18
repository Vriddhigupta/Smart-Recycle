package com.example.smart_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class FilterPage extends AppCompatActivity {
    Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_page);
        Spinner dropdown = findViewById(R.id.nextfilter);
        String[] items1 = new String[]{"Mumbai","Thane","Delhi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown.setAdapter(adapter);
        String text = dropdown.getSelectedItem().toString();

        btn_search = findViewById(R.id.filternext);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CompanyList.class);
                intent.putExtra("message_key", text);
                startActivity(intent);
            }
        });
    }
}