package com.example.smart_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class create_blog extends AppCompatActivity {
    DBHelper_blog DB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_blog);
        Button create_blog = findViewById(R.id.create_blog);
        EditText edttitle = findViewById(R.id.edttitle);
        EditText edtdesc = findViewById(R.id.edtdesc);
        DB3 = new DBHelper_blog(this);
        create_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edttitle.getText().toString();
                String desc = edtdesc.getText().toString();
                if(title.equals("")||desc.equals(""))
                    Toast.makeText(create_blog.this,"Fill all the fields",Toast.LENGTH_SHORT).show();
                else
                    {
                    Boolean insert = DB3.insertData(title,desc);
                    if (insert == true) {
                        Toast.makeText(create_blog.this, "Post Created successfully Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(create_blog.this, BlogList.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(create_blog.this, "Post creation failed", Toast.LENGTH_SHORT).show();
                }
            }
            });
    }
}