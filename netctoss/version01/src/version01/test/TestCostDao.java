package version01.test;

import version01.dao.CostDao;
import version01.entity.Cost;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.vo.CostPage;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/12.
 */
public class TestCostDao {
//    @Test
    public void testFindAll()throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        List<Cost> list = costDao.findAll();
        for(Cost cost:list){
            System.out.println(
              cost.getCost_id()+" "+cost.getName()+" "+cost.getDescr()
            );
        }
    }

//    @Test
    public void testToAdd(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        Cost cost=new Cost();
        cost.setName("tarena");
        cost.setBase_duration(99);
        cost.setBase_cost(9.0);
        cost.setUnit_cost(0.9);
        cost.setStatus("1");
        cost.setDescr("tarena");
        cost.setCreatetime(new Timestamp(System.currentTimeMillis()));
        cost.setCost_type("1");
        costDao.save(cost);
    }

//    @Test
    public void testFindById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        Cost cost=costDao.findById(8);
        System.out.println(
                cost.getCost_id()+" "+cost.getName()
        );
    }

//    @Test
    public void testUpdate(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        Cost cost=costDao.findById(8);

        cost.setName("uuu");
        cost.setDescr("修改之后的描述");

        costDao.update(cost);
    }

//    @Test
    public void testDelete(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        costDao.delete(8);
    }

//    @Test
    public void testFindByPage(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        CostPage costPage=applicationContext.getBean("costPage",CostPage.class);
        costPage.setCurrentPage(2);

        List<Cost> list=costDao.findByPage(costPage);
        for(Cost cost:list){
            System.out.println(
                    cost.getCost_id()+" "+cost.getName()+" "+cost.getDescr()
            );
        }
    }

    @Test
    public void testFindRows(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        CostDao costDao=applicationContext.getBean("costDao",CostDao.class);
        int rows=costDao.findRows();
        System.out.println(rows);
    }
}
