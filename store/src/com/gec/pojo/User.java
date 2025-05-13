package com.gec.pojo;

import java.util.Date;

public class User {
    private int id;
    private String userName;
    private String userPwd;
    private String userPhone;
    private String userAddress;
    private Date createDate;

    public User() {
    }

    public User(String userName, String userPwd, String userPhone, String userAddress) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public User(int id, String userName, String userPwd, String userPhone, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public User(int id, String userName, String userPwd, String userPhone, String userAddress, Date createDate) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
