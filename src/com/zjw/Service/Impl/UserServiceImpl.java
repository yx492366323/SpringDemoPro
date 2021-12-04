package com.zjw.Service.Impl;

import com.zjw.Domain.User;
import com.zjw.Mapper.UserMapper;
import com.zjw.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User selectUserByInfo(String username){
        return userMapper.selectUserByInfo(username);
    }

    public boolean isUserExist(String UserName) {
        return userMapper.isUserExist(UserName);
    }

    public boolean insUser(User user) {
        return 1==userMapper.insUser(user);
    }

    public boolean modUser(String Field, String Value, Integer Id) {
        return 1==userMapper.modUser(Field, Value, Id);
    }


    public String getQuestion(String UserName){
        return selectUserByInfo(UserName).getSecurityquestion();
    }

    public boolean verifyAnswer(String UserName, String SecurityAnswer){
        return SecurityAnswer.equals(selectUserByInfo(UserName).getSecurityanswer());
    }

    public boolean changePassword(String UserName, String Password , String SecurityAnswer){
        if(verifyAnswer(UserName,SecurityAnswer)){
            return modUser("passwd",passwordEncoder().encode(Password),selectUserByInfo(UserName).getId());
        }
        return false;
    }

    public User toUser(Map Requestbody){
        User user = new User();
        user.setIdcard((String) Requestbody.get("Idcard"));
        user.setUsername((String) Requestbody.get("Username"));
        user.setPasswd(passwordEncoder().encode((String) Requestbody.get("Passwd")));
        user.setPhone((String) Requestbody.get("Phone"));
        user.setSecurityquestion((String) Requestbody.get("Securityquestion"));
        user.setSecurityanswer((String) Requestbody.get("Securityanswer"));
        user.setRoles("USER");
        return user;
    }

}
