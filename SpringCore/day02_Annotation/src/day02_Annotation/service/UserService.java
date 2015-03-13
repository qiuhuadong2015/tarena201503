package day02_Annotation.service;

import day02_Annotation.dao.UserDAO;
import day02_Annotation.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
@Service//Spring自动创建单例对象，并且绑定为Bean对象其id为类名的首字母小写即"userService"
public class UserService implements Serializable{

    @Resource
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String name,String pwd){
        User user=null;
        user=userDAO.findByName(name);
        if(user!=null&&user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }
}
