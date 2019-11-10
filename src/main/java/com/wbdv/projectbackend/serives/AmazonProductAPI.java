package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.AmazonItem;
import com.wbdv.projectbackend.model.SearchResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonProductAPI {

    private AmazonProductAPI() {
    }

    private static  AmazonProductAPI INSTANCE;

    public static AmazonProductAPI getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AmazonProductAPI();
        return INSTANCE;
    }

    private SearchResponse[] searchResponses = new SearchResponse[]{new SearchResponse(1,"Produkt 1","ecx.images-amazon.com/images/I/519SgX2wwDL._SL75_.jpg"),
            new SearchResponse(2,"Produkt 2","ecx.images-amazon.com/images/I/519SgX2wwDL._SL75_.jpg"),
            new SearchResponse(3,"Produkt 3","ecx.images-amazon.com/images/I/519SgX2wwDL._SL75_.jpg")};
    private AmazonItem[] amazonItems = new AmazonItem[]{new AmazonItem(1,"title1","author1", "manu1", "book","https://www.amazon.com/Rio-2-Sing-Along-Anne-Hathaway/dp/B00P7PJ77K/ref=sr_1_6?keywords=rio&qid=1573344822&sr=8-6","ecx.images-amazon.com/images/I/519SgX2wwDL._SL500_.jpg"),
            new AmazonItem(2,"title2","author2", "manu2", "car","https://www.amazon.com/Rio-2-Sing-Along-Anne-Hathaway/dp/B00P7PJ77K/ref=sr_1_6?keywords=rio&qid=1573344822&sr=8-6", "ecx.images-amazon.com/images/I/519SgX2wwDL._SL500_.jpg"),
            new AmazonItem(3,"title3","author3", "manu3", "laptop","https://www.amazon.com/Rio-2-Sing-Along-Anne-Hathaway/dp/B00P7PJ77K/ref=sr_1_6?keywords=rio&qid=1573344822&sr=8-6","ecx.images-amazon.com/images/I/519SgX2wwDL._SL500_.jpg")

    };

    //https://docs.aws.amazon.com/AWSECommerceService/latest/DG/EX_RetrievingImages.html
    //https://docs.aws.amazon.com/AWSECommerceService/latest/DG/ItemSearch.html


    public List<SearchResponse> executeFulltextSearch(String searchText) {
        return Arrays.asList(searchResponses).stream().filter(searchResponse -> searchResponse.getTitle().contains(searchText)).collect(Collectors.toList());
    }

    public AmazonItem getItemDetail(Integer asin) {
        return Arrays.stream(amazonItems).filter(amazonItems -> amazonItems.getId().equals(asin)).findAny().orElse(null);
    }

}
