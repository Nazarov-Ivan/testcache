package com.ardecs.testcache;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.ardecs.testcache.Cache.cacheList;
import static com.ardecs.testcache.Cache.sizeOfCache;

public class MRUCache implements Strategy{

    @Override
    public void add(String key, String value) {
        if (sizeOfCache - 1 < cacheList.size()){
            System.out.println("Ключ " + cacheList.get(sizeOfCache-1).getKey()
                    + " и его значение " + cacheList.get(sizeOfCache-1).getValue() + " удалены");
            cacheList.get(sizeOfCache-1).setKey(key);
            cacheList.get(sizeOfCache-1).setValue(value);
        }
        Cache element = new Cache();
        element.setKey(key);
        element.setValue(value);
        cacheList.add(element);
    }

    public Cache get(String key){
        if (cacheList.size() == 0){
            return null;
        } else {
            for (int i = 0; i < cacheList.size();i++){
                if (cacheList.get(i).getKey().equals(key)){
                    return cacheList.get(i);
                }
            }
        }
        return null;
    }
}

