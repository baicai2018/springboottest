package com.nondo.springboot.user.dao;

import com.nondo.springboot.user.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * 新增测试
     */
    @Test
    public void testAdd() {
        User user = new User("张三", "zhangsan", new Date());
        int result = userDao.addUser(user);
        System.out.println(result);
    }

    /**
     * 修改测试
     */
    @Test
    public void textUpdate() {
        User user = new User("李四", "zhangsan", new Date());
        user.setId(3);
        int result = this.userDao.updateUser(user);
        System.out.println(result);
    }

    /**
     * 查询测试
     */
    @Test
    public void testQuery() {

        User user = this.userDao.queryUserById(1);
        if (user != null) {
            System.out.println(user.toString());
        }
    }

}
