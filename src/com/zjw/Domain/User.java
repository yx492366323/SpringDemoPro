package com.zjw.Domain;

public class User {
    private Integer id;
    private String idcard;
    private String username;
    private String passwd;
    private String phone;
    private String roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String rules) {
        this.roles = rules;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idcard='" + idcard + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", phone='" + phone + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
