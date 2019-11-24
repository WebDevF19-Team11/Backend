package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.OfferService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("offer")
public class OfferController extends BaseController<Offer, Integer> {

    @Autowired
    private OfferService service;

    @Override
    public BaseService<Offer, Integer> getService() {
        return service;
    }
}