package com.example.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password;
    private Button submit;
    TextView link_login;
    private ProgressDialog progressDialog;
    private String email_signup,password_signup;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigup);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_signup);
        password = findViewById(R.id.password_signup);
        submit = findViewById(R.id.button_submit_signup);
        link_login = findViewById(R.id.link_login);

        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(signup.this, MainActivity.class);
                startActivity(in);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_signup = email.getText().toString();
                password_signup = password.getText().toString();
//                Toast.makeText(signup.this,email_signup+password_signup,Toast.LENGTH_SHORT).show();
                mAuth.createUserWithEmailAndPassword(email_signup, password_signup)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(signup.this, "success", Toast.LENGTH_SHORT).show();


                                   // startActivity(new Intent(signup.this, profileActivity.class));

                                } else {
                                    Toast.makeText(signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

               /* auth.createUserWithEmailAndPassword(email_signup, password_signup).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            finish();
                             Toast.makeText(signup.this, "success", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(signup.this, profileActivity.class));

                        } else {
                           Toast.makeText(signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/


            }
        });
    }
    }

