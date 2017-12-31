package com.luxoft.tasks;

import com.luxoft.search.stack.NonBlockingStack;

public class Task07 {
    public static void main(String[] args) {
        new Task07().Do();
    }

    private void Do() {
        NonBlockingStack<Integer> stack = new NonBlockingStack<>();

        new Thread(() -> {
            int index = 0;
            while (stack.push(++index));
        }).start();

        new Thread(() -> getter(new Object(), stack)).start();
        new Thread(() -> getter(new Object(), stack)).start();
        new Thread(() -> getter(new Object(), stack)).start();
    }

    private void getter(Object obj, NonBlockingStack<Integer> stack){
        Integer value;
        while (null != (value = stack.pop())){
            System.out.println(value);
        }
    }
}
