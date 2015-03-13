package mybatisSpringProject.dao;

import mybatisSpringProject.annotation.Mapper;
import mybatisSpringProject.dao.Dept;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/11.
 */
@Mapper
public interface DeptMapper {

    void add(Dept department);

    void delete(Dept department);

    void update(Dept department);

    Dept findById(Integer deptNo);

    List<Dept> findAll();
}
