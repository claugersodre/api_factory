package com.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<com.enterprise.entities.enterprise.User> found =userService.getUserByName(username);

        if (found.stream().iterator().next().getUsername().equals(username)) {
//            return new User(found.stream().iterator().next().getUsername(),found.stream().iterator().next().getPassword(),found.stream().iterator().next().getAdmin(),
//                    new ArrayList<>());
            return new User(found.stream().iterator().next().getUsername(),found.stream().iterator().next().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
