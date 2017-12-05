package com.kejaco.androidorderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        orderTotal.setText(order.total);
        orderItems.setText(order.items);
        // Return the completed view to render on screen
        return convertView;
    }
}
