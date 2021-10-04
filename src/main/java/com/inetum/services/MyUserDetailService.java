package com.inetum.services;

import com.inetum.entities.User;
import com.inetum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         final User userDb = this.userRepository.findByUsername(username);

         return new UserDetails() {
             @Override
             public Collection<? extends GrantedAuthority> getAuthorities() {
                 return new ArrayList<>();
             }

             @Override
             public String getPassword() {
                 return userDb.getPassword();
             }

             @Override
             public String getUsername() {
                 return userDb.getUsername();
             }

             @Override
             public boolean isAccountNonExpired() {
                 return true;
             }

             @Override
             public boolean isAccountNonLocked() {
                 return true;
             }

             @Override
             public boolean isCredentialsNonExpired() {
                 return true;
             }

             @Override
             public boolean isEnabled() {
                 return true;
             }
         };

    }
}


