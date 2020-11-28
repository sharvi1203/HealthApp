package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class LoginCaretaker extends AppCompatActivity {
    EditText eTxtEmail,eTxtPass;
    Button btnLogin,btnRegister;
    ProgressDialog progressDialog;
    void init(){
        eTxtEmail=findViewById(R.id.LogEmailAddC);
        eTxtPass=findViewById(R.id.LogPasswordC);
        btnLogin=findViewById(R.id.buttonLoginC);
        btnRegister=findViewById(R.id.buttonRegisterC);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                loginUserFromFirebase();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginCaretaker.this,RegisterCaretaker.class);
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
                            Intent intent=new Intent(LoginCaretaker.this,MenuPage.class);
                            startActivity(intent);
                            finish();
                            progressDialog.dismiss();
                            Toast.makeText(LoginCaretaker.this,"Welcome !",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(LoginCaretaker.this,"Please check your Email and password",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_caretaker);
        init();
    }
}