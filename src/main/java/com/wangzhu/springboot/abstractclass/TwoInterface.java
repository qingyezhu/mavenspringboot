package com.wangzhu.springboot.abstractclass;

/**
 * Created by wangz on 2024/8/2 15:12.
 **/
public interface TwoInterface {

    default void twoC() {
        System.out.println("twoC");
    }
}
