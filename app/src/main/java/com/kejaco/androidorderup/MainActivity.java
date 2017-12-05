package com.kejaco.androidorderup;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected float orderTotal;
    protected ArrayList<String> orderItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Construct the data source
        ArrayList<MenuItem> arrayOfMenuItems = new ArrayList<MenuItem>();
        // Create the adapter to convert the array to views
        MenuItemAdapter adapter = new MenuItemAdapter(this, arrayOfMenuItems);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvMenuItem);
        listView.setAdapter(adapter);


        MenuItem newItem = new MenuItem("Nachos", "yummy", "6.01", "/nophoto");
        adapter.add(newItem);
        newItem = new MenuItem("Pizza", "circular", "10.10", "/nophoto");
        adapter.add(newItem);
        newItem = new MenuItem("PBR", "healthy", "4.02", "/nophoto");
        adapter.add(newItem);
        newItem = new MenuItem("Cheese", "milk + bacteria = cheese", "33.33", "/nophoto");
        adapter.add(newItem);
        newItem = new MenuItem("Fruit loops", "sweetened, fruit-flavored breakfast cereal", "9.99", "/nophoto");
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
    }

    public void addToOrder(String name, String price) {
        float cost = Float.parseFloat(price);
        orderTotal = orderTotal + cost;

        orderItems.add(name);

        TextView totalView = (TextView) findViewById(R.id.orderTotal);
        NumberFormat cF = NumberFormat.getCurrencyInstance();
        totalView.setText(cF.format(orderTotal));
    }

    public void placeOrder(View v) {
        EditText nameField = (EditText) findViewById(R.id.custName);
        String custName = nameField.getText().toString();

        String items = "";

        for(String item : orderItems) {
            if (items.length() > 0) {
                items = items + ", ";
            }
            items = items + item;
        }


        Order newOrder = new Order(custName, orderTotal+"", items, 0);
        OrderActivity.addOrder(newOrder);

        orderTotal = 0;
        orderItems.clear();
        nameField.setText("");

        TextView totalView = (TextView) findViewById(R.id.orderTotal);
        totalView.setText("$0.00");

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Order Placed!");
        alertDialog.setMessage("Congratulations! Your order has been placed. Please pay.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void viewOrders(View v) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(intent);
    }
}
