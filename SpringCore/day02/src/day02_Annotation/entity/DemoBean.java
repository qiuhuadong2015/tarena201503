package day02_Annotation.entity;

import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class DemoBean implements Serializable {
    private String phone="110";
    private String address="新华门";

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
