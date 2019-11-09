package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.AmazonItem;
import com.wbdv.projectbackend.model.SearchResponse;

import java.util.ArrayList;
import java.util.List;

public class AmazonProductAPI {

    //Singleton

    public List<SearchResponse> executeFulltextSearch(String searchText) {
        return new ArrayList<>();
    }

    public AmazonItem getItemDetail(Integer asin) {
        return new AmazonItem();
    }

}
