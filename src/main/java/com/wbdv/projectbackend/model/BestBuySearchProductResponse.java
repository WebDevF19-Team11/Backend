package com.wbdv.projectbackend.model;

import java.util.List;

public class BestBuySearchProductResponse extends BestBuyProductResponse {

    private List<BestBuyItem> products;

    public List<BestBuyItem> getProducts() {
        return products;
    }

    public void setProducts(List<BestBuyItem> products) {
        this.products = products;
    }
}
