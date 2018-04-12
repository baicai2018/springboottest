package com.nondo.springboot.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private Runnable runnable;

    @GetMapping("/helloworld")
    public String helloworld() {
        return "<h1>helloworld</h1>";
    }
    @GetMapping("/helloworld5")
    public String helloworld5() {
        return "<h1>helloworld5</h1>";

    }

    @GetMapping("/helloworld6")
    public String helloworld6() {

        runnable.run();
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        return "<h1>helloworld6</h1>";
    }
}