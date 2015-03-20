package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Condition;
import version01.entity.Emp;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 */
@MyMybatisMapper
public interface EmpDao {
    /**
     * 根据部门查询员工
     * @param condition
     * @return
     */
    List<Emp> findByDept(Condition condition);

    /**
     * 根据工资查询员工
     * @param condition
     * @return
     */
    List<Emp> findBySalary(Condition condition);

//  以上测试的都是一个条件（给一个条件，根据if或choose...otherwise拼接），
//  下面是测试多个条件，提供哪些就拼哪些

    /**
     * 根据多个条件查询员工
     * @param condition
     * @return
     */
    List<Emp> findByCondition(Condition condition);

    //和上面一个方法作用一样，只是不用where标签，而是用trim标签实现
    List<Emp> findByCondition2(Condition condition);

    /**
     * 修改员工
     * @param emp
     */
    void update(Emp emp);

    void update2(Emp emp);

    /**
     * 根据一组员工ID查询员工
     * @param condition
     * @return
     */
    List<Emp> findByIds(Condition condition);

    //以上是Unit03的内容，学习的是spring json

    //以下是Unit04的内容，学习的是多对一映射
    Emp findById_WithDept_BySubSelect(int id);

    Emp findById_WithDept_ByJoin(int id);
}
