package com.zjw.Service.Impl;

import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import com.zjw.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("myUserDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService, MyUserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
        System.out.println("Request: POST:/Login/login");
        if (StringUtils.isEmpty(UserName)){
            throw new UsernameNotFoundException("请填写用户名！");
        }
        User user = userMapper.selectUserByInfo(UserName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        String Password = user.getPasswd();
        String Roles = user.getRoles();
        return new org.springframework.security.core.userdetails.User(UserName,Password, AuthorityUtils
                .commaSeparatedStringToAuthorityList(Roles));
    }
}


