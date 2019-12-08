package com.example.lenovo_admin.newlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class StoneList extends AppCompatActivity {
    String HttpURL = "https://rentmycar.000webhostapp.com/Loginapp/stock.php";

   EditText etitem1,etqtn1,etprice1;
   Button btn1;

    public SQLiteApp1 db = new SQLiteApp1(this);

    String MobileNo="";
    public final static String mob= "";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stone_list);
        Intent intent = getIntent();
        MobileNo= intent.getStringExtra(DashboardActivity.mob);

        etitem1 = findViewById(R.id.item1);
        etitem1.setEnabled(false);
        etqtn1 = findViewById(R.id.qtn1);
        etprice1 = findViewById(R.id.price1);
        etprice1.setEnabled(false);
        btn1 = findViewById(R.id.btn1);

        addtoCart();
    }

    public void addtoCart(){

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean isInserted = db.addToCart(etitem1.getText().toString(),etqtn1.getText().toString(),etprice1.getText().toString());
                if(isInserted == true)
                    Toast.makeText(StoneList.this,"Data Inserted Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(StoneList.this,"Data Insertion Failed",Toast.LENGTH_LONG).show();

            }
        });
    }






    public void AddCart() {

    }


}
