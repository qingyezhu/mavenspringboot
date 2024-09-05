package com.wangzhu.springboot.threadpool;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by wangz on 2024/8/8 14:53.
 **/
public class ThreadPoolTest {

    static final Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);

    public static void main(String[] args) {
        testShutdown();
    }

    static void testShutdown() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));
        for (int i = 0; i < 10; i++) {
            final int j = i;
            threadPoolExecutor.execute(() -> {
                logger.info("start {}", j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("end {}", j);
            });
        }

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
        logger.info("finally end");
    }
}
