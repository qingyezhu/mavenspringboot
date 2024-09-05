package com.wangzhu.springboot.other;

/**
 * Created by wangz on 2024/8/9 10:07.
 **/
public class ConstantPool {

    String str1a = "1a";
    String str1b = "1b";

    static String str2a = "2a";
    static String str2b = "2b";

    {
        System.out.println(str1a);
        System.out.println(str2b);
    }

    public static void main(String[] args) {
        String str1 = "a";

        String str2 = "b";

        String str3 = str1 + str2;


        System.out.println(str3);
    }
}
