package com.example.smart_recycle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper_blog  extends SQLiteOpenHelper {
    public static final String DBNAME = "blog.db";
    public DBHelper_blog(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"blog.db",null,1);
    }

    public DBHelper_blog(Context context) {
        super(context,"blog.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table blogs(title TEXT primary key,description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table If exists blogs");
    }

    public Boolean insertData(String title,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("description",description);
        long result = db.insert("blogs",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public List<PostModel> getAllPosts() {
        // array of columns to fetch
        String[] data1 = {"title","description"};
        // sorting orders
        String sortOrder =
                "title" + " ASC";
        List<PostModel> postList = new ArrayList<PostModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
//        String selection = columns.Entry.COLUMN_COMPANY_CITY + " = ?";
//
//        // selection argument
//        String[] selectionArgs = {city_name};
        Cursor cursor = db.query("blogs", //Table to query
                data1,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PostModel post = new PostModel();
                post.setpTitle(cursor.getString(cursor.getColumnIndex("title")));
                post.setpDescription(cursor.getString(cursor.getColumnIndex("description")));


                // Adding user record to list
                postList.add(post);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return postList;
    }
}

