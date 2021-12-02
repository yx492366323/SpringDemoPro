package com.zjw.Service;

import com.zjw.Domain.User;

import java.util.Map;

public interface UserService {
    User selectUserByInfo(String username);

    boolean insUser(User user);

    boolean modUser(String Field, String Value, Integer Id);

    String getQuestion(String UserName);

    boolean verifyAnswer(String UserName, String SecurityAnswer);

    boolean changePassword(String UserName, String Password , String SecurityAnswer);

    User toUser(Map Requestbody);
}
