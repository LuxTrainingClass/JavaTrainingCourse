package com.luxoft.tests

import com.luxoft.tasks.Task01
import com.luxoft.tasks.Task01BasedOnQuickSort
import com.luxoft.tasks.Task01WithSet

class Task01Test extends groovy.util.GroovyTestCase {

    void testResults() {
        Task01 task01 = new Task01()
        def res = task01.getResult([1] as int[], [2] as int[])
        assert res == [1, 2] as ArrayList<Integer>

        res = task01.getResult([1, 2] as int [], [2, 3] as int[])
        assert res == [1, 2, 3] as ArrayList<Integer>

        res = task01.getResult([1, 1, 1, 1, 1, 1] as int [], [2, 2, 2, 2, 2, 2, 2, 2, 3] as int[])
        assert res == [1, 2, 3] as ArrayList<Integer>
    }

    void testResultsBasedOnQuickSort() {
        Task01BasedOnQuickSort task01 = new Task01BasedOnQuickSort()
        def res = task01.getResult([1] as int[], [2] as int[])
        assert res == [1, 2] as int[]

        res = task01.getResult([1, 2] as int [], [2, 3] as int[])
        assert res == [1, 2, 3] as int[]

        res = task01.getResult([1, 1, 1, 1, 1, 1] as int [], [2, 2, 2, 2, 2, 2, 2, 2, 3] as int[])
        assert res == [1, 2, 3] as int[]

        res = task01.getResult([1, 1, 3, 4, 5, 3, 4, 3 ,1, 1, 1, 1] as int [], [2, 2, 2, 2, 2, 2, 2, 2, 3] as int[])
        assert res == [1, 2, 3, 4, 5] as int[]
    }

    void testResultsWithSet() {
        Task01WithSet task01WithSet = new Task01WithSet()
        def res = task01WithSet.getResult([1] as int[], [2] as int[])
        assert res == [1, 2] as Set<Integer>

        res = task01WithSet.getResult([1, 2] as int [], [2, 3] as int[])
        assert res == [1, 2, 3] as Set<Integer>

        res = task01WithSet.getResult([1, 1, 1, 1, 1, 1] as int [], [2, 2, 2, 2, 2, 2, 2, 2, 3] as int[])
        assert res == [1, 2, 3] as Set<Integer>
    }
}
