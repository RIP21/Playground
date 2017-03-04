package com.los;


import java.util.*;

public class LFUCache<K, V> implements Map<K, V> {

    private Map<K, V> cache;
    private Map<K, Long> accesses;

    private static final int DEFAULT_CAPACITY = 16;
    private int cacheCapacity;

    public LFUCache() {
        cache = new HashMap<>(DEFAULT_CAPACITY, 1);
        accesses = new LinkedHashMap<>(DEFAULT_CAPACITY, 1);
        this.cacheCapacity = DEFAULT_CAPACITY;
    }

    public LFUCache(int cacheCapacity) {
        cache = new HashMap<>(cacheCapacity, 1);
        accesses = new LinkedHashMap<>(cacheCapacity, 1);
        this.cacheCapacity = cacheCapacity;
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public boolean isEmpty() {
        return cache.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return cache.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return cache.containsValue(value);
    }

    @Override
    public V get(Object key) {
        incrementAccess(key);
        return cache.get(key);
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V value = cache.getOrDefault(key, defaultValue);
        boolean isNotInCache = value.equals(defaultValue);
        if (isNotInCache) {
            return value;
        } else {
            incrementAccess(key);
            return value;
        }
    }

    private void incrementAccess(Object key) {
        accesses.put((K) key, accesses.get(key) + 1);
    }

    @Override
    public V put(K key, V value) {
        boolean isFull = size() == cacheCapacity;
        if (cache.containsKey(key)) {
            return cache.put(key, value);
        } else if (isFull) {
            removeLeastUsed();
        }
        accesses.put(key, 0L);
        return cache.put(key, value);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return put(key, value);
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.entrySet().forEach(entry -> put(entry.getKey(), entry.getValue()));
    }

    private void removeLeastUsed() {
        long min = Long.MAX_VALUE;
        K leastUsed = null;
        for (Entry<K, Long> entry : accesses.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                leastUsed = entry.getKey();
            }
        }
        accesses.remove(leastUsed);
        cache.remove(leastUsed);
    }

    @Override
    public V remove(Object key) {
        accesses.remove(key);
        return cache.remove(key);
    }

    @Override
    public boolean remove(Object key, Object value) {
        if (cache.remove(key, value)) {
            accesses.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        accesses.clear();
        cache.clear();
    }

    @Override
    public Set<K> keySet() {
        return cache.keySet();
    }

    @Override
    public Collection<V> values() {
        return cache.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return cache.entrySet();
    }

}
