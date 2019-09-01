package com.project.gofoodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.flutterwave.raveandroid.RavePayManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.UUID;

public class CheckoutActivity extends AppCompatActivity {

    private TextView itemPrice;
    private TextView itemCost;
    private String price;
    final String publicKey = "FLWPUBK_TEST-22b228a9a67e55b0ae4a5208760d776f-X";
    final String encryptionKey = "FLWSECK_TEST81b6971aacc5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        itemPrice = (TextView) findViewById(R.id.itemPrice);
        itemCost = (TextView) findViewById(R.id.itemCost);
        TextView mName = (TextView) findViewById(R.id.name);
        TextView mAddress = (TextView) findViewById(R.id.address);
        TextView mPhone = (TextView) findViewById(R.id.phone);
        TextView totalCost = (TextView) findViewById(R.id.TotalPrice);
        Intent intent = getIntent();
        String price = getIntent().getExtras().getString("itemPrice");
        this.price = price;
        itemPrice.setText(price);
        final Double cost = Double.parseDouble(price);
        final Double fCost = cost + 200;
        final String totalC = Double.toString(fCost);
        totalCost.setText(totalC);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String email = user.getEmail();
        mAddress.setText(email);
        final String name = user.getDisplayName();
        mName.setText(name);
        final String phone = user.getPhoneNumber();
        mPhone.setText(phone);


        Button button = (Button) findViewById(R.id.paybtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RavePayManager(CheckoutActivity.this)
                        .setAmount(fCost)
                        .setCountry("NG")
                        .setCurrency("NGN")
                        .setEmail(email)
                        .setfName(name)
                        .setlName(name)
                        .setNarration("Narration")
                        .setPublicKey(publicKey)
                        .setEncryptionKey(encryptionKey)
                        .showStagingLabel(false)
                        .shouldDisplayFee(true)
                        .setTxRef("Transaction reference")
                        .acceptCardPayments(true)
                        .acceptMpesaPayments(false)
                        .acceptGHMobileMoneyPayments(false)
                        .acceptAccountPayments(true)
                        .initialize();
            }
        });

        }

}
