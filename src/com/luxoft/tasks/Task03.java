package com.luxoft.tasks;

import com.luxoft.sort.Quicksort;

public class Task03 extends Task01 {

    public static void main(String[] args) {
        new Task03().Do();
    }

    public void Do() {
        int[] a = getRandomArray();
        int[] b = getRandomArray();

        sort(a);
        sort(b);

        printArray(a);
        printArray(b);

    }

    protected int[] sort(int[] a) {
        return new Quicksort(a).sort(0, a.length - 1).asArray();
    }
}
