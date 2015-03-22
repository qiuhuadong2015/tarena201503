package version01.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import version01.dao.AdminDao;
import version01.entity.Admin;
import version01.entity.Module;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {


    private final static int SUCCESS = 0;
    private final static int ADMIN_CODE_ERROR = 1;
    private final static int PASSWORD_ERROR = 2;
    private final static int IMAGE_CODE_ERROR = 3;

    @Resource
    private AdminDao adminDao;

    @RequestMapping("toLogin.form")
    public String toLogin(){
        return "main/login";
    }

    @RequestMapping("toIndex.form")
    public String toIndex(){
        return "main/index";
    }


    @ResponseBody
    @RequestMapping("checkLogin.form")
    public Map<String,Object> checkLogin(@RequestParam("adminCode")String adminCode,
                                         @RequestParam("password")String password,
                                         HttpSession session){

        Map<String,Object> result=new HashMap<String, Object>();

        //查询管理员
        Admin admin=adminDao.findByCode(adminCode);

        //判断查询结果
        if(admin==null){
            //账号不存在
            result.put("loginStatus",ADMIN_CODE_ERROR);
            return result;
        }else if(!admin.getPassword().equals(password)){
            //密码错误
            result.put("loginStatus",PASSWORD_ERROR);
            return result;
        }else{
            //成功
            result.put("loginStatus",SUCCESS);
            //为了能够执行登陆检查，要把admin（用户）信息放入session
            //将管理员信息存入session，用于后续的登陆检查
            session.setAttribute("admin",admin);
            //查询该管理员对应的模块，放入session
            List<Module> modules=adminDao.findModulesByAdminId(admin.getAdmin_id());
            session.setAttribute("canViewModules",modules);
            return result;
        }
    }

    @RequestMapping("nopower.form")
    public String toNopower(){
        return "main/nopower";
    }

}
