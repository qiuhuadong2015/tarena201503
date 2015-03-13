package day02_Annotation.dao;

import day02_Annotation.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
@Component
public interface UserDAO {
    User findByName(String name);
    User add(String name, String pwd, String phone);
    Integer add(User user);
    User remove(Integer id);
    Void update(User user);
    List<User> findAll();
}
