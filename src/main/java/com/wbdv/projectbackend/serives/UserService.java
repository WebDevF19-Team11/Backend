package com.wbdv.projectbackend.serives;

import com.google.common.collect.Streams;
import com.google.common.hash.Hashing;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class UserService extends BaseService<User, Integer> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CrudRepository getRepository() {
        return userRepository;
    }

    public Integer isRealUser(User user){
        user.setPw(securePw(user));
        return Streams.stream(userRepository.findAll())
                .filter(u -> u.getPw() != null && u.getUsername() != null)
                .filter(u -> u.getPw().equals(user.getPw())&& u.getUsername().equals(user.getUsername()))
                .findAny()
                .orElse(new User())
                .getUserId();
    }

    public void createUser(User object) {
        String hashedPw = securePw(object);
        object.setPw(hashedPw);
        userRepository.save(object);
    }

    private String securePw(User object) {
        String saltedPw = object.getPw() + "d6 e9 68 3b 8e d9 62 46 40 e8 ";
        return Hashing.sha256().hashString(saltedPw, Charset.defaultCharset()).toString();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
