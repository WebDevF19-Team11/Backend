package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findOneByUsername(String username);
}
