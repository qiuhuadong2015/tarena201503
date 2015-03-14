package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.EmpDao;
import version01.entity.Condition;
import version01.entity.Emp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 */
public class TestEmpDao {
//    @Test
    public void testFindByDept(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Condition condition=new Condition();
        condition.setDeptno(10);
        List<Emp> list=empDao.findByDept(condition);
        for(Emp emp:list){
            System.out.println(
                emp.getEmpno()+" "+emp.getEname()+" "+emp.getDeptno()
            );
        }
    }

//    @Test
    public void testFindBySalary(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Condition condition=new Condition();
        condition.setSalary(100.0);
        List<Emp> list=empDao.findBySalary(condition);
        for(Emp emp:list){
            System.out.println(
                    emp.getEmpno()+" "+emp.getEname()+" "+emp.getSal()
            );
        }
    }

//    @Test
    public void testFindByCondition(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Condition condition=new Condition();
        condition.setSalary(1000.0);
        condition.setDeptno(20);
//        List<Emp> list=empDao.findByCondition(condition);
        List<Emp> list=empDao.findByCondition2(condition);
        for(Emp emp:list){
            System.out.println(
                    emp.getEmpno()+" "+emp.getEname()+" "+emp.getSal()+" "+emp.getDeptno()
            );
        }
    }

//    @Test
    public void testUpdate(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Emp emp=new Emp();
        emp.setEmpno(14);
//        emp.setEname("MILLER[update]");
        emp.setEname("MILLER[update2]");
        emp.setSal(1300.6666);

//        empDao.update(emp);
        empDao.update2(emp);

    }

    @Test
    public void testFindByIds(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        EmpDao empDao=applicationContext.getBean(EmpDao.class);

        Condition condition=new Condition();
        List<Integer> empnos=new ArrayList<Integer>();
        empnos.add(2);
        empnos.add(6);
        empnos.add(11);
        condition.setEmpnos(empnos);
        List<Emp> list = empDao.findByIds(condition);
        for(Emp emp:list){
            System.out.println(
                    emp.getEmpno()+" "+emp.getEname()+" "+emp.getSal()+" "+emp.getDeptno()
            );
        }
    }
}
