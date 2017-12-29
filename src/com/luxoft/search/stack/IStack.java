package com.luxoft.search.stack;

public interface IStack<T> {
    boolean empty();
    boolean push(T item);
    T pop();
}
