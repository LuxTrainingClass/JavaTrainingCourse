package com.luxoft.tasks;

import java.util.HashSet;
import java.util.Set;

public class Task01WithSet extends Task01 {

    public static void main(String[] args) {
        new Task01WithSet().Do();
    }

    @Override
    protected Object getResult(int[] a, int[] b) {
        Set<Integer> result = new HashSet<>();
        addAll(result, a);
        addAll(result, b);

        return result;
    }

    private void addAll(Set<Integer> result, int[] array) {
        for (int i: array) {
            result.add(i);
        }
    }
}
