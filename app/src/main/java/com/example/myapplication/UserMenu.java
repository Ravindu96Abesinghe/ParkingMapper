package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class UserMenu extends AppCompatActivity implements PaymentResultListener {

    public EditText txtSearchLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        final Button btnpayment = (Button) findViewById(R.id.btnHistory);
        final Button btncloc = (Button) findViewById(R.id.btnCLocation);

        Checkout.preload(getApplicationContext());

        btnpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayement();
            }
        });

        btncloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open register activity
                startActivity(new Intent(UserMenu.this, CurentMapsActivity.class));
            }
        });



//        EditText txtSearchLocation = (EditText) findViewById(R.id.txt);
    }
    private void startPayement(){


        /**
         * Instantiate Checkout
         */
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_eNwgA5oEnElHde");

        /**
         * Set your logo here
         */
        checkout.setImage(R.drawable.circle_icon);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "CodingSTUFF");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "LKR");
            options.put("amount", "30000");//pass amount in currency subunits
            options.put("prefill.email", "gaurav.kumar@example.com");
            options.put("prefill.contact","9988776655");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Log.d("ONSUCCESS", "onPaymentSuccess: " + s);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Log.d("ONERROR", "onPaymentError: "+s);
    }


}