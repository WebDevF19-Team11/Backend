package com.wbdv.projectbackend.serives;

import com.google.gson.Gson;
import com.wbdv.projectbackend.model.BestBuyProductResponse;
import com.wbdv.projectbackend.model.BestBuySKUProductResponse;
import com.wbdv.projectbackend.model.BestBuySearchProductResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BestBuyService {
    public String getProductsByTitle(String title) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("content-type", "application/json");
        ResponseEntity<BestBuySearchProductResponse> bestBuyResponse = restTemplate.getForEntity("https://api.bestbuy.com/v1/products(manufacturer=" +
                title +
                "&salePrice<1000)?format=json&show=sku,name,salePrice&apiKey=XoGCkE9LeQa4GSRzn4zD6gJq", BestBuySearchProductResponse.class, httpHeaders);

        return new Gson().toJson(bestBuyResponse.getBody());
    }

    public String getProductsBySKU(String sku) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("content-type", "application/json");
        ResponseEntity<BestBuySKUProductResponse> bestBuyResponse = restTemplate.getForEntity("https://api.bestbuy.com/v1/products(sku=" +
                sku +
                ")?format=json&show=sku,name,salePrice,shortDescription,longDescription,largeImage,manufacturer&apiKey=XoGCkE9LeQa4GSRzn4zD6gJq", BestBuySKUProductResponse.class, httpHeaders);

        return new Gson().toJson(bestBuyResponse.getBody());
    }
}
