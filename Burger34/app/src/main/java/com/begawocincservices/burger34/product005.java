package com.begawocincservices.burger34;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class product005 extends AppCompatActivity {

    Button buy_btn;
    TextView productName;
    EditText quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product005);

        productName = findViewById(R.id.productName01);
        quantity = findViewById(R.id.quantity);


//      on click for buy button
        buy_btn = findViewById(R.id.buyBtn);
        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(quantity.getText().toString())){
                    Toast.makeText(product005.this, "Please enter the quantities", Toast.LENGTH_SHORT).show();
                } else {
                    final int productQuantity = Integer.parseInt(quantity.getText().toString());
                    final int price = 45*productQuantity;

                    SharedPreferences sharedPreferences = getSharedPreferences("data_product_05", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("quantity_05", productQuantity);
                    editor.putInt("price_05", price);
                    editor.apply();

//                    Toast.makeText(product005.this, "Your Order is Added to Cart", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(product005.this, ConformOrder.class);
                    startActivity(intent);
                    product005.this.finish();
                }
            }
        });

    }
}