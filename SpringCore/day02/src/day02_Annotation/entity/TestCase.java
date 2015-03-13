package day02_Annotation.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class TestCase {
//    @Test
    public void testDataSource(){
        String cfg="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(cfg);
        JdbcDataSource jdbcDataSource=applicationContext.getBean("dataSource",JdbcDataSource.class);
        try {
            Connection conn=jdbcDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    @Test
    public void testUserDAO(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        UserDAO userDAO=applicationContext.getBean("userDAO",UserDAO.class);
        User user=userDAO.findByName("qhd");
        System.out.println("testUserDAO:"+user);
    }

//    @Test
    public void testLogin(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        UserService userService=applicationContext.getBean("userService",UserService.class);
        User user=userService.login("qhd","qhd");
        System.out.println("testLogin:"+user);
    }

    @Test
    public void testExpDemo(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        Properties properties=applicationContext.getBean("jdbcProperties",Properties.class);

    }
}
