package com.project.gofoodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText email;
    EditText password;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    TextView sign_in;
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //get firebase auth instance
        firebaseAuth = FirebaseAuth.getInstance();

        //get the Id of relevant views
        email = findViewById(R.id.email_up);
        password = findViewById(R.id.editText6);
        progressBar = findViewById(R.id.progressBar);
        sign_in = findViewById(R.id.signin_up);
        sign_up = findViewById(R.id.signup_btn);

        //set onclick listener on sign in
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void registerUser(){

        String email_reg = email.getText().toString();
        String password_reg = password.getText().toString();

        if(TextUtils.isEmpty(email_reg)){
            email.setError("Enter an email address");
            email.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(password_reg)){
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email_reg).matches()){
            email.setError("Enter a valid email address");
            email.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email_reg, password_reg)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(getApplicationContext(), SignIn.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
