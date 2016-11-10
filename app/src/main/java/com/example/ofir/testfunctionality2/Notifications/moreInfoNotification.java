package com.example.ofir.testfunctionality2.Notifications;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ofir.testfunctionality2.R;

public class moreInfoNotification extends AppCompatActivity {

    private Button backNotificationButton;
    int UNIQUE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info_notification);

        //backNotificationButton = (Button) findViewById(R.id.bBackNotification);

        getSupportActionBar().setTitle("Notifications");
    }


    /*public void OnClick(View view) {
        switch (view.getId()){
            case R.id.bBackNotification:
                onBackPressed();
                break;
        }
    }*/

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent intent = new Intent(this,NotificationsActivity.class);
        startActivity(intent);
        finish();
    }
}
