package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar phoneNumberAuthProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNumberAuthProgressBar = findViewById(R.id.progressBar);
        phoneNumberAuthProgressBar.setVisibility(View.INVISIBLE);
    }
}
