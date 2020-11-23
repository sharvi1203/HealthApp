package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MedicalHistory extends AppCompatActivity {
    EditText eTxtMedCond,eTxtStDt,eTxtEndDt,eTxtMedDevice,eTxtReport,eTxtBodySite,eTxtImmun,eTxtMed,eTxtStMed,eTxtMedRep;
    Button btnSubmit;
    MedHistory medHistory;
    void init(){
        eTxtMedCond=findViewById(R.id.MedCondition);
        eTxtStDt=findViewById(R.id.StartDate);
        eTxtEndDt=findViewById(R.id.EndDate);
        eTxtMedDevice=findViewById(R.id.DeviceSpecification);
        eTxtReport=findViewById(R.id.Modality);
        eTxtBodySite=findViewById(R.id.BodySite);
        eTxtImmun=findViewById(R.id.ImmunDescription);
        eTxtMed=findViewById(R.id.DescribeMedicalReports);
        eTxtStMed=findViewById(R.id.DescribeDuration);
        eTxtMedRep=findViewById(R.id.DescribeMedicalReports);
        btnSubmit=findViewById(R.id.ButtonSubmitMed);
        medHistory=new MedHistory();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medHistory.MedCond=eTxtMedCond.getText().toString();
                medHistory.MedCondStDate=eTxtStMed.getText().toString();
                medHistory.MedCondEndDate=eTxtEndDt.getText().toString();
                medHistory.RadioReport=eTxtReport.getText().toString();
                medHistory.device=eTxtMedDevice.getText().toString();
                medHistory.BodySite=eTxtBodySite.getText().toString();
                medHistory.Vaccination=eTxtImmun.getText().toString();
                medHistory.Med=eTxtMed.getText().toString();
                medHistory.Duration=eTxtStMed.getText().toString();
                medHistory.MedReport=eTxtMedRep.getText().toString();
                addDataToFirebase();
                Intent intent=new Intent(MedicalHistory.this,MenuPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
    void addDataToFirebase(){
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        String uid=firebaseUser.getUid();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("users").document(uid).collection("medHistory").add(medHistory)
                .addOnCompleteListener(this, new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isComplete()){
                            Log.i("Test","Complete");
                        }else{
                            Log.i("Testttt","Not Complete");
                        }
                    }
                });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);
        init();
    }
}