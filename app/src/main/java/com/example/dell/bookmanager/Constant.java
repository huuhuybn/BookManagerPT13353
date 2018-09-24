package com.example.dell.bookmanager;

public interface Constant {



     String POSITION = "position";
     String DATA = "data";
     String ON_UPDATE_USER = "on_update_user";

     /* table user*/

     String TABLE_USER = "USER";

     String COLUMN_USERNAME = "Username";
     String COLUMN_PASSWORD = "Password";
     String COLUMN_NAME = "Name";
     String COLUMN_PHONE = "PhoneNumber";

     String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +
            COLUMN_USERNAME + " VARCHAR PRIMARY KEY," +
            COLUMN_PASSWORD + " VARCHAR," +
            COLUMN_NAME + " VARCHAR," +
            COLUMN_PHONE + " VARCHAR" +
            ")";

    /* table book*/




    /* table type book*/




}
