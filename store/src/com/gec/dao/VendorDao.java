package com.gec.dao;

import com.gec.pojo.Vendor;
import com.gec.pojo.Vendor;
import com.gec.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDao {
    public List<Vendor> queryVendor(){
        List<Vendor> list = new ArrayList<>();
        String sql = "select * from vendor";
        ResultSet rs = JDBCUtil.query(sql);

        try {
            while (rs.next()){
                int id = rs.getInt(1);
                String vendorNum = rs.getString(2);
                String vendorName = rs.getString(3);
                Vendor v = new Vendor(id,vendorNum,vendorName);
                list.add(v);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Vendor queryById(int vendorId ){
        String sql = "select * from vendor where id = ?";

        ResultSet rs = JDBCUtil.query(sql,vendorId);
        try{
            if (rs.next()){
                // 参数是 表的字段名
                int id = rs.getInt(1);
                String vendorNum = rs.getString(2);
                String vendorName = rs.getString(3);
                Vendor vendor = new Vendor(id,vendorNum,vendorName);
                return vendor;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JDBCUtil.close();
        // 返回空
        return null;

    }

    public void addVendor(Vendor vendor){
        String sql = "INSERT into vendor(vendor_num,vendor_name)VALUES(?,?)";
        JDBCUtil.update(sql,vendor.getVendorNum(),vendor.getVendorName());
        JDBCUtil.close();
    }

    public void updateVendor(Vendor vendor){
        String sql = "UPDATE vendor set vendor_num = ? , vendor_name = ? where id = ?";
        JDBCUtil.update(sql,vendor.getVendorNum(),vendor.getVendorName(),vendor.getId());
        JDBCUtil.close();
    }

    public void delVendor(int id){
        String sql = "delete from vendor where id = ?";
        JDBCUtil.update(sql,id);
        JDBCUtil.close();
    }

}
