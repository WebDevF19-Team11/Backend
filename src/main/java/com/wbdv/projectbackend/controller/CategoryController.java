package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Category;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.CategoryService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<Category, Integer> {

    @Autowired
    private CategoryService service;

    @Override
    public BaseService<Category, Integer> getService() {
        return service;
    }
}