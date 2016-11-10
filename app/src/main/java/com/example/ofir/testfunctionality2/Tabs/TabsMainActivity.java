package com.example.ofir.testfunctionality2.Tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.ofir.testfunctionality2.R;

public class TabsMainActivity extends AppCompatActivity {

   // Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);
       // toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tableLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        getSupportActionBar().setTitle("My events");

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new ModreatroFragment(), "Moderator");
        viewPagerAdapter.addFragments(new ParticipantFragment(), "participant");
        viewPagerAdapter.addFragments(new WaitingForACKFragment(), "Waiting for ACK");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);





    }
}
