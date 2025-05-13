package com.gec.pojo;

public class Goods {

    private int id;
    private String goodNum;
    private String goodName;
    private int price;
    private String unit;
    private int vPrice;
    private int vendorId;

    public Goods() {
    }

    public Goods(String goodNum, String goodName, int price, String unit, int vPrice, int vendorId) {
        this.goodNum = goodNum;
        this.goodName = goodName;
        this.price = price;
        this.unit = unit;
        this.vPrice = vPrice;
        this.vendorId = vendorId;
    }

    public Goods(int id, String goodNum, String goodName, int price, String unit, int vPrice, int vendorId) {
        this.id = id;
        this.goodNum = goodNum;
        this.goodName = goodName;
        this.price = price;
        this.unit = unit;
        this.vPrice = vPrice;
        this.vendorId = vendorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getvPrice() {
        return vPrice;
    }

    public void setvPrice(int vPrice) {
        this.vPrice = vPrice;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodNum='" + goodNum + '\'' +
                ", goodName='" + goodName + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", vPrice=" + vPrice +
                ", vendorId=" + vendorId +
                '}';
    }
}
