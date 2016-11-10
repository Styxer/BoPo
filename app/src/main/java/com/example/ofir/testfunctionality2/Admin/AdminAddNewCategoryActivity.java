package com.example.ofir.testfunctionality2.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ofir.testfunctionality2.R;

public class AdminAddNewCategoryActivity extends AppCompatActivity {

    Spinner categoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_category);

        categoryButton = (Spinner) findViewById(R.id.spinner3);

        getSupportActionBar().setTitle("Add new Category");

        String[] categories = new String[]{
                "Study",
                "Eat and Drink",
                "Concerts ",
                "Sports",
                "Conventions"
        };
        // Creating adapter for spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,categories
        );
        // Drop down layout style - list view with radio button
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        // attaching data adapter to spinner
        categoryButton.setAdapter(spinnerArrayAdapter);
    }

}
