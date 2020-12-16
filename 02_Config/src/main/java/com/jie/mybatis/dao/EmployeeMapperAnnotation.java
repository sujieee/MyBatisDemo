package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * EmployeeMapperAnnotation
 *
 * @author Jie
 * @description
 * @create 2020/12/16 13:03
 */
public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id = #{id}")
    public Employee getEmpById(Integer id);
}
