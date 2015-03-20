package version01.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 */
public class Emp implements Serializable {

    public Dept getDept() {
        return dept;
    }

    //一个员工只能属于一个部门
    //追加的关联属性，用于封装关联的部门数据
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;//领导id
    private Date hiredate;//入职日期
    private Double sal;//工资
    private Double comm;//销售提成
    private Integer deptno;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
