package com.example.ofir.testfunctionality2.Tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ofir.testfunctionality2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaitingForACKFragment extends Fragment {


    public WaitingForACKFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_waiting_for_ack, container, false);
    }

}
