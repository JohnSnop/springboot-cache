package com.wf.cache.dao;


import com.wf.cache.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wf
 * @create 2020-08-23 15:55
 * @desc
 **/
@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test1() {
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println(employee);
    }

}