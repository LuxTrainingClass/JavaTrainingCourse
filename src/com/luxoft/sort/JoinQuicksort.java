package com.luxoft.sort;

public class JoinQuicksort extends Quicksort {

    public JoinQuicksort(int[] array) {
        super(array);
    }

    @Override
    public int[] asArray() {
        int[] tmp = new int[array.length];
        int v = array[0], i = 1, index = 0;
        tmp[0] = v;
        while ( i < array.length){
            if (array[i] != v) {
                v = array[i];
                tmp[++index] = v;
            }
            ++i;
        }

        int[] c = new int[++index];
        System.arraycopy(tmp, 0, c, 0, c.length);

        return c;
    }
}
