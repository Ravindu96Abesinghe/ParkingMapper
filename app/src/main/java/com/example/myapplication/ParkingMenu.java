package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

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
        else if (item_id==R.id.favorites){
            Toast.makeText(this, "Fav", Toast.LENGTH_SHORT).show();
        }
        else if (item_id==R.id.payments){
            Toast.makeText(this, "pay", Toast.LENGTH_SHORT).show();
        }
        else if (item_id==R.id.account){
            Toast.makeText(this, "acc", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ParkingMenu.this, AccountsParking.class));
        }
        else if (item_id==R.id.about){
            Toast.makeText(this, "Abo", Toast.LENGTH_SHORT).show();
        }
        else if (item_id==R.id.signout){
            Toast.makeText(this, "siOUT", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

}