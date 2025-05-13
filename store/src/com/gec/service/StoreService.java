package com.gec.service;

import com.gec.dao.StoreDao;
import com.gec.pojo.Store;

import java.util.List;

public class StoreService {
    public StoreDao storeDao = new StoreDao();

    public  List<Store> queryStore(){
        return storeDao.queryStore();
    }
    public Store queryById(int id) {
        return storeDao.queryById(id);
    }

    public void addStore(Store store) {
        storeDao.addStore(store);
    }

    // 修改用户
    public void updateStore(Store store) {
        storeDao.updateStore(store);
    }

    public void delStore(int id) {
        storeDao.delStore(id);
    }
}
