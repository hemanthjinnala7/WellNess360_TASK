package com.example.spring_web.service;
import com.example.spring_web.model.Users;
import com.example.spring_web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Users user = repo.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("user not found");
        }
        return new Userprincipal(user);
    }
}
