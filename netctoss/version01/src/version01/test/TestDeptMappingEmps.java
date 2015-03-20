package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.DeptDao;
import version01.entity.Dept;

/**
 * Created by qiuhuadong2014 on 2015/3/19.
 */
public class TestDeptMappingEmps {
//    @Test
    public void testDeptFindById_BySubSelect(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        DeptDao deptDao=applicationContext.getBean(DeptDao.class);

        Dept dept=deptDao.findById_WithEmps_BySubSelect(10);
        System.out.println(dept);

    }

    @Test
    public void testDeptFindById_ByJoin(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        DeptDao deptDao=applicationContext.getBean(DeptDao.class);

        Dept dept=deptDao.findById_WithEmps_ByJoin(10);
        System.out.println(dept);

    }
}
