package com.android.webview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText id,name,type,form;
    Button addBtn,viewBtn,updateBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        id = findViewById(R.id.etId);
        name = findViewById(R.id.etName);
        type = findViewById(R.id.etType);
        form = findViewById(R.id.etForm);
        addBtn = findViewById(R.id.btnAdd);
        viewBtn = findViewById(R.id.btnView);
        updateBtn = findViewById(R.id.btnUpdate);
        deleteBtn = findViewById(R.id.btnDelete);
        AddData();
        GetData();
        UpdateData();
        DeleteData();


    }

    public void DeleteData(){

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer deletedRows = db.deleteData(id.getText().toString());

                if(deletedRows > 0)
                    Toast.makeText(MainActivity.this,"Data Deleted Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Deletion Failed",Toast.LENGTH_LONG).show();



            }
        });
    }

    public void UpdateData(){

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdated = db.updateData(id.getText().toString(),name.getText().toString(),type.getText().toString(),form.getText().toString());
                if(isUpdated == true)
                    Toast.makeText(MainActivity.this,"Data Updated Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Updation Failed",Toast.LENGTH_LONG).show();



            }
        });
    }


    public void GetData(){

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = db.getData();
                if(res.getCount() == 0){
                    showMessage("Error","No Data To Display");
                    return;

                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("ID : "+res.getString(0)+ "\n");
                    buffer.append("NAME : "+res.getString(1)+ "\n");
                    buffer.append("TYPE : "+res.getString(2)+ "\n");
                    buffer.append("FORM : "+res.getString(3)+ "\n\n");
                }

                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void AddData(){

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               boolean isInserted = db.insertData(name.getText().toString(),type.getText().toString(),form.getText().toString());
                if(isInserted == true)
                    Toast.makeText(MainActivity.this,"Data Inserted Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Insertion Failed",Toast.LENGTH_LONG).show();

            }
        });
    }
}
