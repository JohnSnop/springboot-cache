package com.wf.cache.controller;

import com.wf.cache.domain.Department;
import com.wf.cache.domain.Employee;
import com.wf.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-08-23 22:16
 * @desc
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department getEmployee(@PathVariable Integer id) {
        return departmentService.getById(id);
    }
}
