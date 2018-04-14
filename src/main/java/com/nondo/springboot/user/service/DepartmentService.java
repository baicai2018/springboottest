package com.nondo.springboot.user.service;

import com.nondo.springboot.user.bean.Department;
import com.nondo.springboot.user.map.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "department")
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 新增
     * @param department
     * @return
     */
    @CachePut(key = "#department.id")
    public Department createDepartment(Department department) {
        this.departmentMapper.addDepartment(department);
        return department;

    }

    /**
     * 修改
     * @param department
     * @return
     */
    @CachePut(key = "#department.id")
    public Department modifyDepartment(Department department) {
        this.departmentMapper.updateDepartment(department);
        return department;
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @CachePut(key = "#id")
    public Department searchDepartmentById(int id){
        Department department = this.departmentMapper.queryDepartmentById(id);
        return department;
    }

    /**
     * 删除
     * @param id
     */
    @CachePut(key = "#id")
    public void removeDepartmentById(int id){
        this.departmentMapper.deleterDepartmentById(id);
    }
}
