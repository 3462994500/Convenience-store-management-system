package com.gec.service;

import com.gec.dao.UserDao;
import com.gec.pojo.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public List<User> queryUser() {
        return userDao.queryUser();
    }

    public User queryById(int id) {
        return userDao.queryById(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    // 修改用户
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void delUser(int id) {
        userDao.delUser(id);
    }

    public User login(String userPhone, String userPwd) {
        User loginUser = userDao.login(userPhone);

        if (loginUser != null) {
            if (loginUser.getUserPwd().equals(userPwd)) {
                return loginUser;
            }
        }
        return null;
    }
}
