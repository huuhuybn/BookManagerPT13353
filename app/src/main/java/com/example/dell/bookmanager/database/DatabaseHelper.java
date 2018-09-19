package com.example.dell.bookmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dell.bookmanager.common.Constants;
import com.example.dell.bookmanager.model.User;

public class DatabaseHelper extends SQLiteOpenHelper {


    public final static String TABLE_USER = "USER";

    public final static String COLUMN_USERNAME = "Username";
    public final static String COLUMN_PASSWORD = "Password";
    public final static String COLUMN_NAME = "Name";
    public final static String COLUMN_PHONE = "PhoneNumber";

    public final static String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +
            COLUMN_USERNAME + " VARCHAR PRIMARY KEY," +
            COLUMN_PASSWORD + " VARCHAR," +
            COLUMN_NAME + " VARCHAR," +
            COLUMN_PHONE + " VARCHAR" +
            ")";


    public DatabaseHelper(Context context) {
        super(context, "BookManager", null, 1);
    }


    public void insertUser(User user) {

        // xin quyen ghi sqlite
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // Su dung ContentValues de dua du lieu vao DB
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, user.getUsername());
        contentValues.put(COLUMN_PASSWORD, user.getPassword());
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_PHONE, user.getPhone());
        long id = sqLiteDatabase.insert(TABLE_USER, null, contentValues);

        if (Constants.isDEBUG) Log.e("insertUser", "insertUser : " + id);

        sqLiteDatabase.close();


    }

    public User getUserByUsername(String username) {
        User user = null;
        // xin quyen ghi sqlite
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // query tim kiem user voi username = tham so truyen vao

        // 1: ten bang
        //2 : array cot can lay du lieu
        // 3: ten cot dung de query
        // 4 : gia tri can tim
        // 5,6,7 : null. la cac cau lenh xap xep dieu kien...
        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                new String[]{COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_NAME, COLUMN_PHONE},
                COLUMN_USERNAME + "=?", new String[]{username},
                null, null, null);

        // neu cursor co gia tri
        if (cursor != null && cursor.moveToFirst()) {
            String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
            user = new User(user_name, password, name, phone);

        }
        return user;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);

    }
}
