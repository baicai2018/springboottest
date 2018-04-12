package com.nondo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * thymeleaf控制层
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeLeafController {

    /**
     *测试thymeleaf
     * @param map
     * @return
     */
    @RequestMapping("hello")
    public String helloLeaf(Map<String,Object> map){
        map.put("msg","hello thymeleaf");
        return "/thymeleaf/hello";
    }

}
