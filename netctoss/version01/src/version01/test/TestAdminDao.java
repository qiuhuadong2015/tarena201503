package version01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.AdminDao;
import version01.entity.Admin;
import version01.entity.Module;
import version01.entity.Role;
import version01.page.AdminPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
public class TestAdminDao {

//    @Test
    public void testFindByPage(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AdminDao adminDao=applicationContext.getBean(AdminDao.class);

        AdminPage adminPage=new AdminPage();
        adminPage.setRoleName("营业");
        List<Admin> list=adminDao.findByPage(adminPage);
        for(Admin admin:list){
            System.out.println(
                    admin.getAdmin_id() + " " + admin.getAdmin_code() + " " + admin.getName()
            );
            List<Role> roles=admin.getRoles();
            for(Role role:roles){
                System.out.println(
                        role.getRole_id()+" "+role.getName()
                );
            }
            System.out.println("------");
        }
    }

//    @Test
    public void testFindRows(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminDao adminDao=applicationContext.getBean(AdminDao.class);
        AdminPage adminPage=new AdminPage();
        int rows=adminDao.findRows(adminPage);
        System.out.println(rows);
    }

//    @Test
    public void testUpdatePassword(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminDao adminDao=applicationContext.getBean(AdminDao.class);
        Map<String,Object> map=new HashMap<String,Object>();
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(6000);
        ids.add(7000);
        map.put("ids",ids);
        map.put("password","abc");
        adminDao.updatePassword(map);
    }

    @Test
    public void testFindModulesByAdminId(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminDao adminDao=applicationContext.getBean(AdminDao.class);

        List<Module> modules=adminDao.findModulesByAdminId(4000);
        for(Module module:modules){
            System.out.println(
                    module.getModule_id()+" "+module.getName()
            );
        }
    }

}
