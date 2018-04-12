package com.nondo.springboot.user.map;

import com.nondo.springboot.user.bean.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门mapper
 * @author nondo
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 新增
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 修改
     * @param department
     * @return
     */
    int updateDepartment(Department department);

    /**
     * 删除
     * @param id
     */
    void deleterDepartmentById(int id);

    /**
     * 查询
     * @param id
     * @return
     */
    Department queryDepartmentById(int id);

    /**
     * 条件查询部门信息
     * @param department
     * @return
     */
    List<Department> getDepartmentsByCondition(Department department);
}
