package com.example.homework02;

//    Homework 02
//    OrderActivity
//    Neel Solanki and Akshay Popli
//    Assignment Group 14

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    TextView order_topping2;
    TextView order_topping3;
    TextView order_delivery2;
    TextView order_total2;
    Button btn_finish;


    double toppings;
    Boolean delivery;

    ArrayList<String> toppinglist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Pizza Store");

        order_topping2 = findViewById(R.id.order_topping2);
        order_topping3 = findViewById(R.id.order_topping3);
        order_delivery2 = findViewById(R.id.order_delivery2);
        order_total2 = findViewById(R.id.order_total2);
        btn_finish = findViewById(R.id.btn_finish);

        if (getIntent() != null && getIntent().getExtras() != null){
            toppings = getIntent().getExtras().getInt(MainActivity.TOPPING_KEY);
            delivery = getIntent().getExtras().getBoolean(MainActivity.DELIVERY_CHECK);
            toppinglist = getIntent().getExtras().getStringArrayList(MainActivity.TOPPING_LIST);
            toppings = toppings * 1.50;
            Log.d("toppings: ", String.valueOf(toppings));
            order_topping3.setText(String.valueOf(toppinglist).replace("[", "").replace("]", ""));
            order_topping2.setText("$" + toppings + "0");
            if (delivery == true){
                order_delivery2.setText("$4.00");
                order_total2.setText(Html.fromHtml("<u>$" + (toppings + 6.50 + 4) + "0</u>"));
            }
            else {
                order_delivery2.setText("$0.00");
                order_total2.setText(Html.fromHtml("<u>$" + (toppings + 6.50) + "0</u>"));
            }

            btn_finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(OrderActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
