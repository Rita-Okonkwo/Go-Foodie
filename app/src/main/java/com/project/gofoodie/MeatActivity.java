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


public class MeatActivity extends AppCompatActivity {

    ArrayList<String> itemNames = new ArrayList<>(Arrays.asList("Cow", "Goat", "Fish", "Pork","Chicken", "Turkey","Crab","Pomo"));
    ArrayList<String> itemPrice = new ArrayList<>(Arrays.asList("600","700","300","900","1000","1150","350","300"));
    ArrayList<Integer> itemImage = new ArrayList<>(Arrays.asList(R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image));
    ArrayList<String> itemCost = new ArrayList<>(Arrays.asList("600","700","300","900","1000","1150","350","300"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);
        // getting the reference of RecyclerView
        RecyclerView meatView = (RecyclerView) findViewById(R.id.meatView);
        // setting a GridLayoutManager with 2 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        meatView.setLayoutManager(gridLayoutManager); // setting LayoutManager to RecyclerView
        //  calling the constructor of CustomAdapter to send the reference and data to Adapter
        final CustomAdapter customAdapter = new CustomAdapter(MeatActivity.this, itemNames,itemPrice,itemImage,itemCost);
        meatView.setAdapter(customAdapter); // setting the Adapter to RecyclerView
    }

}
