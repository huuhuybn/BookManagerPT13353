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


    // CREATE TABLE TypeBook (MaTheLoai CHAR(5) PRIMARY KEY NOT NULL,
     // TypeName NVARCHAR(50) NOT NULL,
     // Description NVARCHAR(255),
     // Position INT
     // )


     String TABLE_TYPE_BOOK = "TypeBook";

     String TB_COLUMN_ID = "MaTheLoai";
     String TB_COLUMN_NAME = "TypeName";
     String TB_COLUMN_DES = "Description";
     String TB_COLUMN_POS = "Position";

     String CREATE_TABLE_TYPE_BOOK = "CREATE TABLE " + TABLE_TYPE_BOOK + "(" +
             "" + TB_COLUMN_ID + " PRIMARY KEY NOT NULL," +
             "" + TB_COLUMN_NAME + " NVARCHAR(50) NOT NULL," +
             "" + TB_COLUMN_DES + " NVARCHAR(255)," +
             "" + TB_COLUMN_POS + " INT" +
             ")";









}
