package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.view.View;

import java.util.List;

public class MyVehicleListAdapter extends ArrayAdapter {
    private Activity mContext;
    List<MyVehicles> myVehiclesList;

    public MyVehicleListAdapter(Activity mContext, List<MyVehicles> myVehiclesList){
        super(mContext,R.layout.activity_my_vehicles,myVehiclesList);
        this.mContext = mContext;
        this.myVehiclesList = myVehiclesList;
    }

    @NonNull
    public android.view.View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        android.view.View listItemView = inflater.inflate(R.layout.activity_my_vehicles,null,true);

        TextView txtVehicleNum = listItemView.findViewById(R.id.txtVehicleNum);
        TextView txtVehType = listItemView.findViewById(R.id.txtVehType);
        TextView txtContactNum = listItemView.findViewById(R.id.txtContactNum);

        MyVehicles myVehicles = myVehiclesList.get(position);

        txtVehicleNum.setText(myVehicles.getVehicleNumber());
        txtVehType.setText(myVehicles.getType());
        txtContactNum.setText(myVehicles.getContact());

        return listItemView;
    }

}