package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ParkingMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_menu);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drower_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyParkingFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_parking);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_parking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyParkingFragment()).commit();
                // open Mmyparkingfragment activity
//                startActivity(new Intent(ParkingMenu.this, MyParkingFragment.class));
                break;

            case R.id.nav_reservation:
//                startActivity(new Intent(ParkingMenu.this, MyReservationFragment.class));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyReservationFragment()).commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AccountSettingsFragment()).commit();
                break;

            case R.id.nav_favorites:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyFavoritesFragment()).commit();
                break;

            case R.id.nav_payments:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaymentsFragment()).commit();
                break;

            case R.id.nav_signout:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();

                // back login activity
                startActivity(new Intent(ParkingMenu.this, MainActivity.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}