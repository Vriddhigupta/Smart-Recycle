package com.example.smart_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sign_up extends AppCompatActivity {
    EditText passworduser,emailuser,username;
    Button signup;
    DBHelper_user DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.edtUsername);
        passworduser = findViewById(R.id.edtPassworduser);
        emailuser = findViewById(R.id.edtEmailuser);

        DB = new DBHelper_user(this);
        signup = findViewById(R.id.btnSignUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String useremail = emailuser.getText().toString();
                String userpass = passworduser.getText().toString();

                if(useremail.equals("")||userpass.equals("")||user.equals(""))
                {
                    Toast.makeText(sign_up.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkcomp = DB.checkusername(user);
                    if(checkcomp == false)
                    {
                        Boolean checkmail = DB.checkemail(useremail);
                        if(checkmail==false)
                        {
                            Boolean insert = DB.insertData(user,useremail,userpass);
                            if(insert == true)
                            {
                                Toast.makeText(sign_up.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(sign_up.this,login_activity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(sign_up.this,"Registration failed",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(sign_up.this,"User email already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(sign_up.this,"Username already exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}