package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.AccountDao;
import version01.entity.Account;
import version01.vo.AccountPage;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 */
public class TestAccountDao {
//    @Test
    public void testFindByPage(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        AccountPage accountPage=new AccountPage();
        accountPage.setStatus("1");
        accountPage.setCurrentPage(3);
        List<Account> list=accountDao.findByPage(accountPage);
        for(Account account:list){
            System.out.println(
                    account.getAccount_id()+" "+account.getIdcard_no()+" "+account.getReal_name()
                    +" "+account.getStatus()
            );
        }
    }

//    @Test
    public void testFindRows(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        AccountPage accountPage=new AccountPage();
        accountPage.setStatus("1");
        accountPage.setCurrentPage(2);
        int rows=accountDao.findRows(accountPage);
        System.out.println(rows);
    }

//    @Test
    public void testPause(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        accountDao.pause(1005);

    }

//    @Test
    public void testStart(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        accountDao.start(1005);

    }

//    @Test
    public void testDelte(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        accountDao.delete(1005);

    }

    //以下是修改功能

//    @Test
    public void testFindById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        Account account=accountDao.findById(1005);
        System.out.println(
                account.getAccount_id()+" "+account.getIdcard_no()+" "+account.getReal_name()
        );
    }

    @Test
    public void testUpdate(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);

        Account account=accountDao.findById(1005);
        account.setEmail("sf@126.com");
        account.setMailaddress("峨眉山");
        account.setQq("654321");
        account.setZipcode("789456");

        accountDao.update(account);
    }
}
