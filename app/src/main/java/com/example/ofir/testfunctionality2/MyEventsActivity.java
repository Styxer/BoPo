package com.example.ofir.testfunctionality2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyEventsActivity extends AppCompatActivity {
    TextView getCategory;
    TextView getTile;
    TextView getDescription;
    TextView getLocation;
    TextView getDate;
    TextView getTime;
    TextView getACKStatus;
    TextView getMaxNumOfParticipants;
    ActionBar actionBar;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    //public static final String MAP_PREF = "MapPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        getCategory = (TextView) findViewById(R.id.tvGetCategoryModreator);
        getTile = (TextView) findViewById(R.id.tvGetTitleModreator);
        getDescription = (TextView) findViewById(R.id.tvGetDescriptionModreator);
        getLocation = (TextView) findViewById(R.id.tvGetLocationModreator);
        getACKStatus = (TextView) findViewById(R.id.tvGetAckStatusModreator);
        getDate = (TextView) findViewById(R.id.tvGetDateModreator);
        getTime = (TextView) findViewById(R.id.tvGetTimeModreator);
        getMaxNumOfParticipants = (TextView) findViewById(R.id.tvGetMaxParticipantsModreator);

        //set app bar- >@Override public void setActionBar(String heading) {

        getSupportActionBar().setTitle("");


        SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        if (preferences != null || !preferences.equals("")) {
            getCategory.setText(preferences.getString("category2",""));
            //getTile.setText(preferences.getString("title",""));
            getSupportActionBar().setTitle(preferences.getString("title",""));
            getDescription.setText(preferences.getString("decription",""));
            if (preferences.getBoolean("isMap",true))
                getLocation.setText(preferences.getString("location",""));
            getDate.setText(preferences.getString("date", ""));
            getTime.setText(preferences.getString("time", ""));
            getACKStatus.setText(preferences.getString("ACKstatus",""));
            getMaxNumOfParticipants.setText(preferences.getString("MaxMunOfParticipants",""));





        }


    }


}
