package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://parkingmapper-680fd-default-rtdb.firebaseio.com");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView txtCreateAcc = (TextView) findViewById(R.id.txtCreateAccount);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernametxt = txtUsername.getText().toString();
                final String passwordtxt = txtPassword.getText().toString();

                if (usernametxt.isEmpty() || passwordtxt.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your user name or password", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            // check if user is exist in firebase database
                            if (snapshot.hasChild(usernametxt)) {

                                // user is exist in firebase database
                                // now get password of user from firebase data and match it with user entered password

                                String getPassword = snapshot.child(usernametxt).child("password")
                                        .getValue(String.class);

                                String getUserType = snapshot.child(usernametxt).child("type")
                                        .getValue(String.class);


                                if (getPassword.equals(passwordtxt) && getUserType.equals("vehicle")) {
//
//
//                                    if (getUserType == "vehicle") {

                                    Toast.makeText(MainActivity.this, "Successfully Logged in Vehicle Owner", Toast.LENGTH_SHORT).show();


                                    // open mainmanu on success
                                    startActivity(new Intent(MainActivity.this, UserMenu.class));
                                    finish();
                                } else if (getPassword.equals(passwordtxt) && getUserType.equals("parking")) {

                                    Toast.makeText(MainActivity.this, "Successfully Logged in Parking Owner", Toast.LENGTH_SHORT).show();

                                    // Connect to Main manu
                                    startActivity(new Intent(MainActivity.this, ParkingMenu.class));
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }

//                                if (Boolean.parseBoolean(usernametxt))
//
//                                    if (getPassword.equals(passwordtxt)) {
//                                        Toast.makeText(MainActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
//
//                                        startActivity(new Intent(MainActivity.this, CreateLogin.class));
//                                        finish();
//
//                                    } else {
//                                        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
//                                    }
                            } else {
                                Toast.makeText(MainActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


                txtCreateAcc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // open register activity
                        startActivity(new Intent(MainActivity.this, CreateLogin.class));
                    }
                });
            }
        });
    }
}


