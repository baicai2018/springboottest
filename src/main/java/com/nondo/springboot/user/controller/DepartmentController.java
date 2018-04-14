package com.nondo.springboot.user.controller;

import com.nondo.springboot.user.bean.Department;
import com.nondo.springboot.user.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("department")
@ResponseBody
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 新增
     * @param department
     * @return
     */
    @RequestMapping("save")
    public Map<String, Object> saveDepartment(Department department) {

        Department dept = this.departmentService.createDepartment(department);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        return map;
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @RequestMapping("get/{id}")
    public Map<String,Object> get(@PathVariable("id") int id){
        Department department = this.departmentService.searchDepartmentById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","获取成功");
        map.put("data",department);
        return map;
    }

    /**
     * 修改
     * @param department
     * @return
     */
    @RequestMapping("update")
    public Map<String,Object> update(Department department){
        this.departmentService.modifyDepartment(department);
        Map<String,Object> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","修改成功");
        return map;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    public Map<String,Object> deleter(@PathVariable("id") int id){
        this.departmentService.removeDepartmentById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","删除成功");
        return map;
    }
}
