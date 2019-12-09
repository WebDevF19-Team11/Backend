package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void create(@RequestBody User object) {
        service.createUser(object);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "/id")
    @ResponseBody
    public Integer isRealUser(@RequestBody User object) {
        return service.isRealUser(object);
    }


}
