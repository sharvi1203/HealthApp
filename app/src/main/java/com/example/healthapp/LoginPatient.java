package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPatient extends AppCompatActivity {
    EditText eTxtEmail,eTxtPass;
    Button btnLogin,btnRegister;
    void init(){
        eTxtEmail=findViewById(R.id.LogEmailAddP);
        eTxtPass=findViewById(R.id.LogPasswordP);
        btnLogin=findViewById(R.id.buttonLoginP);
        btnRegister=findViewById(R.id.buttonRegisterP);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserFromFirebase();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginPatient.this,MedicalDetails.class);
                startActivity(intent);
            }
        });
    }
    void loginUserFromFirebase(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAdd=eTxtEmail.getText().toString();
        String password=eTxtPass.getText().toString();
        auth.signInWithEmailAndPassword(emailAdd,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            Intent intent=new Intent(LoginPatient.this,MenuPage.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginPatient.this,"Please check your Email and password",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);
        init();
    }
}