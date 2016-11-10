package com.example.ofir.testfunctionality2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    TextView getCategory;
    TextView getTile;
    TextView getDescription;
    TextView getLocation;
    TextView getDate;
    TextView getTime;
    TextView getACKStatus;
    TextView getDateAndTime;
    TextView getMaxNumOfParticipants;
//////alona

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getCategory = (TextView) findViewById(R.id.tvEventCategory);
        getTile = (TextView) findViewById(R.id.tvEventTile);
        getDescription = (TextView) findViewById(R.id.tvEventDescription);
        getLocation = (TextView) findViewById(R.id.tvEventLocation);
        getACKStatus = (TextView) findViewById(R.id.tvACKStatus);
         getDate = (TextView) findViewById(R.id.tvEventDate);
        getTime = (TextView) findViewById(R.id.tvEventTime);
       // getDateAndTime = (TextView) findViewById(R.id.tvEventDateAndTime);
        getMaxNumOfParticipants = (TextView) findViewById(R.id.tvEventMaxParticipants);

        getSupportActionBar().setTitle("");


        SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        if (preferences != null || !preferences.equals("")) {
            getCategory.setText(preferences.getString("category2", ""));
            //getTile.setText(preferences.getString("title",""));
            getSupportActionBar().setTitle(preferences.getString("title", ""));
            getDescription.setText(preferences.getString("decription", ""));
             if (preferences.getBoolean("isMap",true))
               getLocation.setText(preferences.getString("location",""));
           getDate.setText(preferences.getString("date", ""));
            getTime.setText(preferences.getString("time", ""));
            getACKStatus.setText(preferences.getString("ACKstatus", ""));
            getMaxNumOfParticipants.setText(preferences.getString("MaxMunOfParticipants", ""));
        }
    }
}
