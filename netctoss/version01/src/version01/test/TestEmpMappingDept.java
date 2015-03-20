package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.EmpDao;
import version01.entity.Emp;

/**
 * Created by qiuhuadong2014 on 2015/3/19.
 * Unti04关联映射测试类
 */
public class TestEmpMappingDept {
//    @Test
    public void testFindById_WithDept_BySubSelect(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Emp emp=empDao.findById_WithDept_BySubSelect(1);
        System.out.println(emp);
    }

    @Test
    public void testFindById_WithDept_ByJoin(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Emp emp=empDao.findById_WithDept_ByJoin(1);
        System.out.println(emp);
    }
}
