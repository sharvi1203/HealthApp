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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MedicalDetails extends AppCompatActivity {
    EditText eTxtName,eTxtDob,eTxtGender,eTxtContact,eTxtAdd,eTxtEmailAdd,eTxtPassword;
    Button btnSubmit;
    Patient patient;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    void init(){
        eTxtName=findViewById(R.id.Name);
        eTxtDob=findViewById(R.id.Dob);
        eTxtGender=findViewById(R.id.Gender);
        eTxtContact=findViewById(R.id.ContactNumber);
        eTxtAdd=findViewById(R.id.Address);
        eTxtEmailAdd=findViewById(R.id.EmailAdd);
        eTxtPassword=findViewById(R.id.Password);
        btnSubmit=findViewById(R.id.buttonSubmit);
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient=new Patient();
                patient.Name=eTxtName.getText().toString();
                patient.Dob=eTxtDob.getText().toString();
                patient.Add=eTxtAdd.getText().toString();
                patient.ContactNum=eTxtContact.getText().toString();
                patient.Gender=eTxtGender.getText().toString();
                patient.EmailAdd=eTxtEmailAdd.getText().toString();
                patient.Password=eTxtPassword.getText().toString();
                if(patient.Password.isEmpty() || patient.Password.length()<6){
                    eTxtPassword.setError("You must have atlease 6 characters");
                    return;
                }
                //Toast.makeText(MedicalDetails.this,patient.Name+" Kuch ho rha hai",Toast.LENGTH_LONG).show();
                registerUserInFirebase();
            }
        });
    }
    void registerUserInFirebase(){
        //Toast.makeText(MedicalDetails.this,patient.Name+" Kuch ho rha hai",Toast.LENGTH_LONG).show();

        auth.createUserWithEmailAndPassword(patient.EmailAdd,patient.Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("Info","Success");

                            saveUserInFirebase();
                        }
                        else{
                            Toast.makeText(MedicalDetails.this,"Something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    void saveUserInFirebase(){
        FirebaseUser firebaseUser=auth.getCurrentUser();
        String uid=firebaseUser.getUid();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("users").document(uid).set(patient)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()) {
                            Log.i("Information","Success hojana chahiye save");
                            Intent intent=new Intent(MedicalDetails.this,MedicalHistory.class);
                            startActivity(intent);
                            finish();
                            //Toast.makeText(MedicalDetails.this, patient.Name + " Kuch ho rha hai", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MedicalDetails.this,"Something went wrong save vale function mei",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_details);
        init();
    }


}