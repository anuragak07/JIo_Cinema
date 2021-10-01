package com.example.jiocinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.net.Inet4Address;
import java.util.concurrent.TimeUnit;

import okhttp3.internal.connection.RealCall;

public class Homepage extends AppCompatActivity {
    private Button mBtnLogin;
    private EditText mEtEnterOTP;
    String jioNumber, otp;
    String TAG = "tag";
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mBtnLogin = findViewById(R.id.btnLogin);
        mEtEnterOTP = findViewById(R.id.etEnterOTP);
        jioNumber = getIntent().getStringExtra("phone").toString();
        mAuth= FirebaseAuth.getInstance();
        initiateOTP();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEtEnterOTP.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Blank field",Toast.LENGTH_SHORT).show();
                else if (mEtEnterOTP.getText().toString().length()<6)
                    Toast.makeText(getApplicationContext(),"wrong otp", Toast.LENGTH_SHORT).show();

                else{
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp,mEtEnterOTP.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, More.class);
                startActivity(intent);
            }
        });

    }

    private void initiateOTP(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                jioNumber, 120, TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           startActivity(new Intent(Homepage.this, More.class));
                           finish();
                        } else {
                            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    //FirebaseAuth.getInstance().signOut();


}