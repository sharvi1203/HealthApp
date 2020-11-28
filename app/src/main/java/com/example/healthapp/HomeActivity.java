package com.example.healthapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    Button btnPatient,btnCaretaker,btnDoctor;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    void init(){
        btnPatient=findViewById(R.id.Patient);
        btnCaretaker=findViewById(R.id.Caretaker);
        btnDoctor=findViewById(R.id.Doctor);
        btnPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,LoginPatient.class);
                startActivity(intent);
            }
        });
        btnCaretaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        setAlarm(22,45,"Take a diabetes check","Blood Sugar Test");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setAlarm(int h, int m, String msg, String tag) {
        alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Toast.makeText(this, "OnReceive alarm test 1", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyAlarmReceiver.class);
        intent.putExtra("msg", msg);
        intent.putExtra("tag", tag);
        alarmIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, h);
        calendar.set(Calendar.MINUTE, m);
        calendar.set(Calendar.SECOND, 0);

        alarmMgr.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        Toast.makeText(this, "OnReceive alarm test 2", Toast.LENGTH_SHORT).show();
    }

}