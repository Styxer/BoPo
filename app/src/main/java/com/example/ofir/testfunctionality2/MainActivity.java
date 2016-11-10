package com.example.ofir.testfunctionality2;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ofir.testfunctionality2.Notifications.NotificationsActivity;
import com.example.ofir.testfunctionality2.Tabs.TabsMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button createNewEvent;
    private Button showMyEvents;
    private Button notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNewEvent = (Button) findViewById(R.id.bCreateNewEvent);
        showMyEvents = (Button) findViewById(R.id.bShowMyEvents);
        notifications = (Button) findViewById(R.id.bNotifications);
    }

    public void buttonOnClick(View v) {
        switch (v.getId()) {
            case R.id.bCreateNewEvent:
                Intent createNewEventIntent = new Intent(this, CreateNewEventActivity.class);
                startActivity(createNewEventIntent);


                break;
            case R.id.bShowMyEvents:
                Intent myEventsIntent = new Intent(this, TabsMainActivity.class);
                startActivity(myEventsIntent);

                break;

            case  R.id.bNotifications:
                Intent notificationsIntent = new Intent(this, NotificationsActivity.class);
                startActivity(notificationsIntent);
                break;

        }
    }
}
