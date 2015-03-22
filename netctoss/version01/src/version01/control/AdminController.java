package version01.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import version01.dao.AdminDao;
import version01.entity.Admin;
import version01.page.AdminPage;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
@Controller
@RequestMapping("admin")
@SessionAttributes("adminPage")
public class AdminController {

    //默认的密码
    private final static String DEFAULT_PASSWORD="abc";

    @Resource
    private AdminDao adminDao;

    @RequestMapping("findAdmin.form")
    public String find(AdminPage adminPage ,Model model){
        //查询当前页的管理员，输出给页面
        List<Admin> list=adminDao.findByPage(adminPage);
        model.addAttribute("admins",list);
        //查询总行数
        adminPage.setRows(adminDao.findRows(adminPage));
        model.addAttribute("adminPage",adminPage);
        return "admin/admin_list";
    }

    //这里重置密码是异步请求，传入的是JSON字符串
    @ResponseBody
    @RequestMapping("resetPassword.form")
    public Map<String, Object> updatePassword(@RequestParam("ids")String ids){
        //构建参数
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("ids",getIdList(ids));
        param.put("password",DEFAULT_PASSWORD);
        //更新密码
        adminDao.updatePassword(param);

        Map<String,Object> result=new HashMap<String, Object>();
        result.put("success",true);
        result.put("message","密码重置成功");
        return result;
    }

    private List<Integer> getIdList(String ids){
        if(ids==null||ids.length()==0){
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        String[] idArray=ids.split(",");
        for(String id:idArray){
            list.add(Integer.valueOf(id));
        }
        return list;
    }


}
