package com.example.smart_recycle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class article_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_page);
        TextView article_name = findViewById(R.id.article_title);
        TextView article_desc = findViewById(R.id.article_desc);

        String title = "not set";
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            title = extras.getString("title");
        }
        article_name.setText(title);

        String desc = "not set";
        if(extras!=null)
        {
            desc = extras.getString("desc");
        }
        article_desc.setText(desc);

    }
}