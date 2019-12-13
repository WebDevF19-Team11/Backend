package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.dto.LoginDTO;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.serives.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        User user = loginService.login(loginDTO);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

}
