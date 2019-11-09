package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.AmazonItem;
import com.wbdv.projectbackend.model.SearchResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonProductAPI {

    private AmazonProductAPI() {
    }

    private static  AmazonProductAPI INSTANCE;

    public static AmazonProductAPI getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AmazonProductAPI();
        return INSTANCE;
    }

    private SearchResponse[] searchResponses = new SearchResponse[]{new SearchResponse(1,"Produkt 1"),new SearchResponse(2,"Produkt 2"),new SearchResponse(3,"Produkt 3")};
    private AmazonItem[] amazonItems = new AmazonItem[]{new AmazonItem(1,"title1","author1", "manu1", "book"),
            new AmazonItem(2,"title2","author2", "manu2", "car"),
            new AmazonItem(3,"title3","author3", "manu3", "laptop"),

    };

    public List<SearchResponse> executeFulltextSearch(String searchText) {
        return Arrays.asList(searchResponses);
    }

    public AmazonItem getItemDetail(Integer asin) {
        return Arrays.stream(amazonItems).filter(amazonItems -> amazonItems.getId().equals(asin)).findAny().orElse(null);
    }

}
