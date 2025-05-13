package com.gec.dao;

import com.gec.pojo.Goods;
import com.gec.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {
    public List<Goods> queryGood(){
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select * from goods";
        ResultSet rs = JDBCUtil.query(sql);

        //ctrl+alt+t
        try {
            while (rs.next()){
                int id = rs.getInt(1);
                String goodNum = rs.getString(2);
                String goodName = rs.getString(3);
                int price = rs.getInt(4);
                String unit = rs.getString(5);
                int vPrice = rs.getInt(6);
                int vendorId = rs.getInt(7);
                Goods g = new Goods(id,goodNum,goodName,price,unit,vPrice,vendorId);
                goodsList.add(g);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodsList;
    }

    public Goods queryById(int goodId ){
        String sql = "select * from goods where id = ?";

        ResultSet rs = JDBCUtil.query(sql,goodId);
        try{
            if (rs.next()){
                // 参数是 表的字段名
                int id = rs.getInt(1);
                String goodNum = rs.getString(2);
                String goodName = rs.getString(3);
                int price = rs.getInt(4);
                String unit = rs.getString(5);
                int vPrice = rs.getInt(6);
                int vendorId = rs.getInt(7);
                Goods g = new Goods(id,goodNum,goodName,price,unit,vPrice,vendorId);
                return g;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JDBCUtil.close();
        // 返回空
        return null;

    }

    public void addGood(Goods good){
        String sql = "INSERT into goods(good_num,good_name,price,unit,v_price,vendorId)VALUES(?,?,?,?,?,?)";
        JDBCUtil.update(sql,good.getGoodNum(),good.getGoodName(),good.getPrice(),good.getUnit(),good.getvPrice(),good.getVendorId());
        JDBCUtil.close();
    }

    public void updateGood(Goods good){
        String sql = "UPDATE goods set good_num = ? , good_name = ? , price = ?, unit = ?, v_price = ?, vendorId = ? where id = ?";
        JDBCUtil.update(sql,good.getGoodNum(),good.getGoodName(),good.getPrice(),good.getUnit(),good.getvPrice(),good.getVendorId(),good.getId());
        JDBCUtil.close();
    }

    public void delGood(int id){
        String sql = "delete from goods where id = ?";
        JDBCUtil.update(sql,id);
        JDBCUtil.close();
    }
}
