package com.kejaco.androidorderup;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        ArrayList<MenuItem> arrayOfUsers = new ArrayList<MenuItem>();
        // Create the adapter to convert the array to views
        MenuItemAdapter adapter = new MenuItemAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvMenuItem);
        listView.setAdapter(adapter);


        MenuItem newItem = new MenuItem("Nachos", "yummy", "6.00", "/nophoto");
        adapter.add(newItem);
        newItem = new MenuItem("Pizza", "circular", "10.00", "/nophoto");
        adapter.add(newItem);
        newItem = new MenuItem("PBR", "healthy", "4.00", "/nophoto");
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
        adapter.add(newItem);
    }
}
