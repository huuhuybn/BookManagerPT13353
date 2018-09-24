package com.example.dell.bookmanager.sqlitedao;

import com.example.dell.bookmanager.database.DatabaseHelper;

public class BookDAO {

    private DatabaseHelper databaseHelper;

    public BookDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


}
