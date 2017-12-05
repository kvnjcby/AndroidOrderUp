package com.kejaco.androidorderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kejaco on 12/3/17.
 */

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {
    public MenuItemAdapter(Context context, ArrayList<MenuItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MenuItem item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_menuitem, parent, false);
        }

        Button rightBtn = (Button) convertView.findViewById(R.id.rightBtn);
        // Cache user object inside the button using `setTag`
        rightBtn.setTag(item);
        // Attach the click event handler
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Access user from within the tag
                MenuItem item = (MenuItem) view.getTag();
                Toast.makeText(getContext(), "Hi!"+item.getPrice(), Toast.LENGTH_SHORT).show();
            }
        });

        // Lookup view for data population
        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        TextView itemDesc = (TextView) convertView.findViewById(R.id.itemDesc);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.itemPrice);

        // Populate the data into the template view using the data object
        itemName.setText(item.name);
        itemDesc.setText(item.desc);
        itemPrice.setText("$"+item.price);
        // Return the completed view to render on screen
        return convertView;
    }
}
