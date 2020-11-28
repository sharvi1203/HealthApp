package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GlucoseReading extends AppCompatActivity {
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucose_reading);
        btnSubmit=findViewById(R.id.buttonSubmitG);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GlucoseReading.this,HomeActivity.class);
                startActivity(intent);
                Toast.makeText(GlucoseReading.this,"Reading Successfully Saved",Toast.LENGTH_LONG).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,101,1,"Medical History").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,201,1,"Meet with Doctor").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,301,1,"Edit Medical Information").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,401,1,"Edit Personal Information").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,501,1,"Take Reading").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,601,1,"Log Out").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==101){
            Log.i("Info1","101");
            Intent intent=new Intent(GlucoseReading.this,MedicalHistory.class);
            startActivity(intent);
        }
        if(item.getItemId()==201){
            Log.i("Info2","102");
            Intent intent=new Intent(GlucoseReading.this,MeetWithDoc.class);
            startActivity(intent);
        }
        if(item.getItemId()==301){
            Log.i("Info3","103");
        }
        if(item.getItemId()==401){
            Log.i("Info4","104");
        }
        if(item.getItemId()==501){
            Intent intent=new Intent(GlucoseReading.this,Scheduler.class);
            startActivity(intent);
        }
        if(item.getItemId()==601){
            Log.i("Info5","105");
        }
        return super.onOptionsItemSelected(item);
    }
}