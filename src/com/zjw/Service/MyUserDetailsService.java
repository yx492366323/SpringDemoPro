package com.zjw.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserDetailsService {
    UserDetails loadUserByUsername(String UserName);
}
