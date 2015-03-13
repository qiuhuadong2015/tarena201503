package mybatisSpringProject.entity;

import mybatisSpringProject.annotation.Mapper;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/11.
 */
@Mapper
public interface EmpMapper {
    void addEmp(Emp emp);
    void deleteEmp(Emp emp);
    void updateEmp(Emp emp);
    Emp findEmpById(Emp emp);
    List<Emp> findEmpByName(Emp emp);
    List<Emp> findAllEmp();
}
