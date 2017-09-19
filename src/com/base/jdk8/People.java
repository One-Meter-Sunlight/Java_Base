package com.base.jdk8;

/**
 * Created by ck on 2017-09-17.
 */
public class People {
    private int id;
    private String name;

    private int provinceId;
    private String address;

    public People() {}

    public People(int id, String name, int provinceId, String address) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
