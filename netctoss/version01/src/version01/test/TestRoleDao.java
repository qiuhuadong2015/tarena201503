package version01.test;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import version01.dao.RoleDao;
import version01.entity.Module;
import version01.entity.Role;
import version01.page.RolePage;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
public class TestRoleDao {
//    @Test
    public void testFindByPage(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        RoleDao roleDao=applicationContext.getBean(RoleDao.class);

        RolePage rolePage = new RolePage();
        List<Role> list = roleDao.findByPage(rolePage);
        for(Role r : list){
            System.out.println(
                    r.getRole_id()+" "+r.getName()
            );
            List<Module> modules=r.getModules();
            for(Module m:modules){
                System.out.println(
                        m.getModule_id() + " " + m.getName()
                );
            }
            System.out.println("----------------");
        }
    }

//    @Test
    public void testSave(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        RoleDao roleDao=applicationContext.getBean(RoleDao.class);

        Role role=new Role();
        role.setName("xxx");
        roleDao.save(role);

        System.out.println(role.getRole_id());
    }

    @Test
    public void testFindById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        RoleDao roleDao=applicationContext.getBean(RoleDao.class);

        Role role=roleDao.findById(200);
        System.out.println(role.getName());
        List<Module> list=role.getModules();
        for(Module module:list){
            System.out.println(
                    module.getModule_id()+" "+module.getName()
            );
        }
    }
}
