package com.kejaco.androidorderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by kejaco on 12/3/17.
 */

public class OrderAdapter extends ArrayAdapter<Order> {
    public OrderAdapter(Context context, ArrayList<Order> orders) {
        super(context, 0, orders);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Order order = getItem(position);

        /*Button rightBtn = (Button) convertView.findViewById(R.id.rightBtn);
        // Cache user object inside the button using `setTag`
        rightBtn.setTag(order);
        // Attach the click event handler
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Access user from within the tag
                Order order = (Order) view.getTag();
                Toast.makeText(getContext(), "Hi!", Toast.LENGTH_SHORT).show();
            }
        });*/


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_order, parent, false);
        }
        // Lookup view for data population
        TextView orderCustName = (TextView) convertView.findViewById(R.id.orderCustName);
        TextView orderTotal = (TextView) convertView.findViewById(R.id.orderTotal);
        TextView orderItems = (TextView) convertView.findViewById(R.id.orderItems);

        // Populate the data into the template view using the data object
        orderCustName.setText(order.custName);
        NumberFormat cF = NumberFormat.getCurrencyInstance();
        orderTotal.setText(order.getTotal());
        orderItems.setText(order.items);


        if (order.getStatus() == 0) {
            convertView.setBackgroundColor(0xCCFF7575);
        } else if (order.getStatus() == 1) {
            convertView.setBackgroundColor(0xCCFFE177);
        } else {
            convertView.setBackgroundColor(0xCC7BE86F);
        }


        // Return the completed view to render on screen
        return convertView;
    }
}
