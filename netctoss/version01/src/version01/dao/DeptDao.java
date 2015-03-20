package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Dept;

/**
 * Created by qiuhuadong2014 on 2015/3/19.
 */
@MyMybatisMapper
public interface DeptDao {

    Dept findById_WithEmps_BySubSelect(int id);

    Dept findById_WithEmps_ByJoin(int id);

}
