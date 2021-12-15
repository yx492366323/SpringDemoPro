package com.zjw.Service;

import com.zjw.Domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    User selectUserByInfo(String username);

    List<User> fineUsersByField(String Field, String Value);

    boolean isUserExist(String UserName);

    boolean insUser(User user);

    boolean modUser(String Field, String Value, Integer Id);

    boolean delUserById(Integer Id);

    String getQuestion(String UserName);

    boolean verifyAnswer(String UserName, String SecurityAnswer);

    boolean changePassword(String UserName, String Password , String SecurityAnswer);

    User toUser(Map Requestbody);
}
