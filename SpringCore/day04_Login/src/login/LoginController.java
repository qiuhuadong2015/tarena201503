package login;

import login.entity.User;
import login.service.NameOrPwdException;
import login.service.NullParamException;
import login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/5.
 */

//public class HelloController implements Controller,Serializable {
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        System.out.println("hello");
//        Map<String,Object> data=new HashMap<String,Object>();
//        data.put("message","Hello Spring");
//        return new ModelAndView("hello",data);
//    }
//}
@Controller
@RequestMapping
public class LoginController implements Serializable{
    @Resource
    private UserService userService;
    @RequestMapping("/login.form")
    public String execute(HttpServletRequest request){
        //登陆控制逻辑，体现了控制器的功能，只有User和UserService是下一层业务层的，其他req是界面层的，即MVC
        try{
            User user=userService.login(name,pwd);
            //保存登陆状态等业务逻辑
            request.getSession().setAttribute("loginUser",user);
            request.setAttribute("message","欢迎"+user.getName());
            return "success";
        }catch(NameOrPwdException e){
            request.setAttribute("message","用户名或密码错误！");
            return "login";
        }catch(NullParamException e){
            request.setAttribute("message","用户名或密码不能为空！");
            return "login";
        }
//        return "login";
    }
}
