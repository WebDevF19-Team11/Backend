package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.ItemService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("item")
public class ItemController extends BaseController<Item, Integer> {

    @Autowired
    private ItemService service;

    @Override
    public BaseService<Item, Integer> getService() {
        return service;
    }


    @CrossOrigin
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "s")
    public List<Item> getByFulltextSearch(@RequestParam String searchText) {
        return service.getByFulltext(searchText);
    }


}