package com.wangzhu.springboot.abstractclass;

/**
 * Created by wangz on 2024/8/2 15:11.
 **/
public class MyClass extends AbstractClass implements OneInterface, TwoInterface {

    @Override
    void print() {
        System.out.println("print");
    }

    @Override
    public void calc() {
        System.out.println("calc");
    }
}
