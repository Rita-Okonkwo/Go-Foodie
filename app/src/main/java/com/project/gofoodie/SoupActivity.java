package com.project.gofoodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.flutterwave.raveandroid.RavePayManager;

import java.util.ArrayList;
import java.util.Arrays;


public class SoupActivity extends AppCompatActivity {

    ArrayList<String> itemNames = new ArrayList<>(Arrays.asList("Ewedu", "Afang", "Veg. Soup", "Ogbono","Egusi", "Fish Stew","Chicken Stew","White Soup"));
    ArrayList<String> itemPrice = new ArrayList<>(Arrays.asList("1000","1000","1000","1500","1550","1450","1350","800"));
    ArrayList<Integer> itemImage = new ArrayList<>(Arrays.asList(R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image));
    ArrayList<String> itemCost = new ArrayList<>(Arrays.asList("1000","1000","1000","1500","1550","1450","1350","800"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup);
        // getting the reference of RecyclerView
        RecyclerView soupView = (RecyclerView) findViewById(R.id.soupView);
        // setting a GridLayoutManager with 2 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        soupView.setLayoutManager(gridLayoutManager); // setting LayoutManager to RecyclerView
        //  calling the constructor of CustomAdapter to send the reference and data to Adapter
        final CustomAdapter customAdapter = new CustomAdapter(SoupActivity.this, itemNames,itemPrice,itemImage,itemCost);
        soupView.setAdapter(customAdapter); // setting the Adapter to RecyclerView
    }

}
