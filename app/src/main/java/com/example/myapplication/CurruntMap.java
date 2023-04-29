//package com.example.myapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.os.Bundle;
//import android.view.WindowManager;
//import android.widget.Toast;
//
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.karumi.dexter.Dexter;
//import com.karumi.dexter.PermissionToken;
//import com.karumi.dexter.listener.PermissionDeniedResponse;
//import com.karumi.dexter.listener.PermissionGrantedResponse;
//import com.karumi.dexter.listener.PermissionRequest;
//import com.karumi.dexter.listener.single.PermissionListener;
//
//public class CurruntMap extends AppCompatActivity {
//
//    SupportMapFragment supportMapFragment;
//    FusedLocationProviderClient fusedLocationProviderClient;
//
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_currunt_map);
////        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
////
////        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.btnCLocation);
////        fusedLocationProviderClient = (FusedLocationProviderClient) LocationServices.getFusedLocationProviderClient(this);
////
////        Dexter.withContext(getApplicationContext()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
////                .withListener(new PermissionListener() {
////                    @Override
////                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
////                        getCurrentLocation();
////
////                    }
////
////                    @Override
////                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
////
////                    }
////
////                    @Override
////                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
////                        permissionToken.continuePermissionRequest();
////
////                    }
////                }).check();
////    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_currunt_map);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//
//        Dexter.withContext(getApplicationContext()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//                .withListener(new PermissionListener() {
//                    @Override
//                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                        getCurrentLocation();
//                    }
//
//                    @Override
//                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//                        permissionToken.continuePermissionRequest();
//                    }
//                }).check();
//    }
//
//
//    public void getCurrentLocation() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        Task<Location> task = fusedLocationProviderClient.getLastLocation();
//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//
//                supportMapFragment.getMapAsync(new OnMapReadyCallback() {
//                    @Override
//                    public void onMapReady(@NonNull GoogleMap googleMap) {
//                        if(location != null){
//                            LatLng lating = new LatLng(location.getLatitude(),location.getLongitude());
//                            MarkerOptions markerOptions = new MarkerOptions().position(lating).title("Current Location");
//                            googleMap.addMarker(markerOptions);
//                            googleMap.animateCamera((CameraUpdateFactory.newLatLngZoom(lating,15)));
//
//                        }else{
//                            Toast.makeText(CurruntMap.this,"Please on Location App Permission",Toast.LENGTH_SHORT);
//                        }
//                    }
//                });
//            }
//        });
//    }
//}