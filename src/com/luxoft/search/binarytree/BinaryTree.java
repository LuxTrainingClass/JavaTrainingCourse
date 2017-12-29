package com.luxoft.search.binarytree;

import java.util.ArrayList;

public class BinaryTree<K extends Comparable<? super K>, V> {
    BinaryItem<K, V> root = null;

    class SearchData<K1 extends Comparable<? super K1>, V1> {
        BinaryItem<K1, V1> item = null;
        BinaryItem<K1, V1> father = null;

        public SearchData(BinaryItem<K1, V1> item, BinaryItem<K1, V1> father ){

            this.item = item;
            this.father = father;
        }

        public BinaryItem<K1, V1> getItem() {
            return item;
        }

        public BinaryItem<K1, V1> getFather() {
            return father;
        }
    }

    public BinaryItem<K, V> add(K key, V value) {
        SearchData<K, V> data = find(key);

        BinaryItem<K, V> item = data.getItem();
        if (null != item) {
            item.setValue(value);
            return item;
        }

        BinaryItem<K, V> father = data.getFather();
        BinaryItem<K, V> newItem = new BinaryItem<>(key, value);
        if (null == father) {
            root = newItem;
        } else {
            if (key.compareTo(father.getKey()) < 0) father.setLeft(newItem);
            else father.setRight(newItem);
        }

        return newItem;
    }

    public void delete(K key) {
        SearchData<K, V> data = find(key);
        BinaryItem<K, V> item = data.getItem();
        if(null == item) return;

        BinaryItem<K, V> father = data.getFather();
        if(item.getRight() == null){
            if(null == father){
                root = item.getLeft();
            } else if(item == father.getLeft()) father.setLeft(item.getLeft());
            else father.setRight(item.getLeft());
        } else {
            BinaryItem<K, V> left = item.getRight();
            father = null;
            while (left.getLeft() != null){
                father = left;
                left = left.getLeft();
            }

            if(null != father) father.setLeft(left.getRight());
            else item.setRight(left.getRight());
            item.setKey(left.getKey());
            item.setValue(left.getValue());
        }
    }

    public BinaryItem<K, V> get(K key) {
        return find(key).getItem();
    }

    private SearchData<K, V> find(K key){
        BinaryItem<K, V> x = root;
        BinaryItem<K, V> item = null;
        BinaryItem<K, V> father = null;

        while (x != null) {
            int cmp = key.compareTo(x.getKey());
            if(0 == cmp){
                item = x;
                break;
            } else {
                father = x;
                if (cmp < 0) x = x.getLeft();
                else x = x.getRight();
            }
        }

        return new SearchData<>(item, father);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        printTree(sb, root);
        if(sb.length() > 2)
            sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        return sb.toString();
    }

    private void printTree(StringBuilder sb, BinaryItem<K, V> item) {
        if(null == item) return;

        printTree(sb, item.getLeft());
        sb.append(item.getKey()).append(':').append(item.getValue()).append(", ");
        printTree(sb, item.getRight());
    }

    public String toVerticalString(){
        ArrayList<ArrayList<BinaryItem<K, V>>> rows = new ArrayList<>();
        printVerticalRow(rows, 0, root);

        StringBuilder sb = new StringBuilder();
        for (ArrayList<BinaryItem<K, V>> row: rows) {
            sb.append(row).append("\n");
        }
        return sb.toString();
    }

    private int printVerticalRow(ArrayList<ArrayList<BinaryItem<K, V>>> rows, int row, BinaryItem<K, V> item) {
        if(null == item) return row;
        if(row == -1){
            ArrayList<BinaryItem<K, V>> newRow = new ArrayList<>();
            newRow.add(item);
            rows.add(0, newRow);
            ++row;
        } else if(rows.size() > row) {
            rows.get(row).add(item);
        } else {
            ArrayList<BinaryItem<K, V>> newRow = new ArrayList<>();
            newRow.add(item);
            rows.add(newRow);
        }

        if(null != item.getLeft()){
            row = printVerticalRow(rows, --row, item.getLeft()) + 1; // restoring current row
        }

        if(null != item.getRight()){
            printVerticalRow(rows, ++row, item.getRight());
        }

        return row;
    }

}
