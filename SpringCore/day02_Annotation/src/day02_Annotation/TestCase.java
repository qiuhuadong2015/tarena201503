package day02_Annotation;

import day02_Annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class TestCase {
    @Test
    public void testUserService(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        UserService userService=applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        System.out.println(userService.getUserDAO());
    }
}
