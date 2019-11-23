package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }
}
