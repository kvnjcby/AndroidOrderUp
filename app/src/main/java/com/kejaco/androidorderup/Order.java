package com.kejaco.androidorderup;

/**
 * Created by kejaco on 12/3/17.
 */

public class Order {
    private String custName;
    private float total;
    private String items;
    private int status;

    public Order(String custName, float total, String items, int status) {
        this.custName = custName;
        this.total = total;
        this.items = items;
        this.status = status;
    }

    public String getCustName() {
        return custName;
    }

    public float getTotal() {
        return total;
    }

    public String getItems() {
        return items;
    }

    public int getStatus() {
        return status;
    }
}
