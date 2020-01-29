package com.lone.leetcode.j;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class Solution146 {

}

class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,1.1f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
