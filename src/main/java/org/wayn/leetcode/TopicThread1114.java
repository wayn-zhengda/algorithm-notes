package org.wayn.leetcode;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TopicThread1114 {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

    }

    static class Foo {
        private CountDownLatch c2;
        private CountDownLatch c3;
        public Foo() {
            c2 = new CountDownLatch(1);
            c3 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            c2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            c2.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            c3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            c3.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
