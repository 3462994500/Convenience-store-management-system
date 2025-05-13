package com.gec.dao;

import com.gec.pojo.Store;
import com.gec.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDao {
    public List<Store> queryStore(){
        List<Store> storeList = new ArrayList<>();
        String sql = "select * from store";
        ResultSet rs = JDBCUtil.query(sql);

        //ctrl+alt+t
        try {
            while (rs.next()){
                int id = rs.getInt(1);
                String storeNum = rs.getString(2);
                String storeName = rs.getString(3);
                String storeAddress = rs.getString(4);
                Store store = new Store(id,storeNum,storeName,storeAddress);
                storeList.add(store);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return storeList;
    }

    public Store queryById(int storeId ){
        String sql = "select * from store where id = ?";

        ResultSet rs = JDBCUtil.query(sql,storeId);
        try{
            if (rs.next()){
                // 参数是 表的字段名
                int id = rs.getInt(1);
                String storeNum = rs.getString(2);
                String storeName = rs.getString(3);
                String storeAddress = rs.getString(4);
                Store store = new Store(id,storeNum,storeName,storeAddress);
                return store;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JDBCUtil.close();
        // 返回空
        return null;

    }

    public void addStore(Store store){
        String sql = "INSERT into store(store_num,store_name,store_address)VALUES(?,?,?)";
        JDBCUtil.update(sql,store.getStoreNum(),store.getStoreName(),store.getStoreAddress());
        JDBCUtil.close();
    }

    public void updateStore(Store store){
        String sql = "UPDATE store set store_num = ? , store_name = ? , store_address = ? where id = ?";
        JDBCUtil.update(sql,store.getStoreNum(),store.getStoreName(),store.getStoreAddress(),store.getId());
        JDBCUtil.close();
    }

    public void delStore(int id){
        String sql = "delete from store where id = ?";
        JDBCUtil.update(sql,id);
        JDBCUtil.close();
    }
}
