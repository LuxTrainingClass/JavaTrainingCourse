package com.luxoft.tasks;


import com.luxoft.sort.Quicksort;

import java.util.ArrayList;
import java.util.Random;

public class Task01 {

    public static void main(String[] args) {
        new Task01().Do();
    }

    public void Do() {
        int[] a = getRandomArray();
        int[] b = getRandomArray();

        printArray(a);
        System.out.println('+');
        printArray(b);
        System.out.println('=');
        System.out.println(getResult(a, b));
    }

    protected Object getResult(int[] a, int[] b) {
        new Quicksort(a).sort(0, a.length - 1);
        new Quicksort(b).sort(0, b.length - 1);
        ArrayList<Integer> c = new ArrayList<>();
        int count = a.length + b.length;
        int i = 0, j = 0, ai = a[0], bj = b [0];
        for(int k = 0; k < count; ++k){
            if(ai < bj){
                if(c.size() > 0) {
                    if(c.get(c.size() - 1) != ai) {
                        c.add(ai);
                    }
                } else c.add(ai);
                if(i < a.length - 1) ai = a[++i];
                else  ai = Integer.MAX_VALUE;
            } else {
                if(c.size() > 0) {
                    if(c.get(c.size() - 1) != bj) {
                        c.add(bj);
                    }
                } else  c.add(bj);
                if(j < b.length - 1) bj = b[++j];
                else  bj = Integer.MAX_VALUE;
            }
        }
        return c;
    }

    protected void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0 ; i < array.length; ++i) {
            sb.append(array[i]);
            if( i != array.length - 1 )
                sb.append(',').append(' ');
        }
        System.out.println(sb.append(']').toString());
    }

    protected int[] getRandomArray() {
        Random randNumber = new Random();
        int[] array =  new int[randNumber.nextInt(5) + 1];

        for(int i = 0; i < array.length; ++i){
            array[i] = randNumber.nextInt(100);
        }

        return array;
    }
}
