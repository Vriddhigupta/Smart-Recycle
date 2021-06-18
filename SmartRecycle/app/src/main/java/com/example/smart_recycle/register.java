package com.example.smart_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    EditText company_name,password,email,state,city,phone;
    Button register;
    DBHelper_company DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        company_name = findViewById(R.id.edtcompanyname);
        password = findViewById(R.id.edtPassword);
        email = findViewById(R.id.edtEmail);
        state = findViewById(R.id.edtstate);
        city = findViewById(R.id.edtcity);
        phone = findViewById(R.id.edtphone);
        DB = new DBHelper_company(this);
        register = findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyname = company_name.getText().toString();
                String companyemail = email.getText().toString();
                String companypass = password.getText().toString();
                String companystate = state.getText().toString();
                String companycity = city.getText().toString();
                String companyphone = phone.getText().toString();

                if(companyname.equals("")||companyemail.equals("")||companypass.equals("")||companystate.equals("")||companycity.equals("")||companyphone.equals(""))
                {
                    Toast.makeText(register.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkcomp = DB.checkcompany_name(companyname);
                    if(checkcomp == false)
                    {
                        Boolean checkmail = DB.checkemail(companyemail);
                        if(checkmail==false)
                        {
                            Boolean insert = DB.insertData(companyname,companyemail,companypass,companystate,companycity,companyphone);
                            if(insert == true)
                            {
                                Toast.makeText(register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(register.this,login_activity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(register.this,"Registration failed",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(register.this,"User email already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(register.this,"Company name already exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}