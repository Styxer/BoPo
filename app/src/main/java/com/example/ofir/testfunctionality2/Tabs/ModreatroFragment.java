package com.example.ofir.testfunctionality2.Tabs;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ofir.testfunctionality2.CreateNewEventActivity;
import com.example.ofir.testfunctionality2.EventActivity;
import com.example.ofir.testfunctionality2.MyEventsActivity;
import com.example.ofir.testfunctionality2.R;

import static com.example.ofir.testfunctionality2.R.id.tvGetModreatorDate;
import static com.example.ofir.testfunctionality2.R.id.tvGetModreatorLocation;
import static com.example.ofir.testfunctionality2.R.id.tvGetModreatorTime;
import static com.example.ofir.testfunctionality2.R.id.tvGetModreatorTitle;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModreatroFragment extends Fragment {

    TextView getTile;
    TextView getLocation;
    TextView getDate;
    TextView getTime;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public ModreatroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modreatro, container, false);
        getTile = (TextView) view.findViewById(tvGetModreatorTitle);
        getLocation = (TextView) view.findViewById(tvGetModreatorLocation);
        getDate = (TextView) view.findViewById(tvGetModreatorDate);
        getTime = (TextView) view.findViewById(tvGetModreatorTime);

        SharedPreferences preferences = this.getActivity().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        if (preferences != null || !preferences.equals("")) {
            getTile.setText(preferences.getString("title", "title   ") + "   ");
            if (preferences.getBoolean("isMap", true))
                getLocation.setText(preferences.getString("location", "location    ") + "   ");
            getDate.setText(preferences.getString("date", "date    ") + "   ");
            getTime.setText(preferences.getString("time", "time    ") + "   ");

        }

        android.widget.TableRow tableRow = (TableRow) view.findViewById(R.id.one);
        tableRow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                rowClick(v);
            }
        });


        return view;
    }

    public void rowClick(View view) {
        switch(view.getId()) {
            case R.id.one:
                Intent intent = new Intent(getActivity(), EventActivity.class);
                startActivity(intent);

                break;
        }
    }

}


