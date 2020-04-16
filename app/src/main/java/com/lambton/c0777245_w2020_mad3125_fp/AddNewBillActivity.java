package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewBillActivity extends AppCompatActivity {

    private TextView customerId;
    private TextView billId;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        initials();
    }

    public void initials(){
        getSupportActionBar().hide();
        customerId = findViewById(R.id.entercustIdTextView);
        billId = findViewById(R.id.enterBillIdTextView);
        date = findViewById(R.id.enterDateTextView);
        Intent intent = getIntent();
        if(intent.hasExtra("custId")){
            customerId.setText(intent.getStringExtra("custId"));
            customerId.setEnabled(false);
        }
    }

    public void dateImageButton(View view){
        DatePickerDialog datePickerDialog;
        // Calendar object to hold the selected data
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
// date picker dialog
        datePickerDialog = new DatePickerDialog(AddNewBillActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(getMonthForInt(monthOfYear) + " " + dayOfMonth+", "+year);
                        date.setEnabled(false);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
}
