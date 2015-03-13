package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by qiuhuadong2014 on 2015/3/6.
 */

@Controller
public class LoginController implements Serializable{

    @ModelAttribute("msg")
    public Boolean getMsg(){
        return new Random().nextBoolean();
    }

    @RequestMapping("/login.form")
    public String loginAction(@ModelAttribute("msgName")String msgName,HttpServletRequest request){
        return "login";
    }

    //重定向测试
    @RequestMapping("/hi.form")
    public String hiAction(HttpServletRequest request){
        ServletContext servletContext=request.getServletContext();
        String path=servletContext.getContextPath();
        return "redirect:"+path+"/login.form";
    }

}
