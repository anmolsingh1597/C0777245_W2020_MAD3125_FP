package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;

public class ShowBillDetailsActivity extends AppCompatActivity {

    private TextView idTextView;
    private TextView fullNameTextView;
    private TextView emailTextView;
    private TextView mobileTextView;

    Bundle customerBundle;
    Customer customerObject;
//    String id;
      static String name;
//    String email;
//    String mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        initials();
    }
public void initials(){
        idTextView = findViewById(R.id.billDetailsText1);
        fullNameTextView = findViewById(R.id.billDetailsText2);
        emailTextView = findViewById(R.id.billDetailsText3);
        mobileTextView = findViewById(R.id.billDetailsText4);
    Intent intent = getIntent();
    if (intent.hasExtra("cusObject")){
        customerBundle = intent.getBundleExtra("cusObject");
        customerObject = (Customer) customerBundle.getSerializable("customerObject");
        name = customerObject.getFirstName();
        idTextView.setText("Customer Id: " + customerObject.getId());
        fullNameTextView.setText("Full Name: " + customerObject.fullName());
        emailTextView.setText("Email: " + customerObject.getEmail());
        mobileTextView.setText("Mobile: " + customerObject.getMobile());
    }
    getSupportActionBar().setTitle(name);
}

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ShowBillDetailsActivity.this, CustomerListActivity.class);
        startActivity(back);
    }
}

