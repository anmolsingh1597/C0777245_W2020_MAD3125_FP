package com.lambton.c0777245_w2020_mad3125_fp.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;


public class AddNewCustomerActivity extends AppCompatActivity {

    private TextView idText;
    private TextView firstNameText;
    private TextView lastNameText;
    private TextView emailText;
    private TextView mobileText;

    String id;
    String firstName;
    String lastName;
    String email;
    String mobile;
    Customer customerObject;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        initials();
    }
    public void initials(){
        getSupportActionBar().hide();
        idText = findViewById(R.id.enterIdNumberTextView);
        firstNameText = findViewById(R.id.enterFirstNameTextView);
        lastNameText = findViewById(R.id.enterLastNameTextView);
        emailText = findViewById(R.id.enterEmailTextView);
        mobileText = findViewById(R.id.enterMobileTextView);

    }

  public void saveButtonOnClicked(View view){
          id = idText.getText().toString();
          firstName = firstNameText.getText().toString();
          lastName = lastNameText.getText().toString();
          email = emailText.getText().toString();
          mobile = mobileText.getText().toString();
          if(id.equals("")){
              idText.setError("Invalid Id");
          }else if(firstName.equals("")){
                firstNameText.setError("Enter First Name");
          }else if(lastName.equals("")){
              lastNameText.setError("Enter Last Name");
          }else if(email.equals("")){
              emailText.setError("Invalid Email");
          }else if(mobile.equals("") || mobile.length()<10){
              mobileText.setError("Invalid Mobile Number");
          }
          else {
              savingData();
              Intent customerList = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
              startActivity(customerList);
              finish();
          }
  }
  public void clearButtonOnClicked(View view){
      idText.setText("");
      firstNameText.setText("");
      lastNameText.setText("");
      emailText.setText("");
      mobileText.setText("");
  }

  public void savingData(){
        customerObject = new Customer("CUS_"+id,firstName,lastName,email,mobile);
        myRef.push().setValue(customerObject);
  }
}
