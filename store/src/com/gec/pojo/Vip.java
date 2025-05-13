package com.gec.pojo;

import java.util.Date;

public class Vip {
    private int id;
    private String vipName;
    private String vipPhone;
    private String vipAddress;
    private Date createDate;

    public Vip(String vipName, String vipPhone, String vipAddress) {
        this.vipName = vipName;
        this.vipPhone = vipPhone;
        this.vipAddress = vipAddress;
    }

    public Vip(int id, String vipName, String vipPhone, String vipAddress) {
        this.id = id;
        this.vipName = vipName;
        this.vipPhone = vipPhone;
        this.vipAddress = vipAddress;
    }

    public Vip(int id, String vipName, String vipPhone, String vipAddress, Date createDate) {
        this.id = id;
        this.vipName = vipName;
        this.vipPhone = vipPhone;
        this.vipAddress = vipAddress;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", vipName='" + vipName + '\'' +
                ", vipPhone='" + vipPhone + '\'' +
                ", vipAddress='" + vipAddress + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
