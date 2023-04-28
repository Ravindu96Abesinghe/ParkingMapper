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

public class VehicleSettings extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://parkingmapper-680fd-default-rtdb.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_settings);

        final EditText txtVehicleNum = (EditText) findViewById(R.id.txtVehicleNum);
        final EditText txtVContactNumV = (EditText) findViewById(R.id.txtVContactNumber);

        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
        final Button btnUpdate = (Button) findViewById(R.id.btnUpdate);

        final RadioButton rdbBike = (RadioButton)  findViewById(R.id.radio_bike);
        final RadioButton rdbCar = (RadioButton)  findViewById(R.id.radio_car);
        final RadioButton rdbThreeweel = (RadioButton)  findViewById(R.id.radio_threeweel);
        final RadioButton rdbVan = (RadioButton)  findViewById(R.id.radio_van);
        final RadioButton rdbBus = (RadioButton)  findViewById(R.id.radio_bus);
        final RadioButton rdbLorry = (RadioButton)  findViewById(R.id.radio_lorry);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get data from EditTexts into String variable
                final String vehicleNumtxt = txtVehicleNum.getText().toString();
                final String contactNumtx = txtVContactNumV.getText().toString();

                final String bike = rdbBike.getText().toString();
                final String car = rdbCar.getText().toString();
                final String threeweel = rdbThreeweel.getText().toString();
                final String van = rdbVan.getText().toString();
                final String bus = rdbBus.getText().toString();
                final String lorry = rdbLorry.getText().toString();

                // creat if user fill all the fields before sending data to firebase
                if (vehicleNumtxt.isEmpty() || contactNumtx.isEmpty()) {
                    Toast.makeText(VehicleSettings.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

                } else {

                    databaseReference.child("Vehicles").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            // check if user is not registerd before
                            if (snapshot.hasChild(vehicleNumtxt)) {
                                Toast.makeText(VehicleSettings.this, "User Name is alresdy registered", Toast.LENGTH_SHORT).show();

                            }else {
                                // sending data to firebase Realtime Database.
                                // we are using username as unique of every user.
                                // so all the other details of user comes to under username
                                databaseReference.child("Vehicles").child(vehicleNumtxt).child("vehicle number").setValue(vehicleNumtxt);
                                databaseReference.child("Vehicles").child(vehicleNumtxt).child("contact").setValue(contactNumtx);

                                if (rdbBike.isChecked()){
                                    databaseReference.child("Vehicles").child(vehicleNumtxt).child("type").setValue("bike");
                                }else if (rdbCar.isChecked()){
                                    databaseReference.child("Vehicles").child(vehicleNumtxt).child("type").setValue("car");
                                }else if (rdbThreeweel.isChecked()){
                                    databaseReference.child("Vehicles").child(vehicleNumtxt).child("type").setValue("three weel");
                                }else if (rdbVan.isChecked()){
                                    databaseReference.child("Vehicles").child(vehicleNumtxt).child("type").setValue("van");
                                }else if (rdbBus.isChecked()){
                                    databaseReference.child("Vehicles").child(vehicleNumtxt).child("type").setValue("bus");
                                }else {
                                    databaseReference.child("Vehicles").child(vehicleNumtxt).child("type").setValue("lorry");
                                }

                                // show a success message then finish the activity
                                Toast.makeText(VehicleSettings.this, "Your vehicle registered successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(VehicleSettings.this, UserMenu.class));
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