package com.example.lenovo_admin.newlogin;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button register, log_in;
    EditText First_Name, etEmail, MobileNO, Password ;
    //String F_Name_Holder, Email_Holder, PasswordHolder;
    //String finalResult ;
    String HttpURL = "https://rentmycar.000webhostapp.com/Loginapp/UserRegistration.php";
    Boolean CheckEditText ;
    public SQLiteApp1 mydb=new SQLiteApp1(this);
    Context context;
    //ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    String MobHolder="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        First_Name = (EditText)findViewById(R.id.editTextF_Name);
        etEmail = (EditText)findViewById(R.id.editTextEmail);
        MobileNO = findViewById(R.id.editTextMobile);
        Password = (EditText)findViewById(R.id.editTextPassword);
        register = (Button)findViewById(R.id.Submit);
        log_in = (Button)findViewById(R.id.Login);
        Intent veri = getIntent();

        MobHolder=veri.getStringExtra("vmobile");
        MobileNO.setText(MobHolder);





        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,UserLoginActivity.class);
                startActivity(intent);

            }
        });
        AddData();

    }

    private void AddData() {
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String name = First_Name.getText().toString();
                        if(TextUtils.isEmpty(name)) {
                            First_Name.setError("This filed cannot be empty");
                            return;
                        }

                        final String email = etEmail.getText().toString();
                        if(TextUtils.isEmpty(email)) {
                            etEmail.setError("This filed cannot be empty");
                            return;
                        }

                        final String phone = MobileNO.getText().toString();
                        if(TextUtils.isEmpty(phone)) {
                            MobileNO.setError("This filed cannot be empty");

                            return;
                        }

                        final String password =  Password.getText().toString();
                        if(TextUtils.isEmpty(password)) {
                            Password.setError("This filed cannot be empty");
                            return;

                        }


                        boolean isInserted = mydb.insertData(First_Name.getText().toString(),
                                etEmail.getText().toString(),
                                MobileNO.getText().toString(),
                        Password.getText().toString()
                        );
                        if(isInserted) {
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, UserLoginActivity.class);
                            MainActivity.this.startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }
}
