package com.los;


import java.util.*;

public class LFUCache<K, V> implements Map<K, V> {

    private Map<K, V> cache;
    private Queue<Access<K>> accessQueue;
    private Map<K, Long> accessCounters;

    private static final int DEFAULT_CAPACITY = 16;
    private int cacheCapacity;

    public LFUCache() {
        cache = new HashMap<>(DEFAULT_CAPACITY, 1);
        accessCounters = new HashMap<>(DEFAULT_CAPACITY, 1);
        accessQueue = new PriorityQueue<>();
        this.cacheCapacity = DEFAULT_CAPACITY;
    }

    public LFUCache(int cacheCapacity) {
        cache = new HashMap<>(cacheCapacity, 1);
        accessCounters = new HashMap<>(cacheCapacity, 1);
        accessQueue = new PriorityQueue<>();
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
        Long accesses = accessCounters.get(key) + 1;
        accessCounters.put((K) key, accesses);
        Access<K> access = new Access<>((K) key, accesses);
        accessQueue.remove(access);
        accessQueue.add(access);
    }

    @Override
    public V put(K key, V value) {
        boolean isFull = size() == cacheCapacity;
        if (cache.containsKey(key)) {
            return cache.put(key, value);
        } else if (isFull) {
            cache.remove(accessQueue.poll().getKey());
        }
        accessQueue.add(new Access<K>(key, 0));
        accessCounters.put(key, 0L);
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

    @Override
    public V remove(Object key) {
        accessQueue.remove(new Access<>((K) key));
        return cache.remove(key);
    }

    @Override
    public boolean remove(Object key, Object value) {
        if (cache.remove(key, value)) {
            accessQueue.remove(new Access<>((K) key));
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        accessQueue.clear();
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

    protected class Access<T> implements Comparable {
        private T key;
        private long accesses = 0;

        Access(T key) {
            this.key = key;
        }

        Access(T key, long accesses) {
            this.key = key;
            this.accesses = accesses;
        }

        public T getKey() {
            return key;
        }

        public long getAccesses() {
            return accesses;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (getClass() != o.getClass()) return false;
            Access<?> access = (Access<?>) o;
            if (this.key == null && this.key == access.getKey()) return true; //case if this.key is null

            return access.key.equals(key);
        }

        @Override
        public int compareTo(Object o) {
            Access<?> obj = (Access<?>) o;
            if (accesses < obj.getAccesses()) {
                return -1;
            } else if (accesses > obj.getAccesses()) {
                return 1;
            }
            return 0;
        }
    }
}
