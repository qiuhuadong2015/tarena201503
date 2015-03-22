package version01.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import version01.dao.RoleDao;
import version01.entity.Module;
import version01.entity.Role;
import version01.page.RolePage;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 * Unit04:Controller和前面的模块一样，注解要温习熟悉~
 */
@Controller
@RequestMapping("/role")
@SessionAttributes("rolePage")
public class RoleController extends BaseController {

    @Resource
    private RoleDao roleDao;

    @RequestMapping("findRole.form")
    public String find(RolePage page,Model model){
        //查询出当前页的数据
        List<Role> list=roleDao.findByPage(page);
        model.addAttribute("roles",list);
        //查询总行数
        page.setRows(roleDao.findRows());
        model.addAttribute("rolePage",page);
        return "role/role_list";
    }

    @RequestMapping("/toAddRole.form")
    public String toAdd(Model model){
        //查询出全部模块，用于初始化“设置权限”字段
        List<Module> list = roleDao.findAllModules();
        model.addAttribute("modules",list);
        return "role/add_role";
    }

    @RequestMapping("/addRole.form")
    public String add(Role role){
        //新增角色
        roleDao.save(role);
        //新增中间表
        List<Integer> moduleIds=role.getModule_ids();
        if(moduleIds!=null && moduleIds.size()>0){
            for(Integer moduleId:moduleIds){
                Map<String,Object> roleModule=new HashMap<String,Object>();
                roleModule.put("role_id",role.getRole_id());
                roleModule.put("module_id",moduleId);
                roleDao.saveRoleModule(roleModule);
            }
        }
        return "redirect:findRole.form";
    }

    @RequestMapping("toUpdateRole.form")
    public String toUpdate(@RequestParam("id") int id,Model model){
        //查询全部的模块，用于初始化checkbox
        List<Module> list = roleDao.findAllModules();
        model.addAttribute("modules",list);
        //查询要修改的角色，用于设置默认值
        Role role=roleDao.findById(id);
        model.addAttribute("role",role);
        return "role/update_role";
    }

    @RequestMapping("updateRole.form")
    public String update(Role role){
        //修改角色
        roleDao.update(role);
        //删除该角色对应的中间表数据
        roleDao.deleteRoleModule(role.getRole_id());
        //再根据页面传入的模块ID，重新插入中间表数据，和新增一样
        List<Integer> moduleIds=role.getModule_ids();
        if(moduleIds!=null && moduleIds.size()>0){
            for(Integer moduleId:moduleIds){
                Map<String,Object> roleModule=new HashMap<String,Object>();
                roleModule.put("role_id",role.getRole_id());
                roleModule.put("module_id",moduleId);
                roleDao.saveRoleModule(roleModule);
            }
        }
        return "redirect:findRole.form";
    }

    @RequestMapping("deleteRole.form")
    public String delete(@RequestParam("id") int id){
        roleDao.deleteRoleModule(id);
        roleDao.deleteRole(id);
        return "redirect:findRole.form";
    }
}
