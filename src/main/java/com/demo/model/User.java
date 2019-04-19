package com.demo.model;

public class User {
    private Integer id;

    private String nickname;

    private String avatar;

    private Integer roleId;

    public User(){

    }

    public User(Integer id, String nickname, String avatar, Integer roleId) {
        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}