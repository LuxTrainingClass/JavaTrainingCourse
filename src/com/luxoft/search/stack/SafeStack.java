package com.luxoft.search.stack;

public class SafeStack<T> extends Stack<T> {

    @Override
    public synchronized boolean empty() {
        return super.empty();
    }

    @Override
    public synchronized boolean push(T item) {
        while(top + 1 >= CAPACITY) {
            try { this.wait(); }
            catch (InterruptedException e) { return false; }
        }
        boolean result = super.push(item);
        this.notifyAll();
        return result;
    }

    @Override
    public synchronized T pop() {
        while(super.empty()) {
            try { this.wait(); }
            catch (InterruptedException e) { return null; }
        }

        T result = super.pop();
        this.notifyAll();

        return result;
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }
}
