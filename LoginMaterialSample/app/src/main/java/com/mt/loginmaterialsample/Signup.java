package com.mt.loginmaterialsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mt.loginmaterialsample.R;

/**
 * Created by panacea on 6/20/17.
 */

public class Signup extends AppCompatActivity {
    private TextInputLayout emailSTIL, pwdSTIL, confirmPwdSTIL;
    private EditText emailSET, pwdSET, confirmSET;
    private Button createAccountB;
    private TextView loginLTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        emailSTIL = (TextInputLayout) findViewById(R.id.emailSTILId);
        pwdSTIL = (TextInputLayout) findViewById(R.id.pwdSTILId);
        confirmPwdSTIL = (TextInputLayout) findViewById(R.id.confirm_pwdTILId);

        emailSET = (EditText) findViewById(R.id.emailSETId);
        pwdSET = (EditText) findViewById(R.id.pwdSETId);
        confirmSET = (EditText) findViewById(R.id.confirm_pwdETId);

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
                
            }
        });

    }
}
