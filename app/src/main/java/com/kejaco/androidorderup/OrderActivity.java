package com.kejaco.androidorderup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    protected static ArrayList<Order> orders = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }
}
