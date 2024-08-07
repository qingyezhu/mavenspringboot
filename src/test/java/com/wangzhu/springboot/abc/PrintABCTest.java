package com.wangzhu.springboot.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangz on 2024/8/7 16:40.
 **/
public class PrintABCTest {

    final static String[] PRINT_STR_ARR = {"A", "B", "C", "D", "E"};

    public static void main(String[] args) {
        final int times = 5;
//        SynHandle synHandle = createSynchronizedHandle(times);
        SynHandle synHandle = createReentrantLockHandle(times);

        String[] strArr = PRINT_STR_ARR;

        List<HandlerRunner> runnerList = new ArrayList<>();
        for (int i = 0, len = strArr.length; i < len; i++) {
            String str = strArr[i];
            HandlerCallback callback = createCallback(i, str);
            HandlerRunner runner = createRunner(callback, synHandle);
            runnerList.add(runner);
        }

//        execForThread(runnerList);

        execForExecutorPool(runnerList);
    }

    static void execForThread(List<HandlerRunner> runnerList) {
        for (HandlerRunner runner : runnerList) {
            new Thread(runner).start();
        }
    }

    static void execForExecutorPool(List<HandlerRunner> runnerList) {
        ExecutorService executorService = Executors.newFixedThreadPool(PRINT_STR_ARR.length + 1);

        for (HandlerRunner runner : runnerList) {
            executorService.execute(runner);
        }

        executorService.shutdown();
    }


    static SynHandle createSynchronizedHandle(int times) {
        return new SynchronizedHandle(times);
    }

    static SynHandle createReentrantLockHandle(int times) {
        return new ReentrantLockHandle(times);
    }

    static HandlerRunner createRunner(HandlerCallback callback, SynHandle handle) {
        return new HandlerRunner(callback, handle);
    }

    static HandlerCallback createCallback(int flag, String str) {
        return new HandlerCallback() {
            @Override
            public boolean canCallback(int c) {
                return checkForCallback(c, flag);
            }

            @Override
            public void callback() {
                print(str);
            }
        };
    }

    static int c;

    static void print(String str) {
        System.out.println((++c) + " " + Thread.currentThread().getName() + ": " + str);
    }

    static boolean checkForCallback(int c, int flag) {
        return c % PRINT_STR_ARR.length == flag;
    }

}
