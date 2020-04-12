package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar phoneNumberAuthProgressBar;
    private TextView mobileNumber;
    private TextInputLayout mobileNumberAuthLayout;
    private TextView mobileNumberAuth;

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

        phoneNumberAuthProgressBar.setVisibility(View.INVISIBLE);
        mobileNumberAuthLayout.setVisibility(View.INVISIBLE);
    }

    public void validateMobileNumber(View view){
        phoneNumberAuthProgressBar.setVisibility(View.VISIBLE);
        mobileNumberAuthLayout.setVisibility(View.VISIBLE);

    }

    private void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobile,
                60,
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
//                editTextCode.setText(code);
//                //verifying the code
//                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
//            mVerificationId = s;
//            mResendToken = forceResendingToken;
        }
    };
}
