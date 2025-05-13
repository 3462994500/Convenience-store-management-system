package com.gec.dao;

import com.gec.pojo.Vip;
import com.gec.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VipDao {
    public List<Vip> queryVip() {

        List<Vip> vipList = new ArrayList<>();

        String sql = "select * from vip";
        ResultSet rs = JDBCUtil.query(sql);

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String vipName = rs.getString(2);
                String vipPhone = rs.getString(3);
                String vipAddress = rs.getString(4);
                Date date = rs.getDate(5);

                Vip vip = new Vip(id, vipName, vipPhone, vipAddress, date);
                vipList.add(vip);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtil.close();
        return vipList;
    }

    public Vip queryById(int vipId ){
        String sql = "select * from vip where id = ?";

        ResultSet rs = JDBCUtil.query(sql,vipId);
        try{
            if (rs.next()){
                // 参数是 表的字段名
                int id = rs.getInt(1);
                String vipName = rs.getString(2);
                String vipPhone = rs.getString(3);
                String vipAddress = rs.getString(4);
                Date date = rs.getDate(5);
                System.out.println(id+"--"+vipName+"--"+vipPhone+"--"+vipAddress+"--"+date);

                // 得到每一行的数据 封装成一个vip对象
                Vip vip = new Vip(id, vipName, vipPhone, vipAddress, date);
                return vip;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JDBCUtil.close();
        // 返回空
        return null;

    }

    public void addVip(Vip vip){
        String sql = "INSERT into vip(user_name,user_phone,user_address,create_date)VALUES(?,?,?,now())";
        JDBCUtil.update(sql,vip.getVipName(),vip.getVipPhone(),vip.getVipAddress());
                JDBCUtil.close();
    }

    public void updateVip(Vip vip){
        String sql = "UPDATE vip set user_name = ? , user_phone = ?, user_address = ? where id = ?";
        JDBCUtil.update(sql,vip.getVipName(),vip.getVipPhone(),vip.getVipAddress(),vip.getId());
        JDBCUtil.close();
    }

    public void delVip(int id){
        String sql = "delete from vip where id = ?";
        JDBCUtil.update(sql,id);
        JDBCUtil.close();
    }
}

