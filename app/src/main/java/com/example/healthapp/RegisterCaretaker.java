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

import com.example.healthapp.model.Caretaker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterCaretaker extends AppCompatActivity {
    EditText eTxtName,eTxtGender,eTxtContact,eTxtEmailAdd,eTxtPassword,eTxtAdd;
    Button btnSubmit;
    Caretaker caretaker;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    void init(){
        eTxtName=findViewById(R.id.NameCaretaker);
        eTxtGender=findViewById(R.id.GenderCaretaker);
        eTxtContact=findViewById(R.id.CaretakerContactNumber);
        eTxtEmailAdd=findViewById(R.id.CaretakerEmailAdd);
        eTxtPassword=findViewById(R.id.CaretakerPassword);
        eTxtAdd=findViewById(R.id.CaretakerAddress);
        btnSubmit=findViewById(R.id.buttonSubmitCaretaker);
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caretaker=new Caretaker();
                caretaker.Name=eTxtName.getText().toString();
                caretaker.Gender=eTxtGender.getText().toString();
                caretaker.ContactNum=eTxtContact.getText().toString();
                caretaker.EmailAdd=eTxtEmailAdd.getText().toString();
                caretaker.Pass=eTxtPassword.getText().toString();
                caretaker.Add=eTxtAdd.getText().toString();
                if(caretaker.Pass.isEmpty() || caretaker.Pass.length()<6){
                    eTxtPassword.setError("You must have atleast 6 characters");
                    return;
                }
                registerUserInFirebase();
            }
        });
    }
    void registerUserInFirebase(){
        //Toast.makeText(MedicalDetails.this,patient.Name+" Kuch ho rha hai",Toast.LENGTH_LONG).show();
        progressDialog.show();
        auth.createUserWithEmailAndPassword(caretaker.EmailAdd,caretaker.Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("Info","Success");
                            saveUserInFirebase();
                        }
                        else{
                            Toast.makeText(RegisterCaretaker.this,"Something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    void saveUserInFirebase(){
        FirebaseUser firebaseUser=auth.getCurrentUser();
        String uid=firebaseUser.getUid();
        progressDialog.dismiss();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("caretaker").document(uid).set(caretaker)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()) {
                            Log.i("Information","Success hojana chahiye save");
                            Intent intent=new Intent(RegisterCaretaker.this,MedicalHistory.class);
                            startActivity(intent);
                            finish();
                            //Toast.makeText(MedicalDetails.this, patient.Name + " Kuch ho rha hai", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(RegisterCaretaker.this,"Something went wrong save vale function mei",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_caretaker);
        init();
    }
}