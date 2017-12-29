package com.luxoft.search.stack;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> list = new ArrayList<>();
    int top = -1;

    public boolean empty() {
        return -1 == top;
    }

    //Complexity: O(1)
    public void push(T item) {
        ++top;
        list.add(item);
    }

    //Complexity: O(1)
    public T pop() {
        if(empty()) throw new StackOverflowError();

        --top;
        return list.remove(top + 1);
    }

    @Override
    public String toString() {
        if(empty()) return "[]";

        return list.toString();
    }
}
