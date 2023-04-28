package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountsParking extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://parkingmapper-680fd-default-rtdb.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_parking);

        final EditText txtParkName = (EditText) findViewById(R.id.txtParkName);
        final EditText txtPLocation = (EditText) findViewById(R.id.txtParkLocation);
        final EditText txtContactNum = (EditText) findViewById(R.id.txtContactNum);
        final EditText txtparkLots = (EditText) findViewById(R.id.txtparkingLots);
        final EditText txtOpenTime = (EditText) findViewById(R.id.txtOpenTime);
        final EditText txtCloseTime = (EditText) findViewById(R.id.txtCloseTime);

        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
        final Button btnUpdate = (Button) findViewById(R.id.btnUpdate);

        final RadioButton rdbMini = (RadioButton)  findViewById(R.id.radio_mini);
        final RadioButton rdbMedium = (RadioButton)  findViewById(R.id.radio_medium);
        final RadioButton rdbLarge = (RadioButton)  findViewById(R.id.radio_large);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get data from EditTexts into String variable
                final String parkNametxt = txtParkName.getText().toString();
                final String parkLocationtxt = txtPLocation.getText().toString();
                final String contactNumtxt = txtContactNum.getText().toString();
                final String parkingLotstxt = txtparkLots.getText().toString();
                final String openTimetxt = txtOpenTime.getText().toString();
                final String closeTimetxt = txtCloseTime.getText().toString();

                final String mini = rdbMini.getText().toString();
                final String medium = rdbMedium.getText().toString();
                final String large = rdbLarge.getText().toString();

                // creat if user fill all the fields before sending data to firebase
                if (parkNametxt.isEmpty() || parkLocationtxt.isEmpty() || contactNumtxt.isEmpty() || parkingLotstxt.isEmpty() || openTimetxt.isEmpty() || closeTimetxt.isEmpty()) {
                    Toast.makeText(AccountsParking.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

                } else {

                    databaseReference.child("Parking Lots").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            // check if user is not registerd before
                            if (snapshot.hasChild(parkNametxt)) {
                                Toast.makeText(AccountsParking.this, "User Name is alresdy registered", Toast.LENGTH_SHORT).show();

                            }else if (snapshot.hasChild(parkLocationtxt)) {
                                Toast.makeText(AccountsParking.this, "Parking location is alresdy registered", Toast.LENGTH_SHORT).show();

                            } else {
                                // sending data to firebase Realtime Database.
                                // we are using username as unique of every user.
                                // so all the other details of user comes to under username
                                databaseReference.child("Parking Lots").child(parkNametxt).child("user name").setValue(parkNametxt);
                                databaseReference.child("Parking Lots").child(parkNametxt).child("park location").setValue(parkLocationtxt);
                                databaseReference.child("Parking Lots").child(parkNametxt).child("contact").setValue(contactNumtxt);
                                databaseReference.child("Parking Lots").child(parkNametxt).child("parking lots").setValue(parkingLotstxt);
                                databaseReference.child("Parking Lots").child(parkNametxt).child("open time").setValue(openTimetxt);
                                databaseReference.child("Parking Lots").child(parkNametxt).child("close time").setValue(closeTimetxt);

                                if (rdbMini.isChecked()){
                                    databaseReference.child("Parking Lots").child(parkNametxt).child("type").setValue("mini");
                                }else if (rdbMedium.isChecked()){
                                    databaseReference.child("Parking Lots").child(parkNametxt).child("type").setValue("medium");
                                }else {
                                    databaseReference.child("Parking Lots").child(parkNametxt).child("type").setValue("large");
                                }

                                // show a success message then finish the activity
                                Toast.makeText(AccountsParking.this, "Your parking registered successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AccountsParking.this, ParkingMenu.class));
//                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });
    }
}