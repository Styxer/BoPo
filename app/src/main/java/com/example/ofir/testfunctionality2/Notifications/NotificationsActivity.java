package com.example.ofir.testfunctionality2.Notifications;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.example.ofir.testfunctionality2.MainActivity;
import com.example.ofir.testfunctionality2.R;

import java.util.GregorianCalendar;

public class NotificationsActivity extends AppCompatActivity {

    Button showNotificationButton,stopNotificationButton, alertButton;

    NotificationManager notificationManager;

    boolean isNotificationActive = false;

   final static int notifID = 33;

    private static final String YES_ACTION = "com.example.ofir.testfunctionality2.Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        showNotificationButton = (Button) findViewById(R.id.bShowNotifications);
        stopNotificationButton = (Button) findViewById(R.id.bStopNotifications);
        alertButton = (Button) findViewById(R.id.bAlertIn5Seconds);

        getSupportActionBar().setTitle("Notifications options");
    }


    public void showNotification(View view) {
        Intent yesReceive = new Intent();
        yesReceive.setAction(YES_ACTION);
        PendingIntent pendingIntentYes = PendingIntent.getBroadcast(this, 12345, yesReceive, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                                            .setContentTitle("BoPo")
                                            .setContentText("Hello from BoPo")
                                            .setTicker("Alert New Message")
                                            .setSmallIcon(R.drawable.ic_sms)
                                            .addAction(R.drawable.ic_delete,"Delete",pendingIntentYes)
                                            .addAction(R.drawable.ic_done,"Done",pendingIntentYes)
                                            .setAutoCancel(true);

        builder.setDefaults(Notification.DEFAULT_LIGHTS);

        Intent moreInfoIntent = new Intent(this, moreInfoNotification.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);

        taskStackBuilder.addNextIntentWithParentStack(moreInfoIntent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        /*taskStackBuilder.addParentStack(moreInfoNotification.class);

        taskStackBuilder.addNextIntent(moreInfoIntent); */


        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifID, builder.build());

        isNotificationActive = true;

    }
  /*  @Override
    public void onSaveInstanceState(Bundle savedInstanceState) { //save  data
        savedInstanceState.putBoolean("MyBoolean", isNotificationActive);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {//recover data
        super.onRestoreInstanceState(savedInstanceState);
        isNotificationActive = savedInstanceState.getBoolean("MyBoolean");

    } */

    public void stopNotification(View view) {

        if(isNotificationActive){
            notificationManager.cancel(notifID);
        }
    }

    public void setAlarm(View view) {

        // Define a time value of 5 seconds
        Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;

        // Define our intention of executing AlertReceiver
        Intent alertIntent = new Intent(this, AlertReceiver.class);

        // Allows you to schedule for your application to do something at a later date
        // even if it is in he background or isn't active
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // set() schedules an alarm to trigger
        // Trigger for alertIntent to fire in 5 seconds
        // FLAG_UPDATE_CURRENT : Update the Intent if active
        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
