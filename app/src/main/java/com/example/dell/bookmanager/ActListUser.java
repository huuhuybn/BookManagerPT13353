package com.example.dell.bookmanager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dell.bookmanager.adapter.AdapterUser;
import com.example.dell.bookmanager.database.DatabaseHelper;
import com.example.dell.bookmanager.model.User;
import com.example.dell.bookmanager.sqlitedao.UserDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ActListUser extends AppCompatActivity implements Constant {

    private RecyclerView lvListUser;
    private AdapterUser adapterUser;
    private LinearLayoutManager linearLayoutManager;
    private List<User> userList;
    private DatabaseHelper databaseHelper;
    private UserDAO userDAO;

    private BroadcastReceiver onUpdateUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initData();


    }

    private void initData() {

        userList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);
        userList = userDAO.getAllUsers();

        adapterUser = new AdapterUser(this, userList, userDAO);
        lvListUser.setAdapter(adapterUser);
        lvListUser.setLayoutManager(linearLayoutManager);

        onUpdateUser = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                int position = intent.getIntExtra(POSITION,-1);
                User userUpdated = (User) intent.getSerializableExtra(DATA);

                userList.get(position).setName(userUpdated.getName());
                userList.get(position).setPhone(userUpdated.getPhone());
                userList.get(position).setPassword(userUpdated.getPassword());
                adapterUser.notifyDataSetChanged();


            }
        };

        IntentFilter intentFilter
                = new IntentFilter(ON_UPDATE_USER);
        registerReceiver(onUpdateUser, intentFilter);


    }

    private void initViews() {
        setContentView(R.layout.act_list_user);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        lvListUser = findViewById(R.id.lvListUser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_user) {

        }
        return super.onOptionsItemSelected(item);
    }
}
