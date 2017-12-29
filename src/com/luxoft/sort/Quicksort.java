package com.luxoft.sort;

public class Quicksort {

    protected int[] array;

    public Quicksort(int[] array){
        this.array = array;
    }

    public Quicksort sort(Integer start, Integer end){
        if(end >= array.length) return this;
        if(end < start) return this;

        Integer v = array[end], i = start, j = end, t;

        do {
            while (i < end && array[i] <= v) { ++i; }
            while (j > i && array[j] >= v) { --j; }
            if( i < j) {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }while (i < j);
        t = array[j];
        array[j] = array[i];
        array[i] = array[end];
        array[end] = t;

        sort(start, i - 1);
        sort(i + 1, end);
        return this;
    }

    public int[] asArray() {
        return array;
    }
}
