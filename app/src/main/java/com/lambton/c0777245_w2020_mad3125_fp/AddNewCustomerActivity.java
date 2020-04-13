package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//import com.google.firebase.database.core.view.View;

public class AddNewCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        initials();
    }
    public void initials(){
        getSupportActionBar().hide();

    }

  public void saveButtonOnClicked(View view){
      Toast.makeText(AddNewCustomerActivity.this, "Save", Toast.LENGTH_SHORT).show();
  }
  public void clearButtonOnClicked(View view){
      Toast.makeText(AddNewCustomerActivity.this, "Clear", Toast.LENGTH_SHORT).show();
  }
}
