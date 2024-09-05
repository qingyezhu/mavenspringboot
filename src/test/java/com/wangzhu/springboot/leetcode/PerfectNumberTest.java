package com.wangzhu.springboot.leetcode;

import org.junit.jupiter.api.Test;

/**
 * Created by wangz on 2024/8/29 14:59.
 **/
public class PerfectNumberTest {

    @Test
    public void test(){
        int n = 500000;

        for (int i = 1; i <= n; i ++) {

            int m = i;

            int sum = 0;
            for (int j = 1; j <= m/2; j ++) {
                if (m % j == 0) {
                    sum += j;
                }
            }
            if (sum == m) {
                System.out.println(m);
            }
        }

    }
}
