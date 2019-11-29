package com.wbdv.projectbackend.model;

public class BestBuyItem {

    private int sku;
    private String salePrice;
    private String name;

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BestBuyItem{" +
                "sku=" + sku +
                ", salePrice='" + salePrice + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
