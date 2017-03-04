package com.los;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    @DisplayName("Works as hash")
    @Test
    void test1() {
        Map<Integer, Integer> lfuCache = new LFUCache<>();
        lfuCache.put(1, 1);
        assertTrue(lfuCache.get(1).equals(1));
    }

    @DisplayName("Constructs with capacity and locks its size")
    @Test
    void test2() {
        //given: cache with capacity 1
        Map<Integer, Integer> lfuCache = new LFUCache<>(1);
        //when: two values have been put
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        //then: only last put value must remain
        assertTrue(lfuCache.get(2) == 2);
        assertTrue(lfuCache.getOrDefault(1, 0) == 0);
    }

    @DisplayName("Constructs with capacity and removes least used items")
    @Test
    void test3() {
        //given: cache with capacity 3 and 3 items
        Map<Integer, Integer> lfuCache = new LFUCache<>(3);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        //when: use items and put new item
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.put(4, 4);
        //then: least used item 3 must be removed
        assertTrue(lfuCache.get(1) == 1);
        assertTrue(lfuCache.get(2) == 2);
        assertTrue(lfuCache.get(4) == 4);
        assertTrue(lfuCache.getOrDefault(3, 0) == 0);
    }

    @DisplayName("Could put and get from null key")
    @Test
    void test4() {
        //given
        Map<Integer, Integer> lfuCache = new LFUCache<>();
        //when: put on null key
        lfuCache.put(null, 1);
        //then: get on null key returns correct value
        assertTrue(lfuCache.get(null) == 1);
    }

    @DisplayName("Counting usages of null key correctly")
    @Test
    void test5() {
        //given: cache with capacity 3 and 3 items
        Map<Integer, Integer> lfuCache = new LFUCache<>(2);
        lfuCache.put(null, 1);
        lfuCache.put(2, 2);
        //when: get null few times and put new item
        lfuCache.get(null);
        lfuCache.get(null);
        lfuCache.put(3, 3);
        //then: least used item 2 must be removed
        assertTrue(lfuCache.get(null) == 1);
        assertTrue(lfuCache.get(3) == 3);
        assertTrue(lfuCache.getOrDefault(2, -1) == -1);
    }

    @DisplayName("Removing by key")
    @Test
    void test6() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(1);
        lfuCache.put(1, 1);
        lfuCache.remove(1);
        assertTrue(lfuCache.getOrDefault(1, -1) == -1);
        assertTrue(lfuCache.isEmpty());
    }

    @DisplayName("Removing only by match of key value")
    @Test
    void test7() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.remove(1, 1); // match
        lfuCache.remove(2, 3); // no match
        assertTrue(lfuCache.getOrDefault(1, -1) == -1);
        assertTrue(lfuCache.get(2) == 2);
        assertFalse(lfuCache.isEmpty());
    }

    @DisplayName("Method putAll working as expected")
    @Test
    void test8() {
        //given: caches and HashMap
        Map<Integer, Integer> lfuCache = new LFUCache<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        //when: putAll called with hashMap
        lfuCache.putAll(hashMap);
        //then: items must be add correctly
        assertTrue(lfuCache.get(1) == 1);
        assertTrue(lfuCache.get(2) == 2);
    }

    @DisplayName("Method putAll pushing out least used values")
    @Test
    void test9() {
        //given: caches and HashMap
        Map<Integer, Integer> lfuCache = new LFUCache<>(3);
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        //when: putAll called with hashMap
        lfuCache.put(4, 4);
        lfuCache.put(5, 5);
        lfuCache.put(6, 6); //least used
        lfuCache.get(4);
        lfuCache.get(5);
        lfuCache.putAll(hashMap);
        //then: items must be add correctly
        assertTrue(lfuCache.get(4) == 4);
        assertTrue(lfuCache.get(5) == 5);
        assertTrue(lfuCache.get(3) == 3);
        assertTrue(lfuCache.getOrDefault(6, -1) == -1);
    }

    @DisplayName("Clear removes all entries")
    @Test
    void test10() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(1);
        lfuCache.put(1, 1);
        lfuCache.clear();
        assertTrue(lfuCache.size() == 0);
    }

    @DisplayName("Method putIfAbsent works correctly")
    @Test
    void test11() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(1);
        lfuCache.putIfAbsent(1, 1);
        lfuCache.putIfAbsent(1, 3); // try to update
        assertTrue(lfuCache.get(1) == 1);
    }

    @DisplayName("Method getOrDefault increment usage correctly")
    @Test
    void test12() {
        //given: Cache with capacity 2 and 2 items
        Map<Integer, Integer> lfuCache = new LFUCache<>(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        //when: getOrDefault called it increment item usage so its not be pushed out after put of new value
        lfuCache.get(1);
        lfuCache.getOrDefault(2, 0);
        lfuCache.getOrDefault(2, 0);
        lfuCache.put(3, 3);
        //then: key 2 must not be pushed out
        assertTrue(lfuCache.get(2) == 2);
        assertTrue(lfuCache.get(3) == 3);
        assertTrue(lfuCache.getOrDefault(1, -1) == -1);
    }

    @DisplayName("Methods containsKey and containsValue smoke test")
    @Test
    void test13() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(1);
        lfuCache.put(1, 1);
        assertTrue(lfuCache.containsKey(1));
        assertTrue(lfuCache.containsValue(1));
    }

    @DisplayName("Methods entrySet, values, keySet smoke test")
    @Test
    void test14() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(1);
        lfuCache.put(1, 1);

        lfuCache.entrySet().forEach(entry -> {
            assertTrue(entry.getKey() == 1);
            assertTrue(entry.getValue() == 1);
        });
        lfuCache.values().forEach(value -> assertTrue(value == 1));
        lfuCache.keySet().forEach(key -> assertTrue(key == 1));

        assertTrue(lfuCache.entrySet().size() == 1);
        assertTrue(lfuCache.values().size() == 1);
        assertTrue(lfuCache.keySet().size() == 1);
    }

    @DisplayName("Put of the same key when cache is full will not overflow or remove least used")
    @Test
    void test15() {
        Map<Integer, Integer> lfuCache = new LFUCache<>(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(1, 3);

        assertTrue(lfuCache.size() == 2);
        assertTrue(lfuCache.get(1) == 3);
        assertTrue(lfuCache.get(2) == 2);
    }
}