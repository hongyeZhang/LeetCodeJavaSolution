package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : ZHQ
 * @date : 2020/4/14
 */
public class Test146 {

    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private final int CACHE_SIZE;

        public LRUCache(int capacity) {
            super((int) Math.ceil(capacity / 0.75f) + 1, 0.75f, true);
            CACHE_SIZE = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > CACHE_SIZE;
        }
    }


    @Test
    public void test() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.get("2");//2移动到了内部的链表末尾
        map.get("4");//4调整至末尾
        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        System.out.println("以下是accessOrder=true的情况:");

        map = new LinkedHashMap<String, String>(10, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.get("2");//2移动到了内部的链表末尾
        map.get("4");//4调整至末尾
        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }



}
