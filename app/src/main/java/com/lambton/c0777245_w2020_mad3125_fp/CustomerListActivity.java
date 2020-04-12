package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lambton.c0777245_w2020_mad3125_fp.adapters.CustomersAdapter;
import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;
import com.lambton.c0777245_w2020_mad3125_fp.models.GoogleUser;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

    private TextView name;
    private RecyclerView customerListView;
    private ArrayList<Customer> customerList;
    private CustomersAdapter customersAdapter;

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
        customerListView = findViewById(R.id.customerListRV);
        populateCustomers();
        customersAdapter = new CustomersAdapter(customerList);
        RecyclerView.LayoutManager thisLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false);

        customerListView.setLayoutManager(thisLayoutManager);
        customerListView.setAdapter(customersAdapter);

        fetchUser();

    }

    public void fetchUser(){
        Intent intent = getIntent();
        if (intent.hasExtra("googleUserExtra")){
            fetchedBundle = intent.getBundleExtra("googleUserExtra");
            fetchedUser = (GoogleUser)fetchedBundle.getSerializable("googleUserBundle");
        }
        name.setText(fetchedUser.getFullName());
    }

    public void populateCustomers(){
        customerList = new ArrayList<>();
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));
        customerList.add(new Customer("CUS_1","Anmol","Singh","",""));


    }
}
