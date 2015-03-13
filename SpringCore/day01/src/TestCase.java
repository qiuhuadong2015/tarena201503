import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by qiuhuadong2014 on 2015/3/2.
 */
public class TestCase {
    /**测试Spring是否能够帮助创建Date类型的对象**/
//    @Test
    public void testCreateDate(){
        //1 创建Spring容器对象，将配置文件交给Spring，找到软件的管家
        //2 测试是否能够创建Date类型的对象myDate

        //1
        String config="spring-config.xml";
        //类名来自Spring API jar
        //创建Spring容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //创建从Spring容器中获取的（由Spring容器创建的）Date对象
        //对象的ID是myDate
        Date obj=(Date)ctx.getBean("myDate");
        //如果不写强制类型转换，可以用这一种方式书写
        Date d=ctx.getBean("myDate",Date.class);

        Calendar calendar=ctx.getBean("myGreCalendar", GregorianCalendar.class);

        Calendar calendarFromFactory=ctx.getBean("myCalendarFromFactory",Calendar.class);
    }

//    @Test
    public void testDate3(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        Date date1=applicationContext.getBean("date3",Date.class);
        Date date2=applicationContext.getBean("date3",Date.class);
        Date date3=applicationContext.getBean("date3",Date.class);
        System.out.println(date1==date2);
        System.out.println(date2==date3);
    }

//    @Test
    public void testExampleBean(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        ((AbstractApplicationContext)applicationContext).close();
    }

//    @Test
    public void testEggAndTomato(){
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        applicationContext.getBean("food");

        ((AbstractApplicationContext)applicationContext).close();

    }

    @Test
    public void testDBUtil() throws SQLException {
        String config="spring-config.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        DBUtil dbUtil=applicationContext.getBean("dbUtil",DBUtil.class);
        System.out.println(dbUtil.getDriver());
        System.out.println(dbUtil.getUser());
        System.out.println(dbUtil.getPwd());
        System.out.println(dbUtil.getUrl());

        Connection conn=dbUtil.getConnection();
        System.out.println(conn.getMetaData().getDatabaseProductName());

    }
}
