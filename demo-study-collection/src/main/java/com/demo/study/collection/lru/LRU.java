package com.demo.study.collection.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: LRU缓存
 * LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，
 * 其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高
 * @author: Aaron Ma
 **/
public class LRU {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<String, String>(15, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 5;
            }
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : entrySet()) {
                    sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
                }
                return sb.toString();
            }
        };
        map.put("1","11");
        map.put("2","11");
        map.put("3","11");
        map.put("4","11");
        map.put("5","11");
        map.put("6","11");
        System.out.println(map.toString());

        map.put("7","11");
        map.get("2");
        map.get("3");
        System.out.println(map.toString());
    }
}
