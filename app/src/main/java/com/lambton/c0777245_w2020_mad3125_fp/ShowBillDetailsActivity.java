package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;

public class ShowBillDetailsActivity extends AppCompatActivity {

    private TextView idTextView;
    private TextView fullNameTextView;
    private TextView emailTextView;
    private TextView mobileTextView;
    private RecyclerView billDetailsView;

    Bundle customerBundle;
    Customer customerObject;
      static String name;

    RecyclerView.LayoutManager thisLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
            false);
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Bills");
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
        billDetailsView = findViewById(R.id.billDetailsRecyclerView);
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

