package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.ServiceDao;
import version01.entity.Service;
import version01.page.ServicePage;

import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 */
public class TestServiceDao {

//    @Test
    public void testFindByPage() {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        ServicePage page = new ServicePage();
        page.setCurrentPage(1);
        page.setUnix_host("192.168.0.20");
        List<Map<String, Object>> list = dao.findByPage(page);
        for(Map<String,Object> map : list) {
            System.out.println(
//                    map.get("SERVICE_ID") + " " +
//                    map.get("OS_USERNAME") + " " +
//                    map.get("UNIX_HOST") + " " +
//                    map.get("IDCARD_NO") + " " +
//                    map.get("COST_NAME")
                    //注意！mysql和oracle有区别！是全小写！
                    map.get("service_id") + " " +
                    map.get("os_username") + " " +
                    map.get("unix_host") + " " +
                    map.get("idcard_no") + " " +
                    map.get("cost_name")
            );
        }
    }

//    @Test
    public void testFindRows() {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        ServicePage page = new ServicePage();
        page.setUnix_host("192.168.0.20");
        int rows = dao.findRows(page);
        System.out.println(rows);
        //全部应该为8行
        //192.168.0.20应该为4行
    }

//    @Test
    public void testPause(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        dao.pause(2002);
    }

//    @Test
    public void testStart(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        dao.start(2002);
    }

//    @Test
    public void testDelete(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        dao.delete(2002);
    }

//    @Test
    public void testFindById(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        Service service =dao.findById(2002);
        System.out.println(service);
    }

    @Test
    public void testUpdate(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceDao dao = ctx.getBean(ServiceDao.class);

        Service service=dao.findById(2002);
        service.setCost_id(2);

        dao.update(service);
    }
}
