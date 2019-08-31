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

import org.w3c.dom.Text;

public class SignIn extends AppCompatActivity {
    EditText email;
    EditText password;
    Button btn;
    ProgressBar progressBar;
    TextView signUp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText);
        password = findViewById(R.id.password_in);
        btn = findViewById(R.id.signin_btn);
        signUp = findViewById(R.id.textView6);
        progressBar = findViewById(R.id.progressBar2);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser();
            }
        });
    }

    public void signInUser(){
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
        firebaseAuth.signInWithEmailAndPassword(email_reg, password_reg)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
