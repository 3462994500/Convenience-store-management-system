package com.gec.service;

import com.gec.dao.VendorDao;
import com.gec.pojo.Vendor;

import java.util.List;

public class VendorService {

    public VendorDao vendorDao = new VendorDao();

    public List<Vendor> queryVendor(){
        return  vendorDao.queryVendor();
    }
    public Vendor queryById(int id) {
        return vendorDao.queryById(id);
    }

    public void addVendor(Vendor vendor) {
        vendorDao.addVendor(vendor);
    }

    // 修改用户
    public void updateVendor(Vendor vendor) {
        vendorDao.updateVendor(vendor);
    }

    public void delVendor(int id) {
        vendorDao.delVendor(id);
    }
}
