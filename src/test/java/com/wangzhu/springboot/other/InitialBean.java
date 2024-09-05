package com.wangzhu.springboot.other;

import java.io.Serializable;

/**
 * Created by wangz on 2024/8/9 16:02.
 **/
public class InitialBean implements Cloneable, Serializable {

    {
//        printI(i);
        printI();
        printI(this.i);
        i = -1;
        printI();
        printI(this.i);
//        printI(i);


        j = -100;
        printJ();
        printJ(j);
    }

    static {
        j = -200;
        printJ();
//        printJ(j);
    }

    int i = 1;

    static int j = 1;

    static {
        j = 10;
        printJ();
        printJ(j);
    }

    {
        printI();
        printI(this.i);
        this.i = 10;
        printI();
        printI(this.i);
    }

    public InitialBean() {
        printI();
        printI(this.i);
        this.i = 20;
    }

    {
        printI();
        printI(this.i);
        this.i = 30;
        printI();
        printI(this.i);
    }

    static {
        j = 100;
        printJ();
        printJ(j);
    }

    void printI() {
        System.out.println("i = " + i);
    }

    void printI(int i) {
        System.out.println("i = " + i);
    }

    static void printJ() {
        System.out.println("j = " + j);
    }

    static void printJ(int j) {
        System.out.println("j = " + j);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
