package com.example.dell.bookmanager.catalog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.bookmanager.R;
import com.example.dell.bookmanager.adapter.AdapterTypeBook;
import com.example.dell.bookmanager.database.DatabaseHelper;
import com.example.dell.bookmanager.model.TypeBook;
import com.example.dell.bookmanager.sqlitedao.TypeBookDAO;

import java.util.List;
import java.util.Random;

public class TheloaiActivity extends AppCompatActivity {


    private ImageView imgthem;
    private RecyclerView lvListTypeBooks;


    private AdapterTypeBook adapterTypeBook;
    private List<TypeBook> typeBooks;
    private DatabaseHelper databaseHelper;
    private TypeBookDAO typeBookDAO;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);

        imgthem = (ImageView) findViewById(R.id.imgthem);

        imgthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(TheloaiActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_themsach);

                final EditText tvId;
                final EditText tvName;
                final EditText tvPos;
                final EditText tvDes;
                Button btnSave;
                Button btnCancel;

                tvId = dialog.findViewById(R.id.tvId);
                tvName = dialog.findViewById(R.id.tvName);
                tvPos = dialog.findViewById(R.id.tvPos);
                tvDes = dialog.findViewById(R.id.tvDes);
                btnSave = dialog.findViewById(R.id.btnSave);
                btnCancel = dialog.findViewById(R.id.btnCancel);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Log.e("btnSave", "btnSave");


                        TypeBook typeBook = typeBookDAO.getTypeBookByID(tvId.getText().toString().trim());

                        if (typeBook == null) {
                            typeBook = new TypeBook();
                            String id = tvId.getText().toString().trim();
                            String name = tvName.getText().toString().trim();
                            String des = tvDes.getText().toString().trim();
                            String pos = tvPos.getText().toString().trim();
                            typeBook.id = id;
                            typeBook.name = name;
                            typeBook.description = des;
                            typeBook.position = pos;

                            long result = typeBookDAO.insertTypeBook(typeBook);

                            if (result > 0) {
                                // Thong bao thanh cong va tat dialog
                                typeBooks.add(0, typeBook);

                                // f5 list view
                                adapterTypeBook.notifyDataSetChanged();

                                dialog.cancel();

                            } else {
                                // Thong bao loi xay ra

                                Toast.makeText(TheloaiActivity.this, "Co Loi Xay Ra!!!!", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            // Thong bao da ton tai, chon id khac
                            Toast.makeText(TheloaiActivity.this, "ID da ton tai", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


                dialog.show();
            }
        });

        databaseHelper = new DatabaseHelper(this);
        typeBookDAO = new TypeBookDAO(databaseHelper);

        typeBooks = typeBookDAO.getAllTypeBooks();

        // add sample data

        for (int i = 0; i < 20; i++) {
            TypeBook typeBook = new TypeBook();
            typeBook.id = new Random().nextInt() + "";
            typeBook.name = "Hello Moto";
            typeBook.description = " MMMM";
            typeBook.position = "1" + i;

            typeBooks.add(typeBook);

        }

        lvListTypeBooks = findViewById(R.id.lvListTypeBooks);

        adapterTypeBook = new AdapterTypeBook(this, typeBooks, typeBookDAO);

        lvListTypeBooks.setAdapter(adapterTypeBook);
        linearLayoutManager = new LinearLayoutManager(this);
        lvListTypeBooks.setLayoutManager(linearLayoutManager);
    }
}
