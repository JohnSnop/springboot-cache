package com.wf.cache.service;

import com.wf.cache.dao.DepartmentMapper;
import com.wf.cache.domain.Department;
import com.wf.cache.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wf
 * @create 2020-08-23 22:15
 * @desc
 **/
@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = {"dept"})
    public Department getById(Integer id) {
        log.info("查询部门==={}", id);
        return departmentMapper.selectByPrimaryKey(id);
    }

}
