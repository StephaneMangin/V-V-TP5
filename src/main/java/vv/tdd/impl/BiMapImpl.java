package vv.tdd.impl;

/**
 * Created by Simon on 30/09/14.
 */
public class BiMapImpl<K,V> extends SimpleMapImpl<K,V> implements vv.tdd.BiMap<K,V> {

    @Override
    public K getByValue(Object value) {
        if (values.contains(value)) {
            return keys.get(values.indexOf(value));
        }
        return null;
    }

    @Override
    public K removeValue(Object value) {
        K key = getByValue(value);
        remove(key);
        return key;
    }
}
