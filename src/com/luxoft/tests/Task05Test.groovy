package com.luxoft.tests

import com.luxoft.search.stack.Stack

class Task05Test extends GroovyTestCase {
    Stack<Integer> stack = new Stack<>()

    @Override
    protected void setUp() throws Exception {
        super.setUp()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        stack.push(6)
        stack.push(7)
        stack.push(8)
        stack.push(9)

    }

    void testStack() {
        assert !stack.empty()
        assert stack.pop() == 9
        stack.push(10)
        assert stack.pop() == 10
        assert stack.pop() == 8
        assert stack.pop() == 7
        assert stack.pop() == 6
        assert stack.pop() == 5
        assert stack.pop() == 4
        assert stack.pop() == 3
        assert stack.pop() == 2
        assert stack.pop() == 1
        assert stack.empty()

    }
}
