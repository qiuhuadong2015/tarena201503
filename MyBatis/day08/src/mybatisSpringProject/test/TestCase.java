package mybatisSpringProject.test;

import mybatisSpringProject.dao.EmpDao;
import mybatisSpringProject.dao.DeptMapper;
import mybatisSpringProject.entity.Emp;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/11.
 */
public class TestCase {
    public ApplicationContext getApplicationContext(){
        String springConfig="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(springConfig);
        return  applicationContext;
    }

//    @Test
    public void testDataSource() throws Exception{
        ApplicationContext applicationContext=this.getApplicationContext();
        DataSource dataSource=applicationContext.getBean("dataSource",DataSource.class);
        System.out.println(dataSource);

        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        System.out.println(connection.getMetaData().getDatabaseProductName());

        connection.close();
    }

//    @Test
    public void testDeptMapper(){
        ApplicationContext applicationContext=getApplicationContext();
        DeptMapper deptMapper=applicationContext.getBean("deptMapper",DeptMapper.class);
        System.out.println(deptMapper);
    }

    @Test
    public void testEmpDAO(){
        ApplicationContext applicationContext=getApplicationContext();
        EmpDao empDao=applicationContext.getBean("empDao",EmpDao.class);
        Emp emp=empDao.add("苍松",1,new Date(System.currentTimeMillis()),1000.0,null,1);

        List<Emp> list=empDao.findAll();
        System.out.println(emp+"------"+list);
    }
}
