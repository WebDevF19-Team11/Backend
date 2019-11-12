package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.AmazonItem;
import com.wbdv.projectbackend.model.SearchResponse;
import com.wbdv.projectbackend.serives.AmazonProductAPI;
import org.springframework.web.bind.annotation.*;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SearchController {

    AmazonProductAPI amazonProductAPI = AmazonProductAPI.getInstance();

    @GetMapping("/api/amazon/product/")
    public List<SearchResponse> findByTitle(@RequestParam("searchText") String searchText) throws IOException, ServiceException {
        return amazonProductAPI.executeFulltextSearch(searchText);
    }
    @GetMapping("/api/amazon/product/{asin}")
    public AmazonItem getDetails(@PathVariable("asin") String asin) throws IOException {
        return amazonProductAPI.getItemDetail(asin);
    }

}
