package vv.tdd.impl;

import java.util.*;

public class SimpleMapImpl<K,V> implements Map<K,V> {

    protected ArrayList<K> keys;
    protected ArrayList<V> values;

    protected int getIndex(Object obj) {
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
        keys.addAll(m.keySet());
        values.addAll(m.values());

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
        HashSet<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for (K key: keys) {
            set.add(new AbstractMap.SimpleEntry<K, V>(key, get(key)));
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleMapImpl)) return false;
        SimpleMapImpl<?, ?> simpleMap = (SimpleMapImpl<?, ?>) o;
        return Objects.equals(keys, simpleMap.keys) &&
                Objects.equals(values, simpleMap.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keys, values);
    }
}
