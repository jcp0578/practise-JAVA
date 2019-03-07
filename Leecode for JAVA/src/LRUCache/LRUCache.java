package LRUCache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/*
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * 
 * LinkedHashMap实现
 * 
 * AC 144ms
 * 
 */

public class LRUCache extends LinkedHashMap{

	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		MAX_ENTRIES=capacity;
    }
    
    public int get(int key) {
		return (int) super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    private static int MAX_ENTRIES;
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
       return size() > MAX_ENTRIES;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */