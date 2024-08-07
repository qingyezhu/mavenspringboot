package com.wangzhu.springboot.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangz on 2024/8/7 18:09.
 **/
public class ReentrantLockHandle implements SynHandle {

    int c;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    final int times;

    public ReentrantLockHandle(int times) {
        this.times = times;

        init();
    }

    void init() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    public void handle(HandlerCallback callback) {
        for (int i = 0; i < times; i++) {
            selfHandle(callback);
        }
    }

    void selfHandle(HandlerCallback callback) {
        lock.lock();
        try {
            while (!callback.canCallback(c)) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            c++;
            callback.callback();

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
