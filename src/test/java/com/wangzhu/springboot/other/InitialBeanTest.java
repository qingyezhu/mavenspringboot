package com.wangzhu.springboot.other;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Created by wangz on 2024/8/9 15:56.
 **/
public class InitialBeanTest {

    @Test
    public void testBeanForClassForName() throws Exception {
        Class<?> clazz = Class.forName("com.wangzhu.springboot.other.InitialBean");
    }

    @Test
    public void testBeanForClassLoader() throws Exception {
        Class<?> clazz = this.getClass().getClassLoader().loadClass("com.wangzhu.springboot.other.InitialBean");
        System.out.println("loadClass finish");
    }

    @Test
    public void testForNewInstance() {
        InitialBean initialBean = new InitialBean();
        System.out.println("newInstance finish");
        initialBean.printI();
    }

    @Test
    public void testForClone() throws Exception {
        InitialBean initialBean = new InitialBean();
        System.out.println("new finish");
        initialBean.printI();

        InitialBean initialBean1 = (InitialBean) initialBean.clone();
        // 不触发实例初始化，不会执行实例块
        System.out.println("clone finish");
        initialBean1.printI();

    }

    @Test
    public void testForSerializable() throws Exception {
//        InitialBean initialBean = new InitialBean();
//        System.out.println("new finish");
//        initialBean.printI();
//
        String fileName = "initialBean.tmp";
//        FileOutputStream fos = new FileOutputStream(fileName);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(initialBean);

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        InitialBean copy = (InitialBean) ois.readObject();
        // 不触发实例初始化，不会执行实例块
        System.out.println("serializable finish");
        copy.printI();
    }

    @Test
    public void testForClassNewInstance() throws Exception{
        Class<?> aClass = Class.forName("com.wangzhu.springboot.other.InitialBean");
        System.out.println("class.forname finish");
        Object o1 = aClass.newInstance();
        System.out.println("class newInstance finish");
        Object o2 = aClass.newInstance();
        System.out.println("class newInstance finish");
    }

    @Test
    public void testForConstructorNewInstance()throws Exception{
        Class<?> aClass = Class.forName("com.wangzhu.springboot.other.InitialBean");
        System.out.println("class.forname finish");

//        Constructor<?>[] constructors = aClass.getConstructors();
//        for(Constructor<?> constructor : constructors){
//            Object o = constructor.newInstance();
//            System.out.println("constructor newInstance finish");
//        }

        Constructor<?> constructor = aClass.getConstructor();
        Object o1 = constructor.newInstance();
        System.out.println("constructor newInstance finish");
    }
}
