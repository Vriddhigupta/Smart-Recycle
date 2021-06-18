package com.example.smart_recycle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login_activity extends AppCompatActivity {
    public static String PREFS_NAME = "MyPrefsFile";
    EditText user_email,user_password;
    Button login;
    TextView forgot;
    Button signup;
    DBHelper_company DB;
    DBHelper_user DB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user_email = findViewById(R.id.edtEmaillogin);
        user_password = findViewById(R.id.edtPasslogin);
        login = findViewById(R.id.btnLogin);
        forgot = findViewById(R.id.txtForgetPassword);
        DB = new DBHelper_company(this);
        DB2 = new DBHelper_user(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String email = user_email.getText().toString();
              String password = user_password.getText().toString();

              if(email.equals("")||password.equals(""))
              {
                  Toast.makeText(login_activity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Boolean checkuserpass = DB.checkcredentials(email,password);
                  Boolean checkuserpass2 = DB2.checkusernamepassword(email,password);
                  if(checkuserpass==true||checkuserpass2==true)
                  {
                      SharedPreferences sharedPreferences = getSharedPreferences(login_activity.PREFS_NAME,0);
                      SharedPreferences.Editor editor = sharedPreferences.edit();
                      editor.putBoolean("hasLoggedIn",true);
                      editor.commit();
                      Toast.makeText(login_activity.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(login_activity.this,dashboard.class);
                      startActivity(intent);
                  }
                  else
                  {
                      Toast.makeText(login_activity.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                  }
              }
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_activity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        signup = findViewById(R.id.btnSignUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_activity.this,select_signup.class);
                startActivity(intent);
            }
        });
    }
}