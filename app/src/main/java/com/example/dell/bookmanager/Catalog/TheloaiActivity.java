package com.example.dell.bookmanager.Catalog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.dell.bookmanager.R;

public class TheloaiActivity extends AppCompatActivity {
    private ImageView imgthem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);

        imgthem = (ImageView) findViewById(R.id.imgthem);

        imgthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(TheloaiActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_themsach);
                dialog.show();
            }
        });
    }
}
