package vv.tdd.impl;

import java.util.*;

public class SimpleMapImpl<K,V> implements Map<K,V> {

    private ArrayList<K> keys;
    private ArrayList<V> values;

    private int getIndex(Object obj) {
        return keys.indexOf(obj);
    }

    public SimpleMapImpl() {
        keys = new ArrayList<K>();
        values = new ArrayList<V>();
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        if (keys.contains(key)) {
            return values.get(getIndex(key));
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index;
        if (keys.contains(key)) {
            index = getIndex(key);
            keys.set(index, key);
            V previousValue = values.get(index);
            values.set(index, value);
            return previousValue;
        }
        keys.add(key);
        index = getIndex(key);
        values.add(value);
        return null;
    }

    @Override
    public V remove(Object key) {
        if (keys.contains(key)) {
            int index = getIndex(key);
            keys.remove(index);
            V previousValue = values.get(index);
            values.remove(index);
            return previousValue;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<K>(keys);
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
