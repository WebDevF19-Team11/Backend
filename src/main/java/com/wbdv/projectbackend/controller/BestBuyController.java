package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.serives.BestBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class BestBuyController {

    @Autowired
    private BestBuyService bestBuyService;

    @GetMapping(value = "/api/best-buy/products/{title}")
    public ResponseEntity getProductsByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(bestBuyService.getProductsByTitle(title));
    }

}
