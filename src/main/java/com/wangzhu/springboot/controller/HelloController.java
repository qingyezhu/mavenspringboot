package com.wangzhu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangz on 2024/7/25 15:25.
 **/
@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "spring boot web hello";
    }
}
