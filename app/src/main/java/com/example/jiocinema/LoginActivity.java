package com.example.jiocinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button mBtnGenerateOtp, mLoginWithSim;
    private EditText mEtEnterJioNumber;
    String code = "+91 ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGenerateOtp = findViewById(R.id.btnGenerateOtp);
        mEtEnterJioNumber = findViewById(R.id.etEnterJioNumber);
        mBtnGenerateOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Homepage.class);
                intent.putExtra("phone",code+mEtEnterJioNumber.getText().toString());
                startActivity(intent);
            }
        });
    }
}