package com.luxoft.tests

import com.luxoft.tasks.Task03

class Task03Test extends GroovyTestCase {
    void testSort() {
        Task03 task03 = new Task03()
        assert task03.sort([3,2,1] as int[]) == [1,2,3]
        assert task03.sort([3,5,2,7,1,140] as int[]) == [1,2,3,5,7,140]
        assert task03.sort([1,2,3,5,7,140] as int[]) == [1,2,3,5,7,140]
    }
}
