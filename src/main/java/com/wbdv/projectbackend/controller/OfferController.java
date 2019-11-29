package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.OfferService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("offer")
public class OfferController extends BaseController<Offer, Integer> {

    @Autowired
    private OfferService service;

    @Override
    public BaseService<Offer, Integer> getService() {
        return service;
    }



    @CrossOrigin
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "s")
    public List<Offer> getByFulltextSearch(@RequestParam String searchText) {
        return service.getByFulltext(searchText);
    }

}