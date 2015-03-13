package day02_Annotation.entity;

import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class UserService implements Serializable{

    private UserDAO userDAO;

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
