package com.wangzhu.springboot.innerclass;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by wangz on 2024/8/2 0:22.
 **/
public class InnerClassTest {

    @Test
    public void testStaticInnerClass() {
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
    }

    @Test
    public void testInnerClass() {
        OuterClass outerClass = new OuterClass();
        System.out.println("-------------------");
        OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();

        System.out.println("-------------------");
        OuterClass.InnerClass innerClass2 = new OuterClass().new InnerClass();
        System.out.println("-------------------");
    }

    @Test
    public void testClassName() {
        try {
            Class<?> aClass = Class.forName("com.wangzhu.springboot.innerclass.OuterClass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLambda() {
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).boxed().forEach(i -> new Runnable() {
            @Override
            public void run() {
                System.out.println("i = " + i);
            }
        }.run());
    }
}
