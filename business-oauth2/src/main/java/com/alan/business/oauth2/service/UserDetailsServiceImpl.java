package com.alan.business.oauth2.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan wang
 * @version 1.0
 * @date 2019/9/4 13:42
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$WhCuqmyCsYdqtJvM0/J4seCU.xZQHe2snNE5VFUuBGUZWPbtdl3GG";
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        return new User(USERNAME, PASSWORD, grantedAuthorities);
    }
}
