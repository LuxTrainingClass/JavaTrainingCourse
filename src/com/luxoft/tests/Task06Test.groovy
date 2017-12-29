package com.luxoft.tests

import com.luxoft.search.stack.SafeStack

class Task06Test extends GroovyTestCase {
    void testSafeStackWaitingForData() {
        SafeStack<Integer> stack = new SafeStack<>()
        boolean finished = false
        Object obj = this
        new Thread(new Runnable() {
            @Override
            void run() {
                assert stack.pop() == 1
                synchronized (obj) { obj.notify() }

                assert stack.pop() == 2
                synchronized (obj) { obj.notify() }

                assert stack.pop() == 3
                finished = true
                synchronized (obj) { obj.notify() }
            }
        }).start()

        stack.push(1)
        synchronized (this){
            this.wait(1000)
        }
        stack.push(2)
        synchronized (this){
            this.wait(1000)
        }

        stack.push(3)
        synchronized (this){
            this.wait(1000)
        }

        assert finished
    }

    void testSafeStackWaitingForPlace() {
        SafeStack<Integer> stack = new SafeStack<>()
        boolean finished = false
        Object obj = this
        new Thread(new Runnable() {
            @Override
            void run() {
                for(int i = 0; i < 512 - 1; ++i){
                    stack.push(i)
                }
                synchronized (obj) { obj.notify() }

                stack.push(1)

                stack.push(2)
                synchronized (obj) { obj.notify() }
                stack.push(3)
                finished = true
                synchronized (obj) { obj.notify() }
            }
        }).start()

        synchronized (this){ this.wait(1000) }
        assert stack.pop() == 1
        assert !finished

        synchronized (this){ this.wait(1000) }
        assert stack.pop() == 2
        assert !finished

        synchronized (this){ this.wait(1000) }
        assert stack.pop() == 3
        assert finished
    }
}
