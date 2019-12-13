package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.dto.LoginDTO;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User login(LoginDTO loginDTO) {
        User oneByUsername = userRepository.findOneByUsername(loginDTO.getUsername());
        if (oneByUsername != null && bCryptPasswordEncoder.matches(loginDTO.getPassword(), oneByUsername.getPw())) {
            return oneByUsername;
        }
        return null;
    }

    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        if (bCryptPasswordEncoder == null) {
            this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        }
        return bCryptPasswordEncoder;
    }
}
