package com.jie.mybatis;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * MybatisTest
 *
 * @author Jie
 * @description
 * @create 2020/12/15 01:38
 */
public class MybatisTest {
    /*
     * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     *      有数据源一些运行环境信息
     * 2.获取SqlSession对象，能直接执行已经映射的sql语句
     *      sql映射文件：配置了每一个sql，以及sql的封装规则等。
     * 3.将sql映射文件注册在全局配置文件中
     * */
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            Employee employee = (Employee) session.selectOne("com.jie.mybatis.mapper.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
