package com.example.lenovo_admin.newlogin;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {
    Button LogOut,copybtn;
    EditText MobShow;
    String MobHolder,Holder,varholder;
    String code="FLAT40";
    Dialog myDialog;
    TextView txtclose;
    public final static String MobileNo="";
    String mobileno;

    public static final String mob = "";

    public DashboardActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();

        mobileno = intent.getStringExtra("CUSTNO");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setContentView(R.layout.activity_dashboard);
        MobShow = findViewById(R.id.MobShow2);
        MobShow.setText(mobileno);
        MobShow.setFocusable(false);
        myDialog = new Dialog(this);;
    }


    public void showpopup(View view) {
        myDialog.setContentView(R.layout.popup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        copybtn =(Button) myDialog.findViewById(R.id.copybtn);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", code);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "CODE copied to Clipboard",
                        Toast.LENGTH_LONG).show();

                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void contactusreq(View view) {
        Intent ctus=new Intent(DashboardActivity.this,contactus.class);
        startActivity(ctus);
    }



    public void carbook(View view) {
        Intent intent=new Intent(DashboardActivity.this, StoneList.class);
        intent.putExtra(mob,mobileno);
        startActivity(intent);

    }



    public void findstation(View view) {
        Intent intent=new Intent(DashboardActivity.this,Station.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(DashboardActivity.this, UserLoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }


    public void myhis(View view) {
        Intent intent=new Intent(DashboardActivity.this,userhistory.class);
        intent.putExtra("user",mobileno);
        startActivity(intent);

    }
}