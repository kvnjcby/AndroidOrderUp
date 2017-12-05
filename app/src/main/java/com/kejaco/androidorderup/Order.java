package com.kejaco.androidorderup;

/**
 * Created by kejaco on 12/3/17.
 */

public class Order {
    public String custName;
    public String total;
    public String items;
    public int status;

    public Order(String custName, String total, String items, int status) {
        this.custName = custName;
        this.total = total;
        this.items = items;
        this.status = status;
    }

    public String getCustName() {
        return custName;
    }

    public String getTotal() {
        return total;
    }

    public String getItems() {
        return items;
    }

    public int getStatus() {
        return status;
    }
}
