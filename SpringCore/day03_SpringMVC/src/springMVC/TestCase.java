package springMVC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.testng.annotations.Test;

/**
 * Created by qiuhuadong2014 on 2015/3/4.
 */
public class TestCase {
//    @Test
    public void testHelloController(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        HelloController helloController=applicationContext.getBean("helloController",HelloController.class);
        System.out.println(helloController);
    }
//    @Test
    public void testViewResolver(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        ViewResolver viewResolver=applicationContext.getBean("viewResolver",ViewResolver.class);
        System.out.println(viewResolver);
    }
}
