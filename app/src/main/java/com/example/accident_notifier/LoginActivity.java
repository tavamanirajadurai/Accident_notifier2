package com.example.accident_notifier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText mail,password;
    Button login,signup;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail=(EditText)findViewById(R.id.mail);
        password=(EditText)findViewById(R.id.password);
         login=(Button)findViewById(R.id.llogin);
         mauth=FirebaseAuth.getInstance();
         signup=(Button)findViewById(R.id.lsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),Signup_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        login.setOnClickListener( view -> {
            loginUser();
        });

    }
private void loginUser(){
    String email=mail.getText().toString();
    String pass=password.getText().toString();
    if(TextUtils.isEmpty(email)){
        mail.setError("mail cant be null");
        mail.requestFocus();
    }
    else if(TextUtils.isEmpty(pass)){
        password.setError("password cant be null");
        password.requestFocus();
    }
    else{
        mauth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"user login successful..!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"login error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

}