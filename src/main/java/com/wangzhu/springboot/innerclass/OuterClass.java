package com.wangzhu.springboot.innerclass;

/**
 * Created by wangz on 2024/8/1 18:09.
 **/
public class OuterClass {
    private int n;
    private static int m;

    {
        n = 1;
        m = 2;
        System.out.println("OuterClass init");
    }

    static {
//        n = 3;
        m = 3;
        System.out.println("OuterClass static init");
    }

    void show() {
        System.out.println("n = " + n);
        System.out.println("m = " + m);
    }

    static void print() {
//        System.out.println("n = " + n);
        System.out.println("m = " + m);

        class MyMethodInnerClass{
            private int a;
            private int b;
            void print(){

            }
        }
        new MyMethodInnerClass().print();
    }

    abstract class AbstractInnerClass {
        {
            System.out.println("AbstractInnerClass init");
        }
    }

    public class InnerClass extends AbstractInnerClass implements Runnable {

        @Override
        public void run() {

        }

        private int a;
        // 成员内部类内部不可以有静态信息（静态变量、静态块、静态方法）
//        private static int b;

        {
            a = 1;
            System.out.println("InnerClass init");
        }

//        static {
//
//        }

        void innerShow() {
            System.out.println("a = " + a);
            show();
            print();
        }

//        static void innerPrint() {
//
//        }
    }

    static abstract class AbstractStaticInnerClass {
        static {
            System.out.println("AbstractStaticInnerClass static init");
        }

        {
            System.out.println("AbstractStaticInnerClass init");
        }
    }

    public static class StaticInnerClass extends AbstractStaticInnerClass implements Runnable {

        @Override
        public void run() {

        }

        // 静态内部类中可以定义成员变量+静态变量+成员代码块+静态代码块
        private int sa;
        private static int sb;

        {
            sa = 1;
            sb = 2;
            System.out.println("StaticInnerClass init");

        }

        static {
            sb = 3;
            System.out.println("StaticInnerClass static init");
        }

        void staticInnerShow() {
            System.out.println("sa = " + sa);
            System.out.println("sb = " + sb);

            // show();
            // 只能调用外部的静态方法
            print();
        }

        static void staticInnerPrint() {
            System.out.println("sb = " + sb);
            print();

            // 匿名类
            new Runnable() {
                // 不能有静态信息

//                static void calc() {
//
//                }

                void show() {

                }

                @Override
                public void run() {

                }
            }.run();

            // 方法内部类 局部内部类
            // 不能被static修饰类
            class MethodInnerClass {
                int a;

                void print() {

                }
            }

            new MethodInnerClass().print();
        }
    }

    static class StaticInnerClassNew {
        static {
            System.out.println("StaticInnerClassNew static init");
        }
    }
}
