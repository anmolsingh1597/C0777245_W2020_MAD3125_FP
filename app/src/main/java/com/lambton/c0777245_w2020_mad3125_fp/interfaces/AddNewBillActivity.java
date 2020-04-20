package com.lambton.c0777245_w2020_mad3125_fp.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.models.Hydro;
import com.lambton.c0777245_w2020_mad3125_fp.models.Internet;
import com.lambton.c0777245_w2020_mad3125_fp.models.Mobile;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class AddNewBillActivity extends AppCompatActivity {

    private TextView customerId;
    private TextView billId;
    private TextView date;
    private RadioGroup billTypeRadioGroup;
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

    String cusIdText;
    String billIDText;
    String dateText;
    String billTypeText = "Mobile";
    String amountText;
    String mobileManufacturerText;
    String planNameText;
    String mobileNumberText;
    String mobileInternetGbText;
    String minutesText;
    String internetGbText;
    String providerNameText;
    String agencyNameText;
    String unitsConsumedText;

    Mobile mobile;
    Internet internet;
    Hydro hydro;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Bills");

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

        Intent intent = getIntent();
        if(intent.hasExtra("custId")){
            customerId.setText(intent.getStringExtra("custId"));
            customerId.setEnabled(false);
            cusIdText = customerId.getText().toString();
        }
        date.setEnabled(false);
        generalTView1.setHint("Mobile Manufacturer");
        generalTView2.setHint("Plan Name");
        generalTView3.setHint("Mobile Number");
        generalTView4.setHint("Internet GB used");
        generalTView5.setHint("Minutes Consumed");



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


                        dateText = date.getText().toString();
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

    public void onClickMobileRadioButton(View view){
        billTypeText = "Mobile";
        generalTView1.setHint("Mobile Manufacturer");
        generalTView2.setHint("Plan Name");
        generalTView3.setHint("Mobile Number");
        generalTView4.setHint("Internet GB used");
        generalTView5.setHint("Minutes Consumed");
        generalTView3.setVisibility(View.VISIBLE);
        generalTView4.setVisibility(View.VISIBLE);
        generalTView5.setVisibility(View.VISIBLE);
    }

    public void onClickInternetRadioButton(View view){
        billTypeText = "Internet";
        generalTView1.setHint("Internet GB used");
        generalTView2.setHint("Provider Name");
        generalTView3.setVisibility(View.GONE);
        generalTView4.setVisibility(View.GONE);
        generalTView5.setVisibility(View.GONE);
    }

    public void onClickHydroRadioButton(View view){
        billTypeText = "Hydro";
        generalTView1.setHint("Agency Name");
        generalTView2.setHint("Units Consumed");
        generalTView3.setVisibility(View.GONE);
        generalTView4.setVisibility(View.GONE);
        generalTView5.setVisibility(View.GONE);

    }
    public void onClickBillSaveButton(View view){

        billIDText = billId.getText().toString();


        if(billTypeText.equals("Mobile")){
            mobileManufacturerText = generalTextView1.getText().toString();
            planNameText = generalTextView2.getText().toString();
            mobileNumberText = generalTextView3.getText().toString();
            mobileInternetGbText = generalTextView4.getText().toString();
            minutesText = generalTextView5.getText().toString();

            amountText = String.valueOf((Double.parseDouble(mobileInternetGbText) * 2.03) + (Double.parseDouble(minutesText) * 0.15));

            mobile = new Mobile(cusIdText,"Bill_"+billIDText,dateText,billTypeText,amountText,mobileManufacturerText,planNameText,mobileNumberText,mobileInternetGbText
            ,minutesText);
            myRef.push().setValue(mobile);

        } else if(billTypeText.equals("Internet")){
            internetGbText = generalTextView1.getText().toString();
            providerNameText = generalTextView2.getText().toString();

            amountText = String.valueOf((Double.parseDouble(internetGbText) * 1.77));

            internet = new Internet(cusIdText,"Bill_"+billIDText,dateText,billTypeText,amountText,internetGbText,providerNameText);
            myRef.push().setValue(internet);

        }else if(billTypeText.equals("Hydro")){
            agencyNameText = generalTextView1.getText().toString();
            unitsConsumedText = generalTextView2.getText().toString();

            amountText = String.valueOf((Double.parseDouble(unitsConsumedText) * 0.89));

            hydro = new Hydro(cusIdText,"Bill_"+billIDText,dateText,billTypeText,amountText,agencyNameText,unitsConsumedText);
            myRef.push().setValue(hydro);

        }

        Intent billDetailsIntent = new Intent(AddNewBillActivity.this, CustomerListActivity.class);
        startActivity(billDetailsIntent);
        finish();

    }

    public void saveAlert(){

    }
}
