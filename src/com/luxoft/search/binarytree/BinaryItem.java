package com.luxoft.search.binarytree;

public class BinaryItem<K extends Comparable<? super K>, V> {
    K key;
    private BinaryItem<K, V> left;
    private BinaryItem<K, V> right;
    private V value;

    public BinaryItem(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public  BinaryItem<K, V> getLeft() {
        return left;
    }

    public  BinaryItem<K, V> getRight() {
        return right;
    }

    public void setLeft(BinaryItem<K, V> left) {
        this.left = left;
    }

    public void setRight(BinaryItem<K, V> right) {
        this.right = right;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }
}
