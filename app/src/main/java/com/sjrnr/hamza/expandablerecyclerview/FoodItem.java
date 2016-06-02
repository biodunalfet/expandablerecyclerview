package com.sjrnr.hamza.expandablerecyclerview;

/**
 * Created by Hamza Fetuga on 5/31/2016.
 */
public class FoodItem
{
    private String id;

    private String quantityOfProduct;

    private String nameOfProduct;

    private boolean isParent;

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    private String CategoryOfProduct;

    private String descriptionOfProduct;

    private String stockStateOfProduct;

    private String priceOfProduct;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getQuantityOfProduct ()
    {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct (String quantityOfProduct)
    {
        this.quantityOfProduct = quantityOfProduct;
    }

    public String getNameOfProduct ()
    {
        return nameOfProduct;
    }

    public void setNameOfProduct (String nameOfProduct)
    {
        this.nameOfProduct = nameOfProduct;
    }

    public String getCategoryOfProduct ()
    {
        return CategoryOfProduct;
    }

    public void setCategoryOfProduct (String CategoryOfProduct)
    {
        this.CategoryOfProduct = CategoryOfProduct;
    }

    public String getDescriptionOfProduct ()
    {
        return descriptionOfProduct;
    }

    public void setDescriptionOfProduct (String descriptionOfProduct)
    {
        this.descriptionOfProduct = descriptionOfProduct;
    }

    public String getStockStateOfProduct ()
    {
        return stockStateOfProduct;
    }

    public void setStockStateOfProduct (String stockStateOfProduct)
    {
        this.stockStateOfProduct = stockStateOfProduct;
    }

    public String getPriceOfProduct ()
    {
        return priceOfProduct;
    }

    public void setPriceOfProduct (String priceOfProduct)
    {
        this.priceOfProduct = priceOfProduct;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", quantityOfProduct = "+quantityOfProduct+", nameOfProduct = "+nameOfProduct+", CategoryOfProduct = "+CategoryOfProduct+", descriptionOfProduct = "+descriptionOfProduct+", stockStateOfProduct = "+stockStateOfProduct+", priceOfProduct = "+priceOfProduct+"]";
    }
}
