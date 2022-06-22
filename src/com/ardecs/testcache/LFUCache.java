package com.ardecs.testcache;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.ardecs.testcache.Cache.cacheList;
import static com.ardecs.testcache.Cache.sizeOfCache;

public class LFUCache implements Strategy{
    @Override
    public void add(String key, String value) {
        if (sizeOfCache - 1 < cacheList.size()){
            int firstCountOfUse = cacheList.get(0).countOfUSe;
            int k = 0;
            for (int i = 0; i < sizeOfCache; i++){
                if (firstCountOfUse > cacheList.get(i).countOfUSe){
                    firstCountOfUse = cacheList.get(i).countOfUSe;
                    k = i;
                }
            }
            System.out.println("Ключ " + cacheList.get(k).getKey() +
                    " и его значение " + cacheList.get(k).getValue() + " удалены");
            cacheList.get(k).setKey(key);
            cacheList.get(k).setValue(value);
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
                    cacheList.get(i).countOfUSe ++;
                    return cacheList.get(i);
                }
            }
        }
        return null;
    }
}
