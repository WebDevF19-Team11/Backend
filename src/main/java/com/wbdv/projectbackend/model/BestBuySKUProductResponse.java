package com.wbdv.projectbackend.model;

import java.util.List;

public class BestBuySKUProductResponse extends BestBuyProductResponse {

    private List<BestBuySKUItem> products;

    public List<BestBuySKUItem> getProducts() {
        return products;
    }

    public void setProducts(List<BestBuySKUItem> products) {
        this.products = products;
    }
}
