package com.luxoft.tasks;

import com.luxoft.sort.JoinQuicksort;

public class Task01BasedOnQuickSort extends Task01 {

    public static void main(String[] args) {
        new Task01BasedOnQuickSort().Do();
    }

    @Override
    protected Object getResult(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        c = new JoinQuicksort(c).sort(0, c.length - 1).asArray();
        return c;
    }
}
