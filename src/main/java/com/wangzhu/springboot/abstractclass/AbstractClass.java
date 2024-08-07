package com.wangzhu.springboot.abstractclass;

/**
 * Created by wangz on 2024/8/2 15:08.
 **/
public abstract class AbstractClass {
    private int a;
    private static int b;

    {
        a = 1;
        b = 2;
        System.out.println("AbstractClass init");
    }

    static {
        b = 3;
        System.out.println("AbstractClass static init");
    }

    protected void show() {
        System.out.println("show");
    }

    abstract void print();
}
