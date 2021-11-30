package com.zjw.Service.Impl;

import com.zjw.Domain.User;
import com.zjw.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

public class MyUserDetailsServiceImpl implements MyUserDetailsService, UserDetailsService {

    @Autowired
    private User user;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(UserName)){
            throw new UsernameNotFoundException("请填写用户名！");
        }
        User user = userMapper.getUser("UserName",UserName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        String Password = user.getPassword();
        String Roles = user.getUserRoles();
        return new org.springframework.security.core.userdetails.User(UserName,Password, AuthorityUtils
                .commaSeparatedStringToAuthorityList(Roles));
    }
}


