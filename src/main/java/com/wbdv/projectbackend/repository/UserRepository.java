package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findOneByUsername(String username);

}
