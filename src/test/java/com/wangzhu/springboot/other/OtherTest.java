package com.wangzhu.springboot.other;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by wangz on 2024/8/4 16:11.
 **/
public class OtherTest {

    static class Super {
        public static String getType(Collection<?> col) {
            return "super:collection";
        }

        public static String getType(List<?> list) {
            return "super:list";
        }

        public static String getType(Set<?> set) {
            return "super:set";
        }

        public String getType(ArrayList<?> list) {
            return "super:arraylist";
        }

        public String getType(HashSet<?> set) {
            return "super:hashset";
        }
    }

    static class Sub extends Super {
        public static String getType(Collection<?> col) {
            return "sub:collection";
        }
    }

    @Test
    public void testCollection() {
        // 静态方法只会是重载，而不是重写
        Collection<?>[] cols = {new ArrayList<String>(), new HashSet<String>(), new HashMap<String, String>().values()};

        Super sub = new Sub();
        for (Collection<?> col : cols) {
            System.out.println(sub.getType(col));
        }
    }

    static class A {
        public static String staticStr = "A's static field";
        public String nonStaticStr = "A's nonstatic field";

        public static void staticMethod() {
            System.out.println("A's static method");
        }

        public void nonStaticMethod() {
            System.out.println("A's nonstatic method");
        }
    }

    static class B extends A {
        public static String staticStr = "B's static field";
        public String nonStaticStr = "B's nonstatic field";

        public static void staticMethod() {
            System.out.println("B's static method");
        }
    }

    static class C extends A {

    }

    @Test
    public void testABC() {
        C c = new C();
        System.out.println(c.nonStaticStr);  //A's nonstatic field
        System.out.println(c.staticStr);  //A's static field
        c.staticMethod(); //A's static method

        System.out.println("-------------------------------");

        A c1 = c;
        System.out.println(c1.nonStaticStr);  //A's nonstatic field
        System.out.println(c1.staticStr);  //A's static field
        c1.staticMethod(); //A's static method

        // 以上这说明java中静态属性和静态方法可以被继承

        System.out.println("-------------------------------");
        B b = new B();
        System.out.println(b.nonStaticStr); // B's nonstatic field
        System.out.println(b.staticStr);   //B's static field
        b.staticMethod();  //B's static method

        System.out.println("-------------------------------");
        A b1 = b;
        System.out.println(b1.nonStaticStr);  //A's nonstatic field
        System.out.println(b1.staticStr);  //A's static field
        b1.staticMethod(); //A's static method
        //b1.nonStaticStr  输出的是父类的非静态属性，说明非静态属性不可以被重写，不能实现多态
        //b1.staticStr     输出的是父类的静态属性，说明静态属性不可以被重写，不能实现多态
        //b1.staticMethod()输出的是父类A的静态方法，不是子类B改写后的，所以没有实现多态


        //结论是：静态属性和静态方法只是可以继承没有表现出多态性。
        //因为静态方法和静态属性没有采用动态绑定。具体表现就是，
        //将子类实例向上转型则会调用到基类中的静态方法和属性，
        //不转型就调用子类自身的静态方法和属性。
        //编译器不推荐通过实例去调用静态方法和属性，因为这种调用方式容易造成混淆。

        //实际上，在Java的规范中，Java对于类的方法和属性采用了两种完全不同的处理机制：
        //对于方法，使用重载机制实现了多态性；对于属性，使用的是同名属性隐藏机制。
        //所谓的同名属性隐藏机制是指：在具有父子关系的两个类中，
        //子类中相同名字的属性会使得从父类中继承过来的同名属性变得不可见，
        //不管类型是否一致，名称一致的两个属性就是同名属性。
        //在子类中，无法简单地通过属性名称来获取父类中的属性，
        //而是必须通过父类名称加属性名称(super.变量名)的方法才可以访问父类中的该属性。
        //一般而言，为了代码容易阅读，极其不建议在父类和子类中使用同名属性。
    }

}
