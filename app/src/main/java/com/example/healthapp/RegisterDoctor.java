package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthapp.model.Doctor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterDoctor extends AppCompatActivity {
    EditText eTxtName,eTxtContact,eTxtEmail,eTxtPass,eTxtQualification,eTxtSpecialization;
    Button btnSubmit;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    Doctor doctor;
    void init(){
        eTxtName=findViewById(R.id.DocName);
        eTxtContact=findViewById(R.id.DocContactNumber);
        eTxtEmail=findViewById(R.id.DocEmailAdd);
        eTxtPass=findViewById(R.id.DocPassword);
        eTxtQualification=findViewById(R.id.qualification);
        eTxtSpecialization=findViewById(R.id.specialization);
        btnSubmit=findViewById(R.id.buttonSubmitDoc);
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctor=new Doctor();
                doctor.Name=eTxtName.getText().toString();
                doctor.contact=eTxtContact.getText().toString();
                doctor.Email=eTxtEmail.getText().toString();
                doctor.pass=eTxtPass.getText().toString();
                doctor.qualification=eTxtPass.getText().toString();
                doctor.specialization=eTxtSpecialization.getText().toString();
                registerUserInFirebase();
            }
        });

    }
    void registerUserInFirebase(){
        //Toast.makeText(MedicalDetails.this,patient.Name+" Kuch ho rha hai",Toast.LENGTH_LONG).show();
        progressDialog.show();
        auth.createUserWithEmailAndPassword(doctor.Email,doctor.pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("Info","Success");
                            saveUserInFirebase();
                        }
                        else{
                            Toast.makeText(RegisterDoctor.this,"Something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    void saveUserInFirebase(){
        FirebaseUser firebaseUser=auth.getCurrentUser();
        String uid=firebaseUser.getUid();
        progressDialog.dismiss();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("doctors").document(uid).set(doctor)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()) {
                            Log.i("Information","Success hojana chahiye save");
                            Intent intent=new Intent(RegisterDoctor.this,MedicalHistory.class);
                            startActivity(intent);
                            finish();
                            //Toast.makeText(MedicalDetails.this, patient.Name + " Kuch ho rha hai", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(RegisterDoctor.this,"Something went wrong save vale function mei",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
        init();
    }
}