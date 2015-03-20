package version01.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import version01.dao.CostDao;
import version01.dao.ServiceDao;
import version01.entity.Cost;
import version01.entity.Service;
import version01.page.ServicePage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 */
@Controller
@RequestMapping("service")
@SessionAttributes("servicePage")
public class ServiceController {

    @Resource
    private ServiceDao serviceDao;

    @Resource
    private CostDao costDao;

    @RequestMapping("findService.form")
    public String find(ServicePage servicePage,Model model){
        //查询当前页的数据
        List<Map<String, Object>> list =
                serviceDao.findByPage(servicePage);
        model.addAttribute("services", list);

        //查询总行数，同其他分页参数一起输出给页面
        servicePage.setRows(serviceDao.findRows(servicePage));
        model.addAttribute("servicePage", servicePage);

        return "service/service_list";
    }

    @RequestMapping("pauseService.form")
    public String updatePause(@RequestParam("id") int id){
        serviceDao.pause(id);
        return "redirect:findService.form";
    }

    @RequestMapping("startService.form")
    public String updateStart(@RequestParam("id") int id){
        serviceDao.start(id);
        return "redirect:findService.form";
    }

    @RequestMapping("deleteService.form")
    public String updateDelete(@RequestParam("id") int id){
        serviceDao.delete(id);
        return "redirect:findService.form";
    }

    @RequestMapping("toUpdateService.form")
    public String toUpdate(@RequestParam("id") int id, Model model){
        Service service=serviceDao.findById(id);
        model.addAttribute("service",service);
        List<Cost> costs=costDao.findAll();
        model.addAttribute("costs",costs);
        return "service/update_service";
    }

    @RequestMapping("updateService.form")
    public String update(@RequestParam("service_id")int service_id,@RequestParam("cost_id")int cost_id){
        Service service=serviceDao.findById(service_id);
        service.setCost_id(cost_id);
        serviceDao.update(service);
        return "redirect:findService.form";
    }
}
