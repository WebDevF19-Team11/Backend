package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
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
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/")
    public List<Offer> getByFulltextSearch(@RequestParam String searchText) {
        return service.getByFulltext(searchText);
    }

    @GetMapping("/{username}")
    public ResponseEntity getOffersByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.getOffersByUsername(username));
    }

}
