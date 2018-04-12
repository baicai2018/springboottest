package com.nondo.springboot.user.repository;

import com.nondo.springboot.user.bean.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * 测试新增用户
     * @return
     */
    @Test
    public void addRole(){
        Role role = new Role("系统管理员","系统管理");
        roleRepository.save(role);
    }

    /**
     * 测试用户更新
     */
    @Test
    public void updateRole(){
        Role role = new Role("安全管理员","安全管理");
        role.setId(1);
        roleRepository.save(role);
    }

    /**
     * 查询测试
     */
    @Test
    public void testSearch(){
        Role role = this.roleRepository.findOne(1);
        if(role != null){
            System.out.println(role);
        }
    }

    /**
     * 删除测试
     */
    @Test
    public void testDelete(){
        Role role = new Role("系统管理员","系统管理员");
        role.setId(1);
        this.roleRepository.delete(role);
        System.out.println("用户"+role.getName()+"已被删除！");
    }

    /**
     * 批量删除角色
     */
    @Test
    public void testDeleteRoles(){

        List<Role> roles = new ArrayList<>();
        Role role1 = new Role("系统管理员","系统管理员");
        role1.setId(2);
        Role role2 = new Role("安全管理员","安全管理员");
        role2.setId(7);
        roles.add(role1);
        roles.add(role2);
        this.roleRepository.delete(roles);
    }
}