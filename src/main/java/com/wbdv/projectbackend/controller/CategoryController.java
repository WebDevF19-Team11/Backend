package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.serives.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @CrossOrigin
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/{categoryId}/offer")
    public List<Offer> getAll(@PathVariable Integer categoryId) {
        return service.getOffersForCategory(categoryId);
    }



}
