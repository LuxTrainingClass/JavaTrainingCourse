package com.luxoft.search.stack;

import java.util.concurrent.atomic.AtomicReference;

public class NonBlockingStack<T> {

    class Node<V> {
        private V item;
        private Node<T> next;

        public Node(V item) {
            this.item = item;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public V getItem() {
            return item;
        }
    }
//https://habrahabr.ru/post/244881/
    private AtomicReference<Node<T>> head = new AtomicReference<>();

    public boolean empty() {
        return head.get() == null;
    }

    //Complexity ~ O(1)
    public boolean push(T item) {
        Node<T> node = new Node<>(item);
        Node<T> current;

        do {
            current = head.get();
            node.setNext(current);
        }while(!head.compareAndSet(current, node));

        return true;
    }

    //Complexity ~ O(1)
    public T pop() {
        Node<T> currentHead;
        Node<T> futureHead;
        do {
            currentHead = head.get();
            if (currentHead == null) {
                return null;
            }
            futureHead = currentHead.next;
        } while (!head.compareAndSet(currentHead, futureHead));

        return currentHead.getItem();
    }
}
