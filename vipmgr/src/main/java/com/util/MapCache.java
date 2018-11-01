package com.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: tangJ
 * @Date: 2018/11/1 13:57
 * @description: 缓存工具
 */
public class MapCache {

    /**
     * 默认存储1024个缓存
     */
    private static final int DEFAULT_CACHES = 1024;

    private static Map<String,Object> cacheMap = null;

    private MapCache(){
        cacheMap = new ConcurrentHashMap<>(DEFAULT_CACHES);
    }

    private static class Inner{
        static MapCache instance = new MapCache();
    }

    public static MapCache getCache(){
        return Inner.instance;
    }

    public void set(String key, Object value){
        cacheMap.put(key,value);
    }

    public <T>T get(String key){
        return (T)cacheMap.get(key);
    }
}

