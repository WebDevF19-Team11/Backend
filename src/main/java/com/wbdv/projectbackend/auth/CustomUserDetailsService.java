package com.wbdv.projectbackend.auth;

import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        log.debug("Authenticating: {0}.", username);

        RuntimeException userNotFoundException = new RuntimeException("User Not Found");

        Optional<User> repoUser = userRepository.findOneByUsername(username);

        if (!repoUser.isPresent()) {
            throw userNotFoundException;
        }

        User user = repoUser.get();

        Set<GrantedAuthority> grantedAuthorities = user.getRoles();

        return new org.springframework.security.core.userdetails.User(username.toLowerCase(),
                user.getPassword(),
                grantedAuthorities);
    }
}
