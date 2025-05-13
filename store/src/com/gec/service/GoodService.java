package com.gec.service;

import com.gec.dao.GoodDao;
import com.gec.pojo.Goods;
import java.util.List;

public class GoodService {
    public GoodDao goodDao = new GoodDao();

    public  List<Goods> queryGood(){
        return goodDao.queryGood();
    }
    public Goods queryById(int id) {
        return goodDao.queryById(id);
    }

    public void addGood(Goods good) {
        goodDao.addGood(good);
    }

    // 修改用户
    public void updateGood(Goods good) {
        goodDao.updateGood(good);
    }

    public void delGood(int id) {
        goodDao.delGood(id);
    }
}
