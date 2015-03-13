package day02_Annotation.entity;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public interface UserDAO {
    User findByName(String name);
    User add(String name,String pwd,String phone);
    Integer add(User user);
    User remove(Integer id);
    Void update(User user);
    List<User> findAll();
}
