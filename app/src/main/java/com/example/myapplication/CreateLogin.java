package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateLogin extends AppCompatActivity {

//    DatabaseReference databaseReference;

    //create object of DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://parkingmapper-680fd-default-rtdb.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_login);

        final EditText txtUsername = (EditText) findViewById(R.id.txtCreateUsername);
        final EditText txtEmail = (EditText) findViewById(R.id.txtCreateEmail);
        final EditText txtPassword = (EditText) findViewById(R.id.txtCreatePassword);
        final EditText txtConfirmPassword = (EditText) findViewById(R.id.txtCreateConfirmPassword);

        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
        final TextView txtLoginNow = (TextView) findViewById(R.id.txtLoginNow);
        final RadioButton rdbVehicle = (RadioButton)  findViewById(R.id.radio_vehicle);
        final RadioButton rdbParking = (RadioButton)  findViewById(R.id.radio_parking);

         btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get data from EditTexts into String variable
                final String usernametxt = txtUsername.getText().toString();
                final String emailtxt = txtEmail.getText().toString();
                final String passwordtxt = txtPassword.getText().toString();
                final String confirmpasswordtxt = txtConfirmPassword.getText().toString();

                final String vehicle = rdbVehicle.getText().toString();
                final String parking = rdbParking.getText().toString();

                // creat if user fill all the fields before sending data to firebase
                if (usernametxt.isEmpty() || emailtxt.isEmpty() || passwordtxt.isEmpty() || confirmpasswordtxt.isEmpty()) {
                    Toast.makeText(CreateLogin.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                // check if password are matching with each other
                // if not matching with each other then show a toast message
                else if (!passwordtxt.equals(confirmpasswordtxt)) {
                    Toast.makeText(CreateLogin.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                } else {

                    databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            // check if user is not registerd before
                            if (snapshot.hasChild(usernametxt)) {
                                Toast.makeText(CreateLogin.this, "User is alresdy registered", Toast.LENGTH_SHORT).show();

//                            }else if (snapshot.hasChild(emailtxt)) {
//                                Toast.makeText(CreateLogin.this, "Email is alresdy registered", Toast.LENGTH_SHORT).show();

                            } else {
                                // sending data to firebase Realtime Database.
                                // we are using username as unique of every user.
                                // so all the other details of user comes to under username
                                databaseReference.child("User").child(usernametxt).child("username").setValue(usernametxt);
                                databaseReference.child("User").child(usernametxt).child("password").setValue(passwordtxt);
                                databaseReference.child("User").child(usernametxt).child("email").setValue(emailtxt);

                                if (rdbVehicle.isChecked()){
                                    databaseReference.child("User").child(usernametxt).child("type").setValue("vehicle");
                                }else {
                                    databaseReference.child("User").child(usernametxt).child("type").setValue("parking");
                                }

                                // show a success message then finish the activity
                                Toast.makeText(CreateLogin.this, "User registered successfully.", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });

        txtLoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


//    public void createUserAccount (View v) {
//        Intent createUserAccountActivity = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(createUserAccountActivity);
//    }



/*
    public void createUserAccount(View view) {
        EditText txtUsername = (EditText) findViewById(R.id.txtCreateUsername);
        EditText txtEmail = (EditText) findViewById(R.id.txtCreateEmail);
        EditText txtPassword = (EditText) findViewById(R.id.txtCreatePassword);
        EditText txtConfirmPassword = (EditText) findViewById(R.id.txtCreateConfirmPassword);

        String username = txtUsername.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String confirmpassword = txtConfirmPassword.getText().toString();

        SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("confirmpassword", confirmpassword);
        editor.commit();

        if (txtPassword.getText().toString().matches(password) && txtConfirmPassword.getText().toString().matches(confirmpassword)){
            Toast.makeText(getApplicationContext(), "Passwords are matched", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Please Enter Same Password", Toast.LENGTH_LONG).show();
        }
    }

    public void createUser (View v) {
        Intent loginActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(loginActivity);
    }
}


     */