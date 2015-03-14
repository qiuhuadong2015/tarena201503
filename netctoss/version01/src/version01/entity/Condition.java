package version01.entity;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 * 查询条件实体类
 * Unit02的知识点
 */
public class Condition {

    //部门主键
    private Integer deptno;

    //工资
    private Double salary;

    //foreach的测试条件，根据给定一组员工号，查询员工所有信息
    private List<Integer> empnos;

    public List<Integer> getEmpnos() {
        return empnos;
    }

    public void setEmpnos(List<Integer> empnos) {
        this.empnos = empnos;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
