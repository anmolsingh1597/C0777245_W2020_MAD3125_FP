package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lambton.c0777245_w2020_mad3125_fp.models.GoogleUser;

public class CustomerListActivity extends AppCompatActivity {

    private TextView name;

    Bundle fetchedBundle;
    GoogleUser fetchedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        initials();
    }
    public void initials(){
        name = findViewById(R.id.customerListTextView1);
        Intent intent = getIntent();
        if (intent.hasExtra("googleUserExtra")){
            fetchedBundle = intent.getBundleExtra("googleUserExtra");
            fetchedUser = (GoogleUser)fetchedBundle.getSerializable("googleUserBundle");
        }
        name.setText(fetchedUser.getFullName());
    }
}
