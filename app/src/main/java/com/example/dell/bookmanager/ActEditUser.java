package com.example.dell.bookmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.bookmanager.database.DatabaseHelper;
import com.example.dell.bookmanager.model.User;
import com.example.dell.bookmanager.sqlitedao.UserDAO;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ActEditUser extends AppCompatActivity implements Constant {


    private User user;

    private TextView tvUserName;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private EditText edtName;
    private EditText edtPhone;
    private Button btnUpdate;

    private DatabaseHelper databaseHelper;
    private UserDAO userDAO;

    private int position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initViews();
        initData();
        initActions();


    }

    private void initActions() {

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = user.getUsername();
                String password = edtPassword.getText().toString().trim();
                String phone = edtPhone.getText().toString().trim();
                String name = edtName.getText().toString().trim();

                User user = new User(username, password, name, phone);
                userDAO.updateUser(user);

                Intent intent = new Intent(ON_UPDATE_USER);
                intent.putExtra(DATA,user);
                intent.putExtra(POSITION,position);
                sendBroadcast(intent);

                finish();
            }
        });

    }

    private void initData() {
        user = (User) getIntent().getSerializableExtra(DATA);
        position = getIntent().getIntExtra(POSITION, -1);
        tvUserName.setText(user.getUsername());
        edtName.setText(user.getName());
        edtPhone.setText(user.getPhone());

        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);


    }

    private void initViews() {
        setContentView(R.layout.act_edit_user);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        tvUserName = findViewById(R.id.tvUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        btnUpdate = findViewById(R.id.btnUpdate);

    }

}
