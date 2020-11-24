package com.example.healthapp;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyAlarmReceiver extends BroadcastReceiver {
    private NotificationManagerCompat notificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        notificationManager = NotificationManagerCompat.from(context);
        String msg=intent.getStringExtra("msg").toString();
        String tag = intent.getStringExtra("tag").toString();
        Notification notification = new NotificationCompat.Builder(context, "channel1").setSmallIcon(R.drawable.ic_launcher_background).setContentTitle(tag).setContentText(msg).setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_ALARM).build();
        notificationManager.notify(1, notification);
        Log.e("onReceive", "--------------------------------------------------------------------");
        Toast.makeText(context, "Health Alert", Toast.LENGTH_SHORT).show();
    }
}