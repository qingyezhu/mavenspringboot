package com.wangzhu.springboot.abc;

/**
 * Created by wangz on 2024/8/7 17:46.
 **/
public interface HandlerCallback {

    boolean canCallback(int c);

    void callback();
}
