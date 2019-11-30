package com.wbdv.projectbackend.serives;

import com.google.gson.Gson;
import com.wbdv.projectbackend.model.BestBuyProductResponse;
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
        ResponseEntity<BestBuyProductResponse> bestBuyResponse = restTemplate.getForEntity("https://api.bestbuy.com/v1/products(manufacturer=" +
                title +
                "&salePrice<1000)?format=json&show=sku,name,salePrice&apiKey=XoGCkE9LeQa4GSRzn4zD6gJq", BestBuyProductResponse.class, httpHeaders);

        return new Gson().toJson(bestBuyResponse.getBody());
    }
}
