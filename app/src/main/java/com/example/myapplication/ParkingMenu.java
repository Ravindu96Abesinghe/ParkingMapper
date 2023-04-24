package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ParkingMenu extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
//    LinearLayout parking, settings;

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_menu);

//        drawerLayout = findViewById(R.id.drawerLayout);
////        menu = findViewById(R.id.menu);
//        navigationView = findViewById(R.id.navigationView);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_open, R.string.menu_close);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()) {
//                    case R.id.nav_park:
//                        Log.i("Menu_Drawer_Tag", "Parking is clicked");
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                    case R.id.nav_acc:
//                        Log.i("Menu_Drawer_Tag", "Account is clicked");
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                }
//
//                return true;
//            }
//        });


    }


//        parking = findViewById(R.id.parking);
//        settings = findViewById(R.id.settings);
//
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDrawer(drawerLayout);
//            }
//        });
//        parking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                redirectActivity(ParkingMenu.this, ParkingMenu.class);
//            }
//        });
//        settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                redirectActivity(ParkingMenu.this, AccountSettings.class);
//            }
//        });
//
//    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}

    //
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawerLayout = findViewById(R.id.drower_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyParkingFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_parking);
//        }
//    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_parking:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyParkingFragment()).commit();
//                // open Mmyparkingfragment activity
////                startActivity(new Intent(ParkingMenu.this, MyParkingFragment.class));
//                break;
//
//            case R.id.nav_reservation:
////                startActivity(new Intent(ParkingMenu.this, MyReservationFragment.class));
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyReservationFragment()).commit();
//                break;
//
//            case R.id.nav_settings:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AccountSettingsFragment()).commit();
//                break;
//
//            case R.id.nav_favorites:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyFavoritesFragment()).commit();
//                break;
//
//            case R.id.nav_payments:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaymentsFragment()).commit();
//                break;
//
//            case R.id.nav_signout:
//                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
//
//                // back login activity
//                startActivity(new Intent(ParkingMenu.this, MainActivity.class));
//                break;
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//}