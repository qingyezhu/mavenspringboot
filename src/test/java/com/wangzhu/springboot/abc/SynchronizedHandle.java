package com.wangzhu.springboot.abc;

/**
 * Created by wangz on 2024/8/7 17:51.
 **/
public class SynchronizedHandle implements SynHandle {

    int c;

    final int times;

    public SynchronizedHandle(int times) {
        this.times = times;
    }

    @Override
    public void handle(HandlerCallback callback) {
        for (int i = 0; i < times; i++) {
            selfHandle(callback);
        }
    }

    synchronized void selfHandle(HandlerCallback callback) {
        while (!callback.canCallback(c)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        callback.callback();
        c++;
        notifyAll();
    }
}
