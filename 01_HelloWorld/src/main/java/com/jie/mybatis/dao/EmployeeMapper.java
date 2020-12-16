package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;

/**
 * EmployeeMapper
 *
 * @author Jie
 * @description
 * @create 2020/12/15 19:58
 */
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
