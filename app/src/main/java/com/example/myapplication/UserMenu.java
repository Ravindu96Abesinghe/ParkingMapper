package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class UserMenu extends AppCompatActivity {

    public EditText txtSearchLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

//        EditText txtSearchLocation = (EditText) findViewById(R.id.txt);
    }
}