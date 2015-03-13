package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
public class HelloController implements Serializable{
    @RequestMapping("/hello.form")
    public String execute(){
        return "hello";
    }
}
