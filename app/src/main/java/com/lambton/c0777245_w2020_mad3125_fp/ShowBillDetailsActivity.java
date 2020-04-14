package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;

public class ShowBillDetailsActivity extends AppCompatActivity {

    Bundle customerBundle;
    Customer customerObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);

        initials();
    }
public void initials(){
    Intent intent = getIntent();
    if (intent.hasExtra("cusObject")){
       customerBundle = intent.getBundleExtra("cusObject");
       customerObject = (Customer) customerBundle.getSerializable("customerObject");
        Toast.makeText(ShowBillDetailsActivity.this, customerObject.fullName(), Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(ShowBillDetailsActivity.this, "Else", Toast.LENGTH_SHORT).show();

    }
}
}

