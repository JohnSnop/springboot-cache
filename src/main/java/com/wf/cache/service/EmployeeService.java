package com.wf.cache.service;

import com.wf.cache.dao.EmployeeMapper;
import com.wf.cache.domain.Employee;
import com.wf.cache.domain.EmployeeExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wf
 * @create 2020-08-23 16:04
 * @desc
 **/
@Service
@Slf4j
// @CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    // @Cacheable(cacheNames = {"emp"}, condition = "#id > 0")
    // @Cacheable(cacheNames = {"emp"}, keyGenerator = "keyGenerator")
    @Cacheable(cacheNames = {"emp"})
    public Employee getById(Integer id) {
        log.info("查询员工==={}", id);
        return employeeMapper.selectByPrimaryKey(id);
    }

    // 注意缓存的key要一致
    // @CachePut(value = "emp", key = "#employee.id")
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmployee(Integer id) {
        log.info("删除员工==={}", id);
        // employeeMapper.deleteByPrimaryKey(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#name")
            },
            put = {
                    @CachePut(value = "emp", key = "#result[0].id"),
                    @CachePut(value = "emp", key = "#result[0].email")
            }
    )
    public List<Employee> getEmployeeByName(String name) {
        log.info("查询员工的名称==={}", name);
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andLastNameEqualTo(name);

        return employeeMapper.selectByExample(employeeExample);
    }
}
