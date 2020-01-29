package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 * 思路:这个题描述的..不看答案都不知道啥意思..就是简单的并发控制..
 */
public class Solution1114 {
}


class Foo {

    private boolean firstFinished = false;
    private boolean secondFinished = false;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!firstFinished) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!secondFinished) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }
}