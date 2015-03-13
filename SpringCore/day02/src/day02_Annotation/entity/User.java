package day02_Annotation.entity;

import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 * 系统的登陆用户
 */
public class User implements Serializable{
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String pwd;

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return this.id+","+this.name+","+this.phone;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(obj instanceof User){
            User o=(User)obj;
            return this.id==o.id||this.id.equals(o.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if(id==null){
            return 0;
        }
        return id.hashCode();
    }
}
