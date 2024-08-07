package com.wangzhu.springboot.abstractclass;

/**
 * Created by wangz on 2024/8/2 15:10.
 **/
public interface OneInterface {
    int a = 1;
    String str = "";

    void calc();

    static void pp() {
        System.out.println("pp");
    }

    default void cc() {
        System.out.println("cc");
    }
}
