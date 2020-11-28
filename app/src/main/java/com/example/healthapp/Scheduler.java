package com.example.healthapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Scheduler extends AppCompatActivity {

    private static final String URL_DATA = "https://randomuser.me/api/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        recyclerView = findViewById(R.id.ourdoes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        ListItem listItem1 = new ListItem(
          "Blood Sugar Test",
          "4:15PM",
          ""
        );
        listItems.add(listItem1);
        ListItem listItem2 = new ListItem(
                "Blood Sugar Test",
                "10:45PM",
                ""
        );
        listItems.add(listItem2);
        ListItem listItem3 = new ListItem(
                "Blood Sugar Test",
                "8:30AM",
                ""
        );
        listItems.add(listItem3);
        adapter = new MyAdapter(listItems,getApplicationContext());
        recyclerView.setAdapter(adapter);
        //loadRecyclerViewData();
    }

    private void loadRecyclerViewData(){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                s -> {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray array = jsonObject.getJSONArray("results");
                        for(int i=0;i<array.length();i++){
                            JSONObject o = array.getJSONObject(i);
                            ListItem item = new ListItem(
                                    o.getString("gender"),
                                    o.getString("email"),
                                    o.getString("phone")
                            );
                            listItems.add(item);
                        }
                        adapter = new MyAdapter(listItems,getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                },
                error -> {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
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
            Intent intent=new Intent(Scheduler.this,MedicalHistory.class);
            startActivity(intent);
        }
        if(item.getItemId()==201){
            Log.i("Info2","102");
            Intent intent=new Intent(Scheduler.this,MeetWithDoc.class);
            startActivity(intent);
        }
        if(item.getItemId()==301){
            Log.i("Info3","103");
        }
        if(item.getItemId()==401){
            Log.i("Info4","104");
        }
        if(item.getItemId()==501){
            Intent intent=new Intent(Scheduler.this,GlucoseReading.class);
            startActivity(intent);
        }
        if(item.getItemId()==601){
            Log.i("Info5","105");
        }
        return super.onOptionsItemSelected(item);
    }
}