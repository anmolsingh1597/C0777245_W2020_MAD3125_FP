package com.lambton.c0777245_w2020_mad3125_fp.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.models.GoogleUser;

import java.io.Serializable;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar phoneNumberAuthProgressBar;
    private TextView status;
    private Button customerListBtn;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "GoogleActivity";
    GoogleUser googleUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initials();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    private void initials(){
        getSupportActionBar().hide();
        phoneNumberAuthProgressBar = findViewById(R.id.progressBar);
        status = findViewById(R.id.enterStatusTextView);
        customerListBtn = findViewById(R.id.customerListButton);

        status.setEnabled(false);
        phoneNumberAuthProgressBar.setVisibility(View.INVISIBLE);
        customerListBtn.setVisibility(View.INVISIBLE);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }

    public void validateMobileNumber(View view){
        phoneNumberAuthProgressBar.setVisibility(View.VISIBLE);
        signIn();
    }

    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount user) {
        phoneNumberAuthProgressBar.setVisibility(View.INVISIBLE);
        if (user != null) {
            status.setText(getString(R.string.google_status_fmt, user.getEmail()));
            phoneNumberAuthProgressBar.setVisibility(View.INVISIBLE);
            googleUser = new GoogleUser(user.getGivenName(), user.getFamilyName(), user.getEmail());
            customerListBtn.setVisibility(View.VISIBLE);
        } else {
            status.setText(R.string.signed_out);
        }
    }
    
    public void customerListButtonOnClick(View view){
        Bundle googleUserBundle = new Bundle();
        googleUserBundle.putSerializable("googleUserBundle",(Serializable)googleUser);
        Intent customerListIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
        customerListIntent.putExtra("googleUserExtra",googleUserBundle);
        startActivity(customerListIntent);
    }
}
