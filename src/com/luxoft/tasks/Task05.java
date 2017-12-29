package com.luxoft.tasks;

import com.luxoft.search.stack.Stack;

public class Task05 {
    public static void main(String[] args) {
        new Task05().Do();
    }

    public void Do (){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);
    }
}
