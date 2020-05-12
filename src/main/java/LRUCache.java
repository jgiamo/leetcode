package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * LRU缓存,可以用LinkedHashMap，也可以手动使用双向链表实现
 */
public class LRUCache {

    static class CacheNode {

        private int key;
        private int val;
        private CacheNode preNode;
        private CacheNode nextNode;

        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private CacheNode head, tail;
    private Map<Integer, CacheNode> map;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        head = new CacheNode(0,0);
        tail = new CacheNode(0, 0);
        head.nextNode = tail;
        tail.preNode = head;
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode cacheNode = map.get(key);
            removeNode(cacheNode);
            addFirst(cacheNode);

            return cacheNode.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode cacheNode = map.get(key);
            cacheNode.val = value;
            removeNode(cacheNode);
            addFirst(cacheNode);

        } else {
            CacheNode cacheNode = new CacheNode(key, value);
            map.put(key, cacheNode);

            addFirst(cacheNode);

            if(size == capacity){
                CacheNode removeNode = tail.preNode;
                removeNode(removeNode);

                map.remove(removeNode.key);
            } else{
                size ++;
            }
        }
    }

    public void removeNode(CacheNode cacheNode){
        cacheNode.preNode.nextNode = cacheNode.nextNode;
        cacheNode.nextNode.preNode = cacheNode.preNode;
    }

    public void addFirst(CacheNode cacheNode){
        cacheNode.nextNode = head.nextNode;
        head.nextNode.preNode = cacheNode;
        head.nextNode = cacheNode;
        cacheNode.preNode = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(1, 1);       // returns 1
        cache.put(2, 3);    // evicts key 2
        cache.put(4 ,1);       // returns -1 (not found)
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(2));       // returns 3
        System.out.println("hello world");
    }

}
