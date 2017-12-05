package com.kejaco.androidorderup;

/**
 * Created by kejaco on 12/3/17.
 */

public class MenuItem {
    public String name;
    public String desc;
    public String price;
    public String photoPath;

    public MenuItem(String name, String desc, String price, String photoPath) {
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

    public String getPrice() {
        return price;
    }

    public String getPhotoPath() {
        return photoPath;
    }
}
