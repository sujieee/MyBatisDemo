package com.jie.mybatis;

import com.jie.mybatis.bean.Employee;
import com.jie.mybatis.dao.EmployeeMapper;
import com.jie.mybatis.dao.EmployeeMapperAnnotation;
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
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            Employee employee = (Employee) session.selectOne("com.jie.mybatis.dao.EmployeeMapper.getEmpById", 1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //接口式编程
    /*
    * 1.接口式编程
    *   原生： Dao ===> DaoImpl
    *   Mybatis: Mapper ===> xxMapper.xml
    * 2.SqlSession 代表和数据库的一次会话；用完必须关闭（释放资源）;
    * 3.SqlSession和connection一样，都是非线程安全的。每次使用都应该去获取新的对象
    * 4.mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
    *                   （将接口和xml绑定）
    * 5.两个重要的配置文件：
    *       mybatis的全局配置文件：包含数据库连接池信息，事务管理器等。。。系统运行环境信息。。。
    *       sql映射文件：保存了每一个sql语句的映射信息
    *               将sql抽取出来
    * */
    @Test
    public void test1() throws IOException {
        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2.获取SqlSession对象
        //3.获取接口的实现类对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //mybatis会为接口自动创建一个代理对象，代理对象去执行增删改查
            System.out.println(mapper.getClass());
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2.获取SqlSession对象
        //3.获取接口的实现类对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            //mybatis会为接口自动创建一个代理对象，代理对象去执行增删改查
            System.out.println(mapper.getClass());
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
