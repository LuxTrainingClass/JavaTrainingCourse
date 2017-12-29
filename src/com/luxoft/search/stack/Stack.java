package com.luxoft.search.stack;

import java.util.ArrayList;

public class Stack<T> implements IStack<T> {

    protected final Integer CAPACITY = 512;

    private ArrayList<T> list = new ArrayList<>(CAPACITY);
    protected int top = -1;

    @Override
    public boolean empty() {
        return -1 == top;
    }

    //Complexity: O(1)
    @Override
    public boolean push(T item) {
        ++top;
        return list.add(item);
    }

    //Complexity: O(1)
    @Override
    public T pop() {
        if(empty()) return null;

        --top;
        return list.remove(top + 1);
    }

    @Override
    public String toString() {
        if(empty()) return "[]";

        return list.toString();
    }
}
