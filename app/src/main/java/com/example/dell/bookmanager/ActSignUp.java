package com.example.dell.bookmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActSignUp extends AppCompatActivity {

    private ImageView imgquaylai;
    private EditText edtusenamedk;
    private EditText edtpassworddk;
    private Button btnlogindk;
    private TextView tvlogindk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        anhxadangki();

        imgquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnlogindk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usenamedk=edtusenamedk.getText().toString().trim();
                String passworđk=edtpassworddk.getText().toString().trim();

                if (usenamedk.equals("")){
                    edtusenamedk.setError(getString(R.string.loitkdk));
                }
                if(passworđk.equals("")){
                    edtpassworddk.setError(getString(R.string.loidkmk));
                }

                //xu lý sqlite để thêm dữ liệu
            }
        });

        tvlogindk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    private void anhxadangki() {
        imgquaylai = (ImageView) findViewById(R.id.imgquaylai);
        edtusenamedk = (EditText) findViewById(R.id.edtusenamedk);
        edtpassworddk = (EditText) findViewById(R.id.edtpassworddk);
        btnlogindk = (Button) findViewById(R.id.btnlogindk);
        tvlogindk = (TextView) findViewById(R.id.tvlogindk);
    }

}
