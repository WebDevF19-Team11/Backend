package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.auth.SecurityUtils;
import com.wbdv.projectbackend.dto.UserDTO;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Integer> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CrudRepository getRepository() {
        return userRepository;
    }

    public UserDTO getLoggedUser() throws RuntimeException {
        User loggedUser = userRepository.findOneByUsername(SecurityUtils.getCurrentUserUsername()).orElseThrow(RuntimeException::new);
        return new UserDTO(loggedUser);
    }

}