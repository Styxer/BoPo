package com.example.ofir.testfunctionality2.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ofir.testfunctionality2.R;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        getSupportActionBar().setTitle("Admin Control Panel");
    }
}
