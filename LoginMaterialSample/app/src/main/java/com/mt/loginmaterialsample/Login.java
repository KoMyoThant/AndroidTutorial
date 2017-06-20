package com.mt.loginmaterialsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mt.loginmaterialsample.R;

/**
 * Created by panacea on 6/17/17.
 */

public class Login extends AppCompatActivity {
    private TextInputLayout emailTIL, pwdTIL;
    private String email, pwd;
    private Button loginBtn;
    private TextView signupLTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailTIL = (TextInputLayout) findViewById(R.id.emailTILId);
        pwdTIL = (TextInputLayout) findViewById(R.id.pwdTILId);

        loginBtn = (Button) findViewById(R.id.loginBId);
        login();

        signupLTV = (TextView) findViewById(R.id.signupTVId);
        signupUI();
    }

    protected boolean checkValidate() {
        boolean validate = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTIL.setError("Enter a validate email address");
            validate = false;
        } else {
            emailTIL.setError(null);
        }

        if (pwd.isEmpty()) {
            pwdTIL.setError("Enter your password");
            validate = false;
        } else {
            pwdTIL.setError(null);
        }

        return validate;
    }

    protected void login() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailTIL.getEditText().getText().toString();
                pwd = pwdTIL.getEditText().getText().toString();

                if (!checkValidate()) {
                    Toast.makeText(getBaseContext(), "Login fail.", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(getBaseContext(), "Login success.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    protected void signupUI() {
        signupLTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Signup.class);
                startActivity(intent);
            }
        });
    }
}
