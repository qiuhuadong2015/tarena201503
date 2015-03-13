package day03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiuhuadong2014 on 2015/3/4.
 */
public class TestCase {
//    @Test
    public void testHelloWorld(){
        String config = "spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        HelloWorld helloWorld=applicationContext.getBean("helloWorld",HelloWorld.class);
        System.out.println(helloWorld);
    }

//    @Test
    public void testCode(){
        String config = "spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        Code code1=applicationContext.getBean("code",Code.class);
        Code code2=applicationContext.getBean("code",Code.class);
        System.out.println(code1);
        System.out.println(code2);

    }

//    @Test
    public void testComment(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        Comment comment=applicationContext.getBean("comment",Comment.class);
        System.out.println(comment);
    }

    @Test
    public void testDemoBean(){
        String config = "spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        DemoBean demoBean = applicationContext.getBean("demoBean",DemoBean.class);
        System.out.println(demoBean);
    }
}
