package com.example.ofir.testfunctionality2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateNewEventActivity extends AppCompatActivity
        implements ToggleButton.OnCheckedChangeListener,
        OnItemSelectedListener {


    Calendar calendar = Calendar.getInstance();
    TextView displayTime;
    TextView displayDate;
    TextView locationChoosen;
    EditText title;
    EditText description;
    EditText MaxNumOfParticipants;
    Button DisplayTPDBbutton;
    Button DateButton;
   // Button CategoryButton;
    Button selectLocation;
    Button saveEvent;
    ToggleButton ACKButton;
    DatePickerDialog datePickerDialog;
    Spinner categoryButton;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;




    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_event);

        DisplayTPDBbutton = (Button) findViewById(R.id.bSelectTime);
        DateButton = (Button) findViewById(R.id.bSelectDate);
        //CategoryButton = (Button) findViewById(R.id.bCategory);
        selectLocation = (Button) findViewById(R.id.bSelectLocation);
        saveEvent = (Button) findViewById(R.id.bSaveNewEvent);
        displayTime = (TextView) findViewById(R.id.tvTimeDisplay);
        displayDate = (TextView) findViewById(R.id.tvDateDisplay);
        locationChoosen =(TextView) findViewById(R.id.tvLocationChosen);
        title = (EditText) findViewById(R.id.etEventTitle);
        description = (EditText) findViewById(R.id.etEventDescription);
        MaxNumOfParticipants = (EditText) findViewById(R.id.etNumOfMaxparticipants);
        ACKButton = (ToggleButton) findViewById(R.id.tbACK);
        categoryButton = (Spinner) findViewById(R.id.spinner);

        //create listeners
        ACKButton.setOnCheckedChangeListener(this);
        categoryButton.setOnItemSelectedListener(this);



        getSupportActionBar().setTitle("Create New Event");
     //   getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        //create editor
        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        //clear SharedPreferences
        editor.clear();
        editor.commit();

        preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
      //  if (preferences.getBoolean("isMap",true))
            locationChoosen.setText(preferences.getString("location",""));


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



    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        if (preferences.getBoolean("isMap",true))
            locationChoosen.setText(preferences.getString("location",""));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_time:
                new TimePickerDialog(this, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true ).show();
                return true;
            case R.id.action_date:
                datePickerDialog = new DatePickerDialog(this, onDateListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) );
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void buttonOnClick(View v){
        switch (v.getId()){
            case R.id.bSelectTime:
                new TimePickerDialog(this, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true ).show();
                break;
            case R.id.bSelectDate:
                datePickerDialog = new DatePickerDialog(this, onDateListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) );
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                break;
           /* case R.id.bCategory:
                PopupMenu popupMenu = new PopupMenu(this, v);
                popupMenu.inflate(R.menu.popup);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
                break;*/
            case R.id.bSelectLocation:
                Intent mapsIntent = new Intent(this, MapsActivity.class);
                CreateNewEventActivity.this.startActivity(mapsIntent);
                break;
            case R.id.bSaveNewEvent:
                Intent saveIntent = new Intent(this, MainActivity.class);

//                editor.putString("category", CategoryButton.getText().toString());
                editor.putString("category2", categoryButton.getSelectedItem().toString());
                editor.putString("title", title.getText().toString());
                editor.putString("decription", description.getText().toString());
                editor.putBoolean("isMap", true);
                editor.putString("time", displayTime.getText().toString());
                editor.putString("date", displayDate.getText().toString());
                editor.putString("MaxMunOfParticipants", MaxNumOfParticipants.getText().toString());
                editor.putString("ACKstatus", ACKButton.getText().toString());

                startActivity(saveIntent);
                editor.commit();
                break;
            case R.id.bCancelEvent:
                Intent cancelIntent = new Intent(this, MainActivity.class);
                startActivity(cancelIntent);
                editor.clear();
                editor.commit();
                break;
        }

    }



    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            DecimalFormat df = new DecimalFormat("00");
            String show = String.valueOf(df.format(hourOfDay) + ":" + String.valueOf(df.format(minute)));
            displayTime.setText(show);
        }
    };

    DatePickerDialog.OnDateSetListener onDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

           // new DatePickerDialog(MainActivity.this,onDateListener,year, monthOfYear, dayOfMonth).getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

            DecimalFormat df  = new DecimalFormat("00");
            String show = String.valueOf(df.format(dayOfMonth) + "/" + String.valueOf(df.format(monthOfYear + 1) + "/" + String.valueOf(df.format(year))));
           // displayDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            displayDate.setText(show);


        }
    };

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ACKButton.setTextOff("ACK OFF");
        ACKButton.setTextOn("ACK ON");
        if(isChecked){
            Toast.makeText(getApplicationContext(),"ACK ON",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext(),"ACK OFF",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
       // Toast.makeText(parent.getContext(), "", Toast.LENGTH_LONG).show();
    }


}
