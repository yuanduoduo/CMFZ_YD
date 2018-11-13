package com.baizhi.entity;

public class Admin {
    private String id;
    private String name;
    private String username;
    private String password;
    private String md5;
    private String state;

    public Admin(String id, String name, String username, String password, String md5, String state) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.md5 = md5;
        this.state = state;
    }


    public Admin() {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", md5='" + md5 + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
