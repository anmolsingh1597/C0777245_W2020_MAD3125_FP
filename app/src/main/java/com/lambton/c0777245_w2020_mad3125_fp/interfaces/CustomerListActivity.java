package com.lambton.c0777245_w2020_mad3125_fp.interfaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.adapters.CustomersAdapter;
import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;
import com.lambton.c0777245_w2020_mad3125_fp.models.GoogleUser;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerListActivity extends AppCompatActivity {

    RecyclerView.LayoutManager thisLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
            false);
    Bundle fetchedBundle;
    GoogleUser fetchedUser;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");
    private TextView name;
    private RecyclerView customerListView;
    private ArrayList<Customer> customerList;
    private CustomersAdapter customersAdapter;
    private ProgressBar custListProgressBar;

    static String actionBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        initials();
    }
    public void initials(){
        name = findViewById(R.id.customerListTextView1);
        name.setText("Customer List");
        customerListView = findViewById(R.id.customerListRV);
        custListProgressBar = findViewById(R.id.customerListProgressBar);
        populateCustomers();
        fetchUser();
        getSupportActionBar().setTitle(actionBarTitle);
    }

    public void fetchUser(){
        Intent intent = getIntent();
        if (intent.hasExtra("googleUserExtra")){
            fetchedBundle = intent.getBundleExtra("googleUserExtra");
            fetchedUser = (GoogleUser)fetchedBundle.getSerializable("googleUserBundle");
            actionBarTitle = fetchedUser.getFullName();
        }


    }

    public void populateCustomers(){

        customerList = new ArrayList<>();
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HashMap<String, HashMap<String, String>> value = (HashMap<String, HashMap<String, String>>) dataSnapshot.getValue();

                HashMap<String, String>[] usersMap;
                usersMap = value.values().toArray(new HashMap[value.size()]);

                for (int i = 0; i < usersMap.length; i++) {
                customerList.add(new Customer(usersMap[i].get("id"), usersMap[i].get("firstName"), usersMap[i].get("lastName"), usersMap[i].get("email"), usersMap[i].get("mobile")));
            }
                customersAdapter = new CustomersAdapter(customerList);
                customerListView.setLayoutManager(thisLayoutManager);
                customerListView.setAdapter(customersAdapter);
                custListProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_list_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.newCustomerMenuItem:
                Intent newCustomer = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(newCustomer);
                break;
            case R.id.logoutMenuItem:
                backAlert();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        backAlert();
    }

    public void backAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!!");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage("Are you Sure");
        builder.setCancelable(false);
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent logout = new Intent(CustomerListActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }
}
