package com.lambton.c0777245_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewBillActivity extends AppCompatActivity {

    private TextView customerId;
    private TextView billId;
    private TextView date;
    private RadioGroup billTypeRadioGroup;
//    private RadioButton mobileRadioButton;
//    private RadioButton internetRadioButton;
//    private RadioButton hydroRadioButton;
    private RadioButton billTypeRadioButton;
    private TextView generalTextView1;
    private TextView generalTextView2;
    private TextView generalTextView3;
    private TextView generalTextView4;
    private TextView generalTextView5;
    private TextInputLayout generalTView1;
    private TextInputLayout generalTView2;
    private TextInputLayout generalTView3;
    private TextInputLayout generalTView4;
    private TextInputLayout generalTView5;
    private TextView totalBillAmountTextView;



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
        billTypeRadioGroup = findViewById(R.id.billTypeRadioGroup);
//        mobileRadioButton = findViewById(R.id.mobileRadioButton);
//        internetRadioButton = findViewById(R.id.internetRadioButton);
//        hydroRadioButton = findViewById(R.id.hydroRadioButton);
        generalTextView1 = findViewById(R.id.enterGeneralTextView1);
        generalTextView2 = findViewById(R.id.enterGeneralTextView2);
        generalTextView3 = findViewById(R.id.enterGeneralTextView3);
        generalTextView4 = findViewById(R.id.enterGeneralTextView4);
        generalTextView5 = findViewById(R.id.enterGeneralTextView5);
        generalTView1 = findViewById(R.id.generalTextView1);
        generalTView2 = findViewById(R.id.generalTextView2);
        generalTView3 = findViewById(R.id.generalTextView3);
        generalTView4 = findViewById(R.id.generalTextView4);
        generalTView5 = findViewById(R.id.generalTextView5);


        totalBillAmountTextView = findViewById(R.id.enterTotalBillTextView);

        Intent intent = getIntent();
        if(intent.hasExtra("custId")){
            customerId.setText(intent.getStringExtra("custId"));
            customerId.setEnabled(false);
        }
        date.setEnabled(false);



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

    public void radioGroupAction(){
        int selectedId = billTypeRadioGroup.getCheckedRadioButtonId();
            billTypeRadioButton = findViewById(selectedId);
            if(billTypeRadioButton.getText().toString().equals("Mobile")){
                generalTView1.setHint("Mobile Manufacturer");
                generalTView2.setHint("Mobile Number");
                generalTView3.setHint("Plan Name");
                generalTView4.setHint("Internet GB used");
                generalTView5.setHint("Minutes Consumed");
                generalTView3.setVisibility(View.VISIBLE);
                generalTView4.setVisibility(View.VISIBLE);
                generalTView5.setVisibility(View.VISIBLE);
            }else if(billTypeRadioButton.getText().toString().equals("Internet")){
                generalTView1.setHint("Provider Name");
                generalTView2.setHint("Internet GB Used");
                generalTView3.setVisibility(View.GONE);
                generalTView4.setVisibility(View.GONE);
                generalTView5.setVisibility(View.GONE);

            }else if(billTypeRadioButton.getText().toString().equals("Hydro")){
                generalTView1.setHint("Agency Name");
                generalTView2.setHint("Units Consumed");
                generalTView3.setVisibility(View.GONE);
                generalTView4.setVisibility(View.GONE);
                generalTView5.setVisibility(View.GONE);
            }


        
    }

    public void onClickBillSaveButton(View view){
        radioGroupAction();
    }
}
