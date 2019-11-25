package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController extends BaseController<User, Integer> {

    @Autowired
    private UserService service;

    @Override
    public BaseService<User, Integer> getService() {
        return service;
    }


}