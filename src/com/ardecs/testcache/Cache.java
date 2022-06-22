package com.ardecs.testcache;

import java.util.ArrayList;

public class Cache {
    private String key;
    private String value;
    public static ArrayList<Cache> cacheList = new ArrayList<Cache>();
    public static Integer sizeOfCache = 0;
    public Integer countOfUSe;
    public Cache(){
        this.countOfUSe = 0;
    }

    public void allDelete(){
        cacheList.clear();
        System.out.println("Кеш очищен");
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCountOfUSe() {
        return countOfUSe;
    }

    public void setCountOfUSe(Integer countOfUSe) {
        this.countOfUSe = countOfUSe;
    }
}
