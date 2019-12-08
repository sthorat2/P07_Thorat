package com.example.lenovo_admin.newlogin;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class contactus extends AppCompatActivity {
    private EditText etTo;
    private EditText etSubject;
    private EditText etMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        etTo = findViewById(R.id.etext1);
        etSubject = findViewById(R.id.etext2);
        etMessage = findViewById(R.id.etext3);

        Button  button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendMail();

            }
        });

    }

    private void sendMail(){

        String email = etTo.getText().toString();
        String subject = etSubject.getText().toString();
        String message = etMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email ));

        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(intent);

        /*intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));*/

    }
}



