package com.vti.entity;

public class Staff<K> extends MyMap<K, String> {
    
    public Staff(K key, String value) {
        super(key, value);
    }
    
    public K getId() {
        return super.getKey();
    }
    
    public String getName() {
        return super.getValue();
    }
}