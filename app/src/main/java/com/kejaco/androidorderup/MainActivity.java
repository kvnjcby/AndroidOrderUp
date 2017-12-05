package com.kejaco.androidorderup;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_orders);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
