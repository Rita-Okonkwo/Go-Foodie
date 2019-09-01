package com.project.gofoodie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.project.gofoodie.SnackActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flutterwave.raveandroid.RavePayManager;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SnackViewHolder> {

    ArrayList<String> itemNames;
    ArrayList<String> itemPrice;
    ArrayList<Integer> itemImage;
    ArrayList<String> itemCost;

    Context context;

    public CustomAdapter(Context context, ArrayList<String> itemNames, ArrayList<String> itemPrice, ArrayList<Integer> itemImage, ArrayList<String> itemCost) {
        this.context = context;
        this.itemNames = itemNames;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemCost = itemCost;
    }

    @Override
    public SnackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_menu, parent, false);
        // set the view's size, margins, paddings and layout parameters
        SnackViewHolder vh = new SnackViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(final SnackViewHolder holder, final int position) {
        // set the data in items
        holder.itemName.setText(itemNames.get(position));
        holder.itemImage.setImageResource(itemImage.get(position));
        holder.itemPrice.setText(itemPrice.get(position));
        holder.itemCost.setText(itemCost.get(position));
        holder.buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CheckoutActivity.class);
                intent.putExtra("itemPrice", itemPrice.get(position))
                .putExtra("itemCost", itemCost.get(position));
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return itemNames.size();
    }

    public class SnackViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView itemName;
        CircularImageView itemImage;
        TextView itemPrice;
        TextView itemCost;
        Button buyNow;

        public SnackViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            itemPrice = (TextView) itemView.findViewById(R.id.itemPrice);
            itemImage = (CircularImageView) itemView.findViewById(R.id.itemImage);
            itemCost = (TextView) itemView.findViewById(R.id.itemCost);
            buyNow = (Button) itemView.findViewById(R.id.buyNow);

        }
    }


}

