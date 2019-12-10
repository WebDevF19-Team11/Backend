package com.wbdv.projectbackend.model;

public class BestBuySKUItem extends BestBuyItem {

    private String shortDescription;
    private String longDescription;
    private String largeImage;
    private String manufacturer;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "BestBuySKUItem{" +
                "shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", largeImage='" + largeImage + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", sku=" + sku +
                ", salePrice='" + salePrice + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
