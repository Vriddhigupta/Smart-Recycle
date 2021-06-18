package com.example.smart_recycle;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper_company  extends SQLiteOpenHelper {
    public static final String DBNAME = "companyinfo.db";
    public DBHelper_company(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"companyinfo.db",null,1);
    }

    public DBHelper_company(Context context) {
        super(context,"companyinfo.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create Table company(company_name TEXT primary key,email TEXT,password TEXT,state TEXT,city TEXT,Phone_no TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table If exists company");
    }

    public Boolean insertData(String company_name,String email,String password,String state, String city,String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("company_name",company_name);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("state",state);
        contentValues.put("city",city);
        contentValues.put("Phone_no",phone);
        long result = db.insert("company",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkcompany_name(String company_name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from company where company_name = ?",new String[]{company_name});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemail(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from company where email = ?",new String[]{email});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkcredentials(String email,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from company where email = ? and password = ?",new String[]{email,password});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public List<company_model> getAllCompanies(String city_name) {
        // array of columns to fetch
        String[] data = {
                columns.Entry.COLUMN_COMPANY_NAME,
                columns.Entry.COLUMN_COMPANY_STATE,
                columns.Entry.COLUMN_COMPANY_CITY,
                columns.Entry.COLUMN_COMPANY_PHONE,
        };
        // sorting orders
        String sortOrder =
                columns.Entry.COLUMN_COMPANY_NAME + " ASC";
        List<company_model> companyList = new ArrayList<company_model>();

        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
//        String selection = columns.Entry.COLUMN_COMPANY_CITY + " = ?";
//
//        // selection argument
//        String[] selectionArgs = {city_name};
                Cursor cursor = db.query(columns.Entry.TABLE_NAME, //Table to query
                data,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                company_model beneficiary = new company_model();
                beneficiary.setName(cursor.getString(cursor.getColumnIndex(columns.Entry.COLUMN_COMPANY_NAME)));
                beneficiary.setState(cursor.getString(cursor.getColumnIndex(columns.Entry.COLUMN_COMPANY_STATE)));
                beneficiary.setCity(cursor.getString(cursor.getColumnIndex(columns.Entry.COLUMN_COMPANY_CITY)));
                beneficiary.setPhone(cursor.getString(cursor.getColumnIndex(columns.Entry.COLUMN_COMPANY_PHONE)));

                // Adding user record to list
                companyList.add(beneficiary);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return companyList;
    }
}
