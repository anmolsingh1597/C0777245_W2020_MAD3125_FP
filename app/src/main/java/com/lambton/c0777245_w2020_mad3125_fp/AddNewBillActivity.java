package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddNewBillActivity extends AppCompatActivity {

    private TextView customerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        initials();

    }

    public void initials(){
        getSupportActionBar().hide();
        customerId = findViewById(R.id.entercustIdTextView);
        Intent intent = getIntent();
        if(intent.hasExtra("custId")){
            customerId.setText(intent.getStringExtra("custId"));
            customerId.setEnabled(false);
        }
    }
}
