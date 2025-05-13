package com.gec.service;

import com.gec.dao.VipDao;
import com.gec.pojo.Vip;

import java.util.List;

public class VipService {
    VipDao vipDao = new VipDao();

    public List<Vip> queryVip() {
        return vipDao.queryVip();
    }

    public Vip queryById(int id) {
        return vipDao.queryById(id);
    }

    public void addVip(Vip vip) {
        vipDao.addVip(vip);
    }

    // 修改用户
    public void updateVip(Vip vip) {
        vipDao.updateVip(vip);
    }

    public void delVip(int id) {
        vipDao.delVip(id);
    }
}
