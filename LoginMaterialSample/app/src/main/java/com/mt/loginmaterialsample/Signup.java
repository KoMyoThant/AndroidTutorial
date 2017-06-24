package com.mt.loginmaterialsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import mt.loginmaterialsample.R;

/**
 * Created by panacea on 6/20/17.
 */

public class Signup extends AppCompatActivity {
    private TextInputLayout emailSTIL, pwdSTIL, confirmPwdSTIL;
    private EditText emailSET, pwdSET, confirmSET;
    private Button createAccountB;
    private TextView loginLTV;

    private String email, pwd, confirmPwd;

    public boolean validate;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        mAuth = FirebaseAuth.getInstance();

        // Text Input Layout
        emailSTIL = (TextInputLayout) findViewById(R.id.emailSTILId);
        pwdSTIL = (TextInputLayout) findViewById(R.id.pwdSTILId);
        confirmPwdSTIL = (TextInputLayout) findViewById(R.id.confirm_pwdTILId);

        // Edited text
        emailSET = (EditText) findViewById(R.id.emailSETId);
        pwdSET = (EditText) findViewById(R.id.pwdSETId);
        confirmSET = (EditText) findViewById(R.id.confirm_pwdETId);

        // Button
        createAccountB = (Button) findViewById(R.id.create_accountBId);
        signup();

        loginLTV = (TextView) findViewById(R.id.loginTVId);
        loginUI();
    }

    protected void loginUI() {
        loginLTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    protected void signup() {
        createAccountB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailSTIL.getEditText().getText().toString();
                pwd = pwdSTIL.getEditText().getText().toString();
                confirmPwd = confirmPwdSTIL.getEditText().getText().toString();

                if (!checkValidate()) {
                    return;
                }

                Toast.makeText(getBaseContext(), "Signup Success", Toast.LENGTH_SHORT).show();

                // Signup function
                mAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Signup.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Signup.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Signup.this, Login.class));
                                    finish();
                                }
                            }
                        });
            }
        });

    }

    // Checking validation
    protected boolean checkValidate() {
        validate = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailSTIL.setError("Enter a validate email address");
            validate = false;
        } else {
            emailSTIL.setError(null);
        }

        if (pwd.isEmpty()) {
            pwdSTIL.setError("Enter your password");
            validate = false;
        } else if (pwd.length() < 5) {
            pwdSTIL.setError("At least 6 character.");
            validate = false;
        } else {
            pwdSET.setError(null);
            pwdSTIL.setError(null);
        }

        // Checking Confirm password
        if (confirmPwd.isEmpty() || !confirmPwd.equals(pwd)) {
            confirmPwdSTIL.setError("Password does not match.");
            validate = false;
        } else {
            confirmPwdSTIL.setError(null);
        }


        return validate;
    }
}
