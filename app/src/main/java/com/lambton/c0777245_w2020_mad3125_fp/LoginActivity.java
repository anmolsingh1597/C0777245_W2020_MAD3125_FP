package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar phoneNumberAuthProgressBar;
    private TextView mobileNumber;
    private TextInputLayout mobileNumberAuthLayout;
    private TextView mobileNumberAuth;
    private String mVerificationId;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initials();
    }

    private void initials(){
        phoneNumberAuthProgressBar = findViewById(R.id.progressBar);
        mobileNumber = findViewById(R.id.enterMobileNumberTextView);
        mobileNumberAuthLayout = findViewById(R.id.mobileAuthTextView);
        mobileNumberAuth = findViewById(R.id.enterMobileAuthTextView);
        mAuth = FirebaseAuth.getInstance();


        phoneNumberAuthProgressBar.setVisibility(View.INVISIBLE);
        mobileNumberAuthLayout.setVisibility(View.INVISIBLE);
    }

    public void validateMobileNumber(View view){

        String mobile = "+1" + mobileNumber.getText().toString().trim();
        if(mobile.isEmpty() || mobile.length() < 10){
            mobileNumber.setError("Enter a valid mobile");
            mobileNumber.requestFocus();
        }else {
            phoneNumberAuthProgressBar.setVisibility(View.VISIBLE);
            mobileNumberAuthLayout.setVisibility(View.VISIBLE);
            sendVerificationCode(mobile);
//            Toast.makeText(LoginActivity.this, "Method Called: Send Verification code for " + mobile, Toast.LENGTH_SHORT).show();
//            verifyVerificationCode(code);
        }
    }


    private void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile,
                10,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();
            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                mobileNumberAuth.setText(code);
                //verifying the code
                verifyVerificationCode(code);
            }else{
                Toast.makeText(LoginActivity.this, "Didn't get the code", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
//            mResendToken = forceResendingToken;
        }
    };
    private void verifyVerificationCode(String otp) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp);
        //signing the user
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            Intent intent = new Intent(LoginActivity.this, CustomerListActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        } else {

                            //verification unsuccessful.. display an error message

                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }

                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
                            snackbar.setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            });
                            snackbar.show();
                        }
                    }
                });
    }
}
