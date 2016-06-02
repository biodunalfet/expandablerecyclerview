package com.sjrnr.hamza.expandablerecyclerview;

/**
 * Created by Hamza Fetuga on 5/31/2016.
 */
public class GenericFoodItem {

    private String id;
    private String name;
    private boolean isParent;
    private String price;

    public GenericFoodItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public GenericFoodItem(String id, String name, boolean isParent, String price) {

        this.id = id;
        this.name = name;
        this.isParent = isParent;
        this.price = price;
    }
}
