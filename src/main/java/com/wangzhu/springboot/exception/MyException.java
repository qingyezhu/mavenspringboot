package com.wangzhu.springboot.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by wangz on 2024/8/2 16:41.
 **/
public class MyException {

    void print() throws Exception {
        throw new Exception("");
    }

    void show() {
        throw new ArrayIndexOutOfBoundsException("");
    }

    void calc() throws FileNotFoundException {
        // throws 必须是FileNotFoundException或其父类
        // 抛出了非运行时异常，即检查性异常，方法需要声明异常
        throw new FileNotFoundException("");
    }

    void handle() {
        try {
            calc();
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        } catch (Exception e) {

        }
    }
}
