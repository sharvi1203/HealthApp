package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MenuPage extends AppCompatActivity {
    TextView TxtMedCond,TxtMedStDt,TxtEndDt,TxtMedDevice,TxtRadio,TxtBodySite,TxtImmun,TxtMedRep,TxtMedications,TxtmedStDt;
    void init(){
        TxtMedCond=findViewById(R.id.TextViewMedCond);
        TxtMedStDt=findViewById(R.id.TextViewStartDate);
        TxtEndDt=findViewById(R.id.TextViewEndDate);
        TxtMedDevice=findViewById(R.id.MedicalDevices);
        TxtRadio=findViewById(R.id.TextViewRadioReports);
        TxtBodySite=findViewById(R.id.TextViewBodySite);
        TxtImmun=findViewById(R.id.TextViewVaccination);
        TxtMedRep=findViewById(R.id.TextViewMedicalReports);
        TxtMedications=findViewById(R.id.TextViewMedicines);
        TxtmedStDt=findViewById(R.id.TextViewStartMed);
        fetchPatientInfo();
    }
    void fetchPatientInfo(){
        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        String uid=firebaseUser.getUid();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("users")
                .document(uid)
                .collection("medHistory")
                .get()
                .addOnCompleteListener(this, new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot snapshots=task.getResult();
                        for(DocumentSnapshot document : snapshots.getDocuments()){
                            MedHistory medHistory=document.toObject(MedHistory.class);
                            TxtMedCond.setText(medHistory.MedCond);
                            TxtMedStDt.setText(medHistory.MedCondStDate);
                            TxtEndDt.setText(medHistory.MedCondEndDate);
                            TxtMedDevice.setText(medHistory.device);
                            TxtRadio.setText(medHistory.RadioReport);
                            TxtBodySite.setText(medHistory.BodySite);
                            TxtImmun.setText(medHistory.Vaccination);
                            TxtMedRep.setText(medHistory.MedReport);
                            TxtMedications.setText(medHistory.Med);
                            TxtMedStDt.setText(medHistory.Duration);
                        }
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,101,1,"Scheduler").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,201,1,"Meet with Doctor").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,301,1,"Edit Medical Information").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,401,1,"Edit Personal Information").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,501,1,"Log Out").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==101){
            Log.i("Info1","101");
        }
        if(item.getItemId()==201){
            Log.i("Info2","102");
            Intent intent=new Intent(MenuPage.this,MeetWithDoc.class);
            startActivity(intent);
        }
        if(item.getItemId()==301){
            Log.i("Info3","103");
        }
        if(item.getItemId()==401){
            Log.i("Info4","104");
        }
        if(item.getItemId()==501){
            Log.i("Info5","105");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        init();
    }
}