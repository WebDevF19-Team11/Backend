package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.ItemService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("item")
public class ItemController extends BaseController<Item, Integer> {

    @Autowired
    private ItemService service;

    @Override
    public BaseService<Item, Integer> getService() {
        return service;
    }
}