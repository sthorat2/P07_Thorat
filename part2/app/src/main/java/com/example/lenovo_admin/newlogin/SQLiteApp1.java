package com.example.lenovo_admin.newlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SQLiteApp1 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Register.db";
    public static final String TABLE_NAME="register_table";
    public static final String TABLE_NAME1="login_table";
    public static final String TABLE_NAME3="cart_table";
    public static final String col_1="First_Name";
    public static final String col_2="etEmail";
    public static final String col_3=" MobileNO";
    public static final String col_4=" Password";
    public static final String col_5=" Item";
    public static final String col_6=" Quantity";
    public static final String col_7=" Price";



    public SQLiteApp1( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+ "(First_Name Text,etEmail Text, MobileNO Text,Password Text)");
        db.execSQL("create table "+TABLE_NAME1+ "(MobileNO Text,Password Text)");
        db.execSQL("create table "+TABLE_NAME3+ "(Item Text,Quantity Text,Price Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+  TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME3);
        onCreate(db);
    }
    public boolean insertData(String First_Name, String etEmail, String MobileNO, String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,First_Name);
        contentValues.put(col_2,etEmail);
        contentValues.put(col_3, MobileNO);
        contentValues.put(col_4,Password);
        long result=db.insert(TABLE_NAME,null,contentValues);
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(col_3,MobileNO);
        contentValues1.put(col_4,Password);
        db.insert(TABLE_NAME1,null,contentValues1);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean Userlogin(String MobileNO,String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME1+" where MobileNO=? AND Password=?",new String[]{MobileNO,Password});
        if(res.getCount()>0)
            return true;
        else
            return false;
    }


    public boolean addToCart(String Item,String Quantity,String Price){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_5,Item);
        contentValues.put(col_6,Quantity);
        contentValues.put(col_7,Price);
        long result = db.insert(TABLE_NAME3,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }


    public Cursor fetchdata(String MobileNO)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res1=db.rawQuery("select * from "+TABLE_NAME3+" where MobileNO=? ",new String[]{MobileNO});
        return res1;

    }

}
