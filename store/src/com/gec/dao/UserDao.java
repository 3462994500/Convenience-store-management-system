package com.gec.dao;

import com.gec.pojo.User;
import com.gec.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {

    public User login(String userPhone){
        String sql = "select * from user where user_phone = ?";
        ResultSet rs = JDBCUtil.query(sql,userPhone);

        try {
            if (rs.next()) {
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String userPwd = rs.getString(3);
                String userPhone1 = rs.getString(4);
                String userAddress = rs.getString(5);
                Date date = rs.getDate(6);
                User user = new User(id, userName, userPwd, userPhone1, userAddress, date);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public List<User> queryUser() {

        List<User> userList = new ArrayList<>();

        String sql = "select * from user";
        ResultSet rs = JDBCUtil.query(sql);

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String userPwd = rs.getString(3);
                String userPhone = rs.getString(4);
                String userAddress = rs.getString(5);
                Date date = rs.getDate(6);

                User user = new User(id, userName, userPwd, userPhone, userAddress, date);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtil.close();
        return userList;
    }

    public User queryById(int userId ){
        String sql = "select * from user where id = ?";

        ResultSet rs = JDBCUtil.query(sql,userId);
        try{
            if (rs.next()){
                // 参数是 表的字段名
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String userPwd = rs.getString(3);
                String userPhone = rs.getString(4);
                String userAddress = rs.getString(5);
                Date date = rs.getDate(6);
                System.out.println(id+"--"+userName+"--"+userPwd+"--"+userPhone+"--"+userAddress+"--"+date);

                // 得到每一行的数据 封装成一个user对象
                User user = new User(id, userName, userPwd, userPhone, userAddress, date);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JDBCUtil.close();
        // 返回空
        return null;

    }

    public void addUser(User user){
        String sql = "INSERT into user(user_name,user_pwd,user_phone,user_address,create_date)VALUES(?,?,?,?,now())";
        JDBCUtil.update(sql,user.getUserName(),user.getUserPwd(),user.getUserPhone(),user.getUserAddress());
                JDBCUtil.close();
    }

    public void updateUser(User user){
        String sql = "UPDATE user set user_name = ? , user_pwd = ? , user_phone = ?, user_address = ? where id = ?";
        JDBCUtil.update(sql,user.getUserName(),user.getUserPwd(),user.getUserPhone(),user.getUserAddress(),user.getId());
        JDBCUtil.close();
    }

    public void delUser(int id){
        String sql = "delete from user where id = ?";
        JDBCUtil.update(sql,id);
        JDBCUtil.close();
    }
}

