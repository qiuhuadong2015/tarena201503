package entity;

import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/10.
 *
 * Department 实体类：实体对象的类型
 *  实体对象：有ID，持久化存储的对象
 *  值对象：无ID，用于数据的封装和传输
 */
public class Department implements Serializable {
    private Integer deptNo;
    private String deptName;
    private String location;

    public Department() {
        super();
    }

    public Department(Integer deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public Department(String deptName, String location) {

        this.deptName = deptName;
        this.location = location;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDeptNo() {

        return deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return deptNo != null ? deptNo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
