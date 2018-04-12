package com.nondo.springboot.controller.fastjson;

import com.nondo.maven.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
@Api(value="fastjson测试",tags = {"测试接口"})
@Controller
@RequestMapping("fastjson")
public class FastjsonController {

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name",value = "用户名",dataType = "String",paramType = "query")
    @RequestMapping("/test")
    @ResponseBody
    public User test(){
        User user = new User(1,"zhangsan","123456",new Date());
         int i = 1/0;
        return user;
    }

@RequestMapping("/hello")
@ResponseBody
    public String test2(){
        return "<h1>aaa</h1>";
    }
}
