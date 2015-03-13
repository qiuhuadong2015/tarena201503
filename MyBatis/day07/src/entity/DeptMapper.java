package entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/10.
 */
public interface DeptMapper {

    void add(Department department);

    void delete(Department department);
//
    void update(Department department);
//
    Department findById(Integer deptNo);
//
    List<Department> findAll();

    class test{
//        @Test
        public void testAdd() throws Exception{
            //1 创建SqlSession对象
            //2 执行插入操作
            String config="SqlMapConfig.xml";
            //MyBatis提供了工具方法，用于打开配置文件流
            Reader reader= Resources.getResourceAsReader(config);
            //可以创建工厂的工厂建造者
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            //工厂建造者创建一个工厂
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(reader);
            //通过工厂打开数据库，获得SqlSession对象
            SqlSession sqlSession=sqlSessionFactory.openSession();

            //操作
            System.out.println(sqlSession);
            System.out.println(sqlSession.getConnection());


            //mybatis会自动帮我们实现接口、创建实例！
            DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);
            deptMapper.add(new Department("教学部","北京"));

            //也可以执行session的insert方法
            //执行配置文件中id为add的insert节点sql语句
            sqlSession.insert("add",new Department("组织部","杭州"));

            sqlSession.commit();

            //断开数据库连接或者归还连接到连接池
            sqlSession.close();
        }

//        @Test
        public void testUpdate()throws Exception{
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
            SqlSession sqlSession=sqlSessionFactory.openSession();

            sqlSession.update("update",new Department(2,"部门5","杭州"));

            sqlSession.commit();

            sqlSession.close();

        }

        @Test
        public void testFindAll()throws Exception{
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
            SqlSession sqlSession=sqlSessionFactory.openSession();

            List<Department> list=sqlSession.selectList("findAll");

            System.out.println(list);

            sqlSession.close();
        }
    }
}
