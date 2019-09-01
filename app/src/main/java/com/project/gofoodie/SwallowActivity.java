package com.project.gofoodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class SwallowActivity extends AppCompatActivity {

    ArrayList<String> itemNames = new ArrayList<>(Arrays.asList("Egwusi", "Oha", "Okro", "Olugbo","Eba", "Garri","Fufu","Semovita"));
    ArrayList<String> itemPrice = new ArrayList<>(Arrays.asList("50","150","200","150","550","450","350","2500"));
    ArrayList<Integer> itemImage = new ArrayList<>(Arrays.asList(R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image));
    ArrayList<String> itemCost = new ArrayList<>(Arrays.asList("50","150","200","150","550","450","350","2500"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swallow);


        // getting the reference of RecyclerView
        RecyclerView swallowView = (RecyclerView) findViewById(R.id.swallowView);
        // setting a GridLayoutManager with 2 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        swallowView.setLayoutManager(gridLayoutManager); // setting LayoutManager to RecyclerView
        //  calling the constructor of CustomAdapter to send the reference and data to Adapter
        final CustomAdapter customAdapter = new CustomAdapter(SwallowActivity.this, itemNames,itemPrice,itemImage,itemCost);
        swallowView.setAdapter(customAdapter); // setting the Adapter to RecyclerView
    }
}
