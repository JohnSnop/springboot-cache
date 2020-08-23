package com.wf.cache.controller;

import com.wf.cache.domain.Employee;
import com.wf.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wf
 * @create 2020-08-23 16:06
 * @desc
 **/
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @GetMapping("/update")
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "success";
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable("name") String id) {
        return employeeService.getEmployeeByName(id);
    }

}
