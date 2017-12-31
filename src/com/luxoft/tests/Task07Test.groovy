package com.luxoft.tests

import com.luxoft.search.stack.NonBlockingStack

class Task07Test extends GroovyTestCase {
    void testSafeStackWaitingForData() {
        NonBlockingStack<Integer> stack = new NonBlockingStack<>()
        boolean finished = false
        Object obj = this
        new Thread(new Runnable() {
            @Override
            void run() {
                assert stack.pop() == 1
                synchronized (obj) { obj.notify(); obj.wait()  }

                assert stack.pop() == 2
                synchronized (obj) { obj.notify(); obj.wait()  }

                assert stack.pop() == 3
                finished = true
                synchronized (obj) { obj.notify(); obj.wait()  }
            }
        }).start()

        stack.push(1)
        synchronized (this){
            this.wait(1000)
        }
        stack.push(2)
        synchronized (this){
            this.notify()
            this.wait(1000)
        }

        stack.push(3)
        synchronized (this){
            this.notify()
            this.wait(1000)
        }

        assert finished
    }

    void testSafeStackWaitingForPlace() {
        NonBlockingStack<Integer> stack = new NonBlockingStack<>()
        boolean finished = false
        Object obj = this
        new Thread(new Runnable() {
            @Override
            void run() {
                for(int i = 0; i < 512 - 1; ++i){
                    stack.push(i)
                }

                stack.push(1)
                synchronized (obj) { obj.notify(); obj.wait() }
                stack.push(2)
                synchronized (obj) { obj.notify(); obj.wait() }
                stack.push(3)
                finished = true
                synchronized (obj) { obj.notify(); obj.wait() }
            }
        }).start()

        synchronized (this){ this.wait(1000) }
        assert stack.pop() == 1
        assert !finished

        synchronized (this){ this.notify(); this.wait(1000) }
        assert stack.pop() == 2
        assert !finished

        synchronized (this){ this.notify(); this.wait(1000) }
        assert stack.pop() == 3
        assert finished
    }
}
