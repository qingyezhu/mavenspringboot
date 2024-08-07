package com.wangzhu.springboot.abc;

/**
 * Created by wangz on 2024/8/7 17:18.
 **/
public class HandlerRunner implements Runnable {

    final HandlerCallback callback;
    final SynHandle handle;

    public HandlerRunner(HandlerCallback callback, SynHandle handle) {
        this.handle = handle;
        this.callback = callback;
    }

    @Override
    public void run() {
        handle.handle(callback);
    }
}
