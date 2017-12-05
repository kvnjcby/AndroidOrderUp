package com.kejaco.androidorderup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    protected static ArrayList<Order> orders = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Create the adapter to convert the array to views
        OrderAdapter adapter = new OrderAdapter(this, orders);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvMenuItem);
        listView.setAdapter(adapter);


        Order newOrder = new Order("Alfredo Guantanamo", "$42.24", "Nachos, Cheese, PBR", 2);
        orders.add(newOrder);
        newOrder = new Order("Shannon Eggins", "$16.69", "PBR, PBR, PBR", 1);
        orders.add(newOrder);
        newOrder = new Order("Terry Yaki", "$72.91", "Cheese, Pizza, Fruit loops, PBR, PBR", 1);
        orders.add(newOrder);


        TextView orderTitle = (TextView) findViewById(R.id.orderTitle);
        orderTitle.setText(orders.size()+" Orders");
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }
}
