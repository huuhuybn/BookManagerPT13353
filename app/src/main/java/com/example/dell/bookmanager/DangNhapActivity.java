package com.example.dell.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.bookmanager.GiaoDienChinh.ManChinhActivity;
import com.example.dell.bookmanager.database.DatabaseHelper;
import com.example.dell.bookmanager.model.User;

public class DangNhapActivity extends AppCompatActivity {

    private EditText edtusename;
    private EditText edtpassword;
    private Button btnlogin;
    private TextView forgotpassword;
    private TextView register;


    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        // khoi tao database
        databaseHelper = new DatabaseHelper(this);

        initViews();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usename = edtusename.getText().toString().trim();
                String password = edtpassword.getText().toString().trim();

                if (usename.equals("")) {
                    edtusename.setError(getString(R.string.noi));
                }
                if (password.equals("")) {
                    edtpassword.setError(getString(R.string.loi));
                } else {

                    User user = databaseHelper.getUserByUsername(usename);

                    // neu use !=null, tuc la username co tren DB thi so sanh password
                    if (user !=null){
                        String passwordOnDatabase = user.getPassword();

                        // neu password giong nhau thi cho phep dang nhap va mo man hinh ManChinhActivity
                        if (passwordOnDatabase.equals(password)){
                            Intent intent = new Intent(DangNhapActivity.this, ManChinhActivity.class);
                            startActivity(intent);
                        }
                        // neu password ko giong thi thong bao loi
                        else Toast.makeText(DangNhapActivity.this,getString(R.string.notify_wrong_password),Toast.LENGTH_SHORT).show();
                    }
                    // neu user == null thi thong bao loi
                    else  Toast.makeText(DangNhapActivity.this,getString(R.string.notify_wrong_password),Toast.LENGTH_SHORT).show();

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhapActivity.this, DangKiActivity.class));
            }
        });

    }

    private void initViews() {
        edtusename =  findViewById(R.id.edtusename);
        edtpassword =  findViewById(R.id.edtpassword);
        btnlogin = findViewById(R.id.btnlogin);
        forgotpassword = findViewById(R.id.forgotpassword);
        register =  findViewById(R.id.register);
    }


}
