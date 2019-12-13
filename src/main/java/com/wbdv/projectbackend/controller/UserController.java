package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
        return service.getById(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getAllUser() {
        return service.getAll();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", path = "/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("{username}")
    public ResponseEntity whoAmI(@PathVariable("username") String username) {
        try {
            return ResponseEntity.ok(service.getUserByUsername(username));
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

}
