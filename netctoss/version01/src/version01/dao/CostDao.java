package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Cost;
import version01.vo.CostPage;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/12.
 */
@MyMybatisMapper
public interface CostDao {

    List<Cost> findAll();

    void save(Cost cost);

    Cost findById(int id);

    void update(Cost cost);

    void delete(int id);

    //问题：有两个参数，但是mapper的配置文件只能写一个参数
    //解决方式，用一个对象封装这两个参数，在vo包创建一个值对象CostPage
    List<Cost> findByPage(CostPage costPage);

    //查询总行数，便于我们计算总页数，以便显示
    int findRows();
}
