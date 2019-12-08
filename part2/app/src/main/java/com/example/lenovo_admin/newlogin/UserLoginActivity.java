package com.example.lenovo_admin.newlogin;

//import android.app.ProgressDialog;
import android.content.Intent;
//import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class UserLoginActivity extends AppCompatActivity {
    EditText  Password;
    EditText MobileNO,password;
    EditText mobileno;

    String mobile;
    Button LogIn ;
    public static final String UserMobile = "";
    public SQLiteApp1 mydb = new SQLiteApp1(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        Password = (EditText)findViewById(R.id.password);
        MobileNO=(EditText)findViewById(R.id.email);
        LogIn = (Button)findViewById(R.id.Login);

       LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
       Userlogin();
    }

    private void Userlogin() {
        LogIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String  Mobile =  MobileNO.getText().toString();
                        if (TextUtils.isEmpty(Mobile)) {


                            MobileNO.setError("This filed cannot be empty");
                            return;
                        }

                        final String Password1 = Password.getText().toString();
                        if (TextUtils.isEmpty(Password1)) {
                            password.setError("invalid password");
                             return;
                        }

                        mobile=MobileNO.getText().toString();


                        boolean isInserted = mydb.Userlogin(MobileNO.getText().toString(), Password.getText().toString());
                        if (isInserted) {
                            Toast.makeText(UserLoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(UserLoginActivity.this, DashboardActivity.class);
                            intent.putExtra("CUSTNO",mobile);
                            UserLoginActivity.this.startActivity(intent);
                        }
                        else
                            Toast.makeText(UserLoginActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void regg(View view)
    {
        Toast.makeText(UserLoginActivity.this,"FILL ALL DETAILS FOR REGISTERATION",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(UserLoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

}