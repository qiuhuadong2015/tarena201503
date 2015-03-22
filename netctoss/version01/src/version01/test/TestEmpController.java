package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.control.EmpController;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 */
public class TestEmpController {

    @Test
    public void testEmpController(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpController empController=applicationContext.getBean(EmpController.class);


        System.out.println(empController.getClass().toString());
        empController.find();
    }

}
