package com.nondo.springboot.user.map;

import com.nondo.springboot.user.bean.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void testaddDepartment(){
        Department department = new Department("信息部","主管信息事物");
        department.setId(2);
        departmentMapper.addDepartment(department);
    }

    @Test
    public void testGetDepartments(){
        Department department = new Department("信息部","主管信息事物");
        List<Department> departments = this.departmentMapper.getDepartmentsByCondition(department);
        System.out.println(departments);
    }

}