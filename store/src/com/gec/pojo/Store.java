package com.gec.pojo;

public class Store {
    private int id;
    private String storeNum;
    private String storeName;
    private String storeAddress;

    public Store(String storeNum, String storeName, String storeAddress) {
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public Store(int id, String storeNum, String storeName, String storeAddress) {
        this.id = id;
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeNum='" + storeNum + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                '}';
    }
}
