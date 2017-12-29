package com.luxoft.tasks;

import com.luxoft.search.stack.SafeStack;

public class Task06 {
    public static void main(String[] args) {
        new Task06().Do();
    }

    private void Do() {
        SafeStack<Integer> stack = new SafeStack<>();

        new Thread(() -> {
            int index = 0;
            while (stack.push(++index));
        }).start();

        new Thread(() -> getter(new Object(), stack)).start();
        new Thread(() -> getter(new Object(), stack)).start();
        new Thread(() -> getter(new Object(), stack)).start();
    }

    private void getter(Object obj, SafeStack<Integer> stack){
        Integer value;
        int count = 0;
        while (null != (value = stack.pop())){
            System.out.println(value);
            if (count < 1000) ++count;
            else synchronized (obj){
                try { obj.wait(100);
                } catch (InterruptedException e) { return; }
            }
        }
    }
}
