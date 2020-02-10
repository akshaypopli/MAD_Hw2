package com.example.homework02;

//    Homework 02
//    MainActivity
//    Neel Solanki and Akshay Popli
//    Assignment Group 14

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_checkout;
    Button btn_clear;
    Button btn_topping;
    ProgressBar progress_top;
    ImageView img_pizza;
    CheckBox delivery_check;
    CharSequence[] items = {"Bacon", "Cheese", "Garlic", "Green Pepper", "Mushroom", "Olives", "Onions", "Red Pepper"};
    ArrayList<String> toppinglist = new ArrayList<String>();


    int total_toppings = 0;
    int childCount;
    GridLayout gridLayout;
    Context context;

    static String TOPPING_KEY = "toppings";
    static String DELIVERY_CHECK = "delivery_check";
    static String TOPPING_LIST = "topping_list";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizza Store");

        btn_checkout = findViewById(R.id.btn_checkout);
        btn_clear = findViewById(R.id.btn_clear);
        btn_topping = findViewById(R.id.btn_topping);
        progress_top = findViewById(R.id.progress_top);
        img_pizza = findViewById(R.id.img_pizza);
        delivery_check = findViewById(R.id.delivery_check);

        gridLayout = findViewById(R.id.gridlayout);
        childCount = gridLayout.getChildCount();
        gridLayout.setColumnCount(5);
        gridLayout.setRowCount(2);
        context = getApplicationContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setTitle("Choose a Topping")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("demo", "Selected" + items[which]);
                        total_toppings++;
                        if (total_toppings == 10){
                            Toast.makeText(getApplicationContext(), "Maximum Capacity!", Toast.LENGTH_SHORT).show();
                        }
                        progress_top.setProgress(total_toppings * 10);


                        if (items[which].equals("Bacon")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.bacon));
                            gridLayout.addView(iv1);
                            toppinglist.add("Bacon");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Bacon");
                                }
                            });
                        } else if (items[which].equals("Cheese")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.cheese));
                            gridLayout.addView(iv1);
                            toppinglist.add("Cheese");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Cheese");
                                }
                            });
                        } else if (items[which].equals("Garlic")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.garlic));
                            gridLayout.addView(iv1);
                            toppinglist.add("Garlic");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Garlic");
                                }
                            });
                        } else if (items[which].equals("Green Pepper")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.green_pepper));
                            gridLayout.addView(iv1);
                            toppinglist.add("Green Pepper");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Green Pepper");
                                }
                            });
                        } else if (items[which].equals("Mushroom")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.mashroom));
                            gridLayout.addView(iv1);
                            toppinglist.add("Mushroom");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Mushroom");
                                }
                            });
                        } else if (items[which].equals("Olives")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.olive));
                            gridLayout.addView(iv1);
                            toppinglist.add("Olives");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Olives");
                                }
                            });
                        } else if (items[which].equals("Onions")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.onion));
                            gridLayout.addView(iv1);
                            toppinglist.add("Onions");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Onions");
                                }
                            });
                        } else if (items[which].equals("Red Pepper")) {
                            final ImageView iv1 = new ImageView(context);
                            iv1.setImageDrawable(getDrawable(R.drawable.red_pepper));
                            gridLayout.addView(iv1);
                            toppinglist.add("Red Pepper");
                            iv1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((ViewGroup) iv1.getParent()).removeView(iv1);
                                    iv1.setVisibility(View.GONE);
                                    total_toppings--;
                                    progress_top.setProgress(total_toppings * 10);
                                    toppinglist.remove("Red Pepper");
                                }
                            });
                        }
                    }
                });
        final AlertDialog alert = builder.create();

        btn_topping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (total_toppings > 9) {
                    Toast.makeText(getApplicationContext(), "Maximum Topping Capacity Reached!", Toast.LENGTH_SHORT).show();
                } else {
                    alert.show();
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_toppings = 0;
                progress_top.setProgress(0);
                delivery_check.setChecked(false);
                gridLayout.removeAllViews();
            }
        });

        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (total_toppings == 0){
                   Toast.makeText(getApplicationContext(), "Please Add Toppings!", Toast.LENGTH_SHORT).show();

               }
               else {
                   Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                   intent.putExtra(TOPPING_KEY, total_toppings);
                   Boolean checkbox1 = delivery_check.isChecked();
                   intent.putExtra(DELIVERY_CHECK, checkbox1);
                   intent.putExtra(TOPPING_LIST, toppinglist);
                   startActivity(intent);
               }
            }
        });
    }
}