package com.kejaco.androidorderup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kejaco on 12/3/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "RestaurantDB";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MENU_TABLE = "CREATE TABLE menu ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, "+
                "desc TEXT, "+
                "price REAL, "+
                "photoPath TEXT )";
        db.execSQL(CREATE_MENU_TABLE);

        String CREATE_ORDERS_TABLE = "CREATE TABLE orders ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "custName TEXT, "+
                "total REAL, "+
                "items TEXT, "+
                "status INT )";

        db.execSQL(CREATE_MENU_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS menu");
        db.execSQL("DROP TABLE IF EXISTS orders");

        this.onCreate(db);
    }



    private static final String TABLE_MENU = "menu";
    private static final String TABLE_ORDERS = "orders";

    private static final String[] MENU_COLUMNS = {"id", "name", "desc", "price", "photoPath"};
    private static final String[] ORDERS_COLUMNS = {"id", "custName", "total", "items", "status"};


    public void addMenuItem(MenuItem item){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", item.getName());
        values.put("desc", item.getDesc());
        values.put("price", item.getPrice());
        values.put("photoPath", item.getPhotoPath());

        db.insert(TABLE_MENU, null, values);

        db.close();
    }

    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> items = new LinkedList<AppPhoto>();

        String query = "SELECT  * FROM " + TABLE_MENU;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        MenuItem photo = null;
        if (cursor.moveToFirst()) {
            do {
                item = new MenuItem(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

                items.add(item);
            } while (cursor.moveToNext());
        }

        return items;
    }

    public void addOrder(Order order){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("custName", order.getCustName());
        values.put("total", order.getTotal());
        values.put("items", order.getItems());
        values.put("status", order.getStatus());

        db.insert(TABLE_ORDERS, null, values);

        db.close();
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new LinkedList<Order>();

        String query = "SELECT  * FROM " + TABLE_ORDERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Order order = null;
        if (cursor.moveToFirst()) {
            do {
                order = new Order(cursor.getString(1), cursor.getString(2), cursor.getString(3));

                orders.add(order);
            } while (cursor.moveToNext());
        }

        return orders;
    }

}
