package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lambton.c0777245_w2020_mad3125_fp.adapters.HydroAdapter;
import com.lambton.c0777245_w2020_mad3125_fp.adapters.InternetAdapter;
import com.lambton.c0777245_w2020_mad3125_fp.adapters.MobileAdapter;
import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;
import com.lambton.c0777245_w2020_mad3125_fp.models.Hydro;
import com.lambton.c0777245_w2020_mad3125_fp.models.Internet;
import com.lambton.c0777245_w2020_mad3125_fp.models.Mobile;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowBillDetailsActivity extends AppCompatActivity {

    private TextView idTextView;
    private TextView fullNameTextView;
    private TextView emailTextView;
    private TextView mobileTextView;
    private TextView totalAmountTextView;
    private RecyclerView billDetailsView;
    private RecyclerView internetBillDetail;
    private RecyclerView hydroBillDetail;
    private ArrayList<Mobile> mobileList;
    private MobileAdapter mobileAdapter;
    private ArrayList<Internet> internetList;
    private InternetAdapter internetAdapter;
    private ArrayList<Hydro> hydroList;
    private HydroAdapter hydroAdapter;

    Bundle customerBundle;
    Customer customerObject;
    static String name;
    String id;
    Double totalAmount = 0.0;

    RecyclerView.LayoutManager thisLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,
            false);
    RecyclerView.LayoutManager internetLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,
            false);
    RecyclerView.LayoutManager hydroLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,
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
        totalAmountTextView = findViewById(R.id.billDetailsText5);
        billDetailsView = findViewById(R.id.billDetailsRecyclerView);
        internetBillDetail = findViewById(R.id.internetRV);
        hydroBillDetail = findViewById(R.id.hydroRV);
    Intent intent = getIntent();
    if (intent.hasExtra("cusObject")){
        customerBundle = intent.getBundleExtra("cusObject");
        customerObject = (Customer) customerBundle.getSerializable("customerObject");
        name = customerObject.getFirstName();
        idTextView.setText("Customer Id: " + customerObject.getId());
        fullNameTextView.setText("Full Name: " + customerObject.fullName());
        emailTextView.setText("Email: " + customerObject.getEmail());
        mobileTextView.setText("Mobile: " + customerObject.getMobile());
        id = customerObject.getId();
    }
    getSupportActionBar().setTitle(name);

    populateBills();
}

public void populateBills(){
        mobileList = new ArrayList<>();
        internetList = new ArrayList<>();
        hydroList = new ArrayList<>();

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            HashMap<String, HashMap<String, String>> value = (HashMap<String, HashMap<String, String>>) dataSnapshot.getValue();

            HashMap<String, String>[] usersMap;
            usersMap = value.values().toArray(new HashMap[value.size()]);

            for (int i = 0; i < usersMap.length; i++) {

                if (usersMap[i].get("custId").equals(id)) {


                if (usersMap[i].get("billType").equals("Mobile")) {
                    mobileList.add(new Mobile(usersMap[i].get("custId"), usersMap[i].get("id"), usersMap[i].get("date"), usersMap[i].get("billType"), usersMap[i].get("billAmount"),
                            usersMap[i].get("mobileManufacturer"), usersMap[i].get("planName"), usersMap[i].get("mobileNumber"), usersMap[i].get("internetGb"), usersMap[i].get("minutes")));

                    totalAmount += Double.parseDouble(usersMap[i].get("billAmount"));

                    mobileAdapter = new MobileAdapter(mobileList);
                    billDetailsView.setLayoutManager(thisLayoutManager);
                    billDetailsView.setAdapter(mobileAdapter);
                } else if (usersMap[i].get("billType").equals("Internet")) {
                    internetList.add(new Internet(usersMap[i].get("custId"), usersMap[i].get("id"), usersMap[i].get("date"), usersMap[i].get("billType"), usersMap[i].get("billAmount"),
                            usersMap[i].get("internetGb"), usersMap[i].get("providerName")));

                    totalAmount += Double.parseDouble(usersMap[i].get("billAmount"));

                    internetAdapter = new InternetAdapter(internetList);
                    internetBillDetail.setLayoutManager(internetLayoutManager);
                    internetBillDetail.setAdapter(internetAdapter);
                } else if (usersMap[i].get("billType").equals("Hydro")) {
                    hydroList.add(new Hydro(usersMap[i].get("custId"), usersMap[i].get("id"), usersMap[i].get("date"), usersMap[i].get("billType"), usersMap[i].get("billAmount"),
                            usersMap[i].get("agencyName"), usersMap[i].get("unitsConsumed")));

                    totalAmount += Double.parseDouble(usersMap[i].get("billAmount"));

                    hydroAdapter = new HydroAdapter(hydroList);
                    hydroBillDetail.setLayoutManager(hydroLayoutManager);
                    hydroBillDetail.setAdapter(hydroAdapter);

                }
            }
            }
            if (totalAmount>0.0){
            totalAmountTextView.setText("Total Bill: $" + String.valueOf(totalAmount));
            totalAmountTextView.setTextColor(Color.parseColor("#66BB6A"));
            }else {
                totalAmountTextView.setText("User doesn't have any pending Bill ");
                totalAmountTextView.setTextColor(Color.parseColor("#ff0000"));
            }

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
        getMenuInflater().inflate(R.menu.bill_details_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addBillMenuItem:
                Intent newBillIntent = new Intent(ShowBillDetailsActivity.this,AddNewBillActivity.class);
                startActivity(newBillIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ShowBillDetailsActivity.this, CustomerListActivity.class);
        startActivity(back);
    }
}

