package com.example.dell.bookmanager.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.dell.bookmanager.fragment.fragment_Overview;
import com.example.dell.bookmanager.fragment.fragment_addbooks;
import com.example.dell.bookmanager.fragment.fragment_bill;
import com.example.dell.bookmanager.fragment.FraMenu;
import com.example.dell.bookmanager.R;

public class ManChinhActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chinh2);
        bottomNavigationView = findViewById(R.id.BottomNavigationItemView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setSelectedItemId(R.id.homeAsUp);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               // Fragment chuyenmanhinh=null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,new fragment_bill()).commit();

                switch (item.getItemId()){
                case R.id.menu:
                 //   chuyenmanhinh=new FraMenu();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,new FraMenu()).commit();
                    break;

                case R.id.them:
                   //chuyenmanhinh=new fragment_addbooks();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,new fragment_addbooks()).commit();
                    break;

                case R.id.hoadon:
                   // chuyenmanhinh=new fragment_bill();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,new fragment_bill()).commit();
                    break;

                case R.id.home:
                    //chuyenmanhinh=new fragment_Overview();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,new fragment_Overview()).commit();
                    break;
                default:
                     //chuyenmanhinh=new fragment_bill();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,new fragment_bill()).commit();
                    break;

            }
               //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contener,chuyenmanhinh).commit();

            return true;
        }
        });





    }
}
