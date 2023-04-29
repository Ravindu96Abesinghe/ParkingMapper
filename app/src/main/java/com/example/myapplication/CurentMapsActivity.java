package com.example.myapplication;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.SearchView;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.databinding.ActivityCurentMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

//
//import androidx.fragment.app.FragmentActivity;
//
//import android.os.Bundle;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.example.myapplication.databinding.ActivityCurentMapsBinding;
//
//import androidx.appcompat.app.AppCompatActivity;
//
public class CurentMapsActivity extends FragmentActivity implements OnMapReadyCallback {

//    private GoogleMap mMap;
//    private ActivityCurentMapsBinding binding;
//    private SearchView searchView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityCurentMapsBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//        // Get reference to the search view
//        searchView = findViewById(R.id.searchView);
//
//        // Set listener for search view
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // Get location coordinates using Geocoding API
//                LatLng location = getLocationFromAddress(query);
//
//                // Add a marker for the searched location
//                mMap.addMarker(new MarkerOptions().position(location).title(query));
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
//
//    private LatLng getLocationFromAddress(String address) {
//        Geocoder geocoder = new Geocoder(this);
//        List<Address> addressList;
//        LatLng location = null;
//        try {
//            addressList = geocoder.getFromLocationName(address, 1);
//            if (addressList != null && ((List<?>) addressList).size() > 0) {
//                Address addr = addressList.get(0);
//                location = new LatLng(addr.getLatitude(), addr.getLongitude());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return location;
//    }





    private GoogleMap mMap;
    private ActivityCurentMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCurentMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Moratuwa, Sri Lanka and move the camera
        LatLng moratuwa = new LatLng(6.7730, 79.8816);
        mMap.addMarker(new MarkerOptions().position(moratuwa).title("Marker in Moratuwa, Sri Lanka"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(moratuwa));
    }
}