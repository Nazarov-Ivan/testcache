package com.ardecs.testcache;

import static com.ardecs.testcache.Cache.cacheList;
import static com.ardecs.testcache.Cache.sizeOfCache;

public class LRUCache implements Strategy{

    @Override
    public void add(String key, String value) {
        for (int i = 0; i < cacheList.size(); i++) {
            if (cacheList.get(i).getKey().equals(key)) {
                cacheList.remove(i);
            } else if (sizeOfCache - 1 < cacheList.size()){
                System.out.println("Ключ " + cacheList.get(0).getKey() +
                        " и его значение " + cacheList.get(0).getValue() + " удалены");
                cacheList.remove(0);
            }
        }
        Cache element = new Cache();
        element.setKey(key);
        element.setValue(value);
        cacheList.add(element);
    }
    public Cache get(String key) {
        if (cacheList.size() == 0){
            return null;
        } else {
            for (int i = 0; i < cacheList.size();i++){
                if (cacheList.get(i).getKey().equals(key)){
                    String keyLRU = cacheList.get(i).getKey();
                    String valueLRU = cacheList.get(i).getValue();
                    cacheList.remove(i);
                    Cache cache = new Cache();
                    cache.setKey(keyLRU);
                    cache.setValue(valueLRU);
                    cacheList.add(cache);
                    return cacheList.get(i);
                }
            }
        }
        return null;
    }
}
