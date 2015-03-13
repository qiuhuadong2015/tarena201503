package day02_Annotation.entity;

import java.io.Serializable;
import java.util.*;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class ExampleBean implements Serializable {
    private int age;
    private boolean started;
    private Double price;
    private Date date;
    private List<String> users;
    private Set<String> cards;
    private Map<String,String> map;
    private Properties config;

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Set<String> getCards() {
        return cards;
    }

    public void setCards(Set<String> cards) {
        this.cards = cards;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
