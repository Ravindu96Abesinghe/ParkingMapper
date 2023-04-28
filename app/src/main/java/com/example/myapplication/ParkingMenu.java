package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.razorpay.Checkout;

import org.json.JSONObject;

public class ParkingMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_parking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();

        if (item_id==R.id.reservations){
            Toast.makeText(this, "res", Toast.LENGTH_SHORT).show();
        }

        else if (item_id==R.id.account){
            Toast.makeText(this, "acc", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ParkingMenu.this, AccountsParking.class));
        }

        else if (item_id==R.id.about){
            Toast.makeText(this, "Abo", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ParkingMenu.this, About_us.class));
        }

        else if (item_id==R.id.signout){
            Toast.makeText(this, "siOUT", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ParkingMenu.this, MainActivity.class));
        }

        return true;
    }

}