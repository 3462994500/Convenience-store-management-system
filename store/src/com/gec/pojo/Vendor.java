package com.gec.pojo;

public class Vendor {
    private int id;
    private String vendorNum;
    private String vendorName;

    public Vendor() {
    }

    public Vendor(String vendorNum, String vendorName) {
        this.vendorNum = vendorNum;
        this.vendorName = vendorName;
    }

    public Vendor(int id, String vendorNum, String vendorName) {
        this.id = id;
        this.vendorNum = vendorNum;
        this.vendorName = vendorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorNum() {
        return vendorNum;
    }

    public void setVendorNum(String vendorNum) {
        this.vendorNum = vendorNum;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", vendorNum='" + vendorNum + '\'' +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}
