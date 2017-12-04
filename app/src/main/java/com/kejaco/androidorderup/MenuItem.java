package com.kejaco.androidorderup;

/**
 * Created by kejaco on 12/3/17.
 */

public class MenuItem {
    private String name;
    private String desc;
    private float price;
    private String photoPath;

    public MenuItem(String name, String desc, float price, String photoPath) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public float getPrice() {
        return price;
    }

    public String getPhotoPath() {
        return photoPath;
    }
}
