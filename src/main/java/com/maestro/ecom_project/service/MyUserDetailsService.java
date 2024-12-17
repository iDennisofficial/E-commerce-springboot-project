package com.maestro.ecom_project.service;

import com.maestro.ecom_project.model.UserPrincipal;
import com.maestro.ecom_project.model.Users;
import com.maestro.ecom_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User Not Found>>>>");

            throw new UsernameNotFoundException("User Not Found<<<<<<<<");
        }

        System.out.println(user.toString());
        return new UserPrincipal(user);
    }
}
