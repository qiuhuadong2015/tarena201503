package mybatisSpringProject.dao;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/11.
 */
@Component
public class Dept implements Serializable{
    private Integer deptNo;
    private String deptName;
    private String location;

    public Dept() {
        super();
    }

    public Dept(Integer deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public Dept(String deptName, String location) {

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

        Dept that = (Dept) o;

        if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return deptNo != null ? deptNo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
