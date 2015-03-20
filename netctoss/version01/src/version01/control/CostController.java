package version01.control;

import org.springframework.web.bind.annotation.RequestParam;
import version01.dao.CostDao;
import version01.entity.Cost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import version01.page.CostPage;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/12.
 */
@Controller
@RequestMapping("/cost")
public class CostController {

    @Resource
    private CostDao costDao;

    //第一个版本，没有添加分页，返回的是全部记录
//    @RequestMapping("/findCost.form")
//    public String find(Model model){
//        List<Cost> list=costDao.findAll();
//        model.addAttribute("costs", list);
//        return "cost/cost_list";
//    }

    @RequestMapping("/toAddCost.form")
    public String toAdd(Model model){
        return "cost/add_cost";
    }

    //规范的方法名有利于之后的AOP
    //Jsp的表单属性是如何到Cost的属性里的？
    //Spring会调用Cost的set方法，将同名属性进行赋值
    //因此，一定要注意：属性名要一样，否则会出错
    @RequestMapping("/addCost.form")
    public String add(Cost cost){
        //页面上不需要用户输入的，默认的值
        //其实也可以不在这里处理，可以在sql的insert语句中处理
        //之所以在controller处理，是因为不希望在sql中做业务层的处理
        cost.setStatus("0");
        cost.setCreatetime(new Timestamp(System.currentTimeMillis()));
        costDao.save(cost);
        return "redirect:findCost.form";
    }

//    以前使用ModelMap，那么Model和ModelMap的区别是什么？
//    Model是一个接口，而ModelMap是它的实现类，用法一样，用接口简洁一些
    @RequestMapping("/toUpdateCost.form")
    public String toUpdate(@RequestParam("id") int id,Model model){
        Cost cost=costDao.findById(id);
        model.addAttribute("cost", cost);
        return "cost/update_cost";
    }

    @RequestMapping("updateCost.form")
    public String update(Cost cost){
        costDao.update(cost);
        return "redirect:findCost.form";
    }

    @RequestMapping("deleteCost.form")
    public String delete(@RequestParam("id") int id){
        costDao.delete(id);
        return "redirect:findCost.form";
    }

    //第二个版本，添加了分页查询，返回的是根据分页条件（查看页，每页行数）查询的记录
    @RequestMapping("/findCost.form")
    public String find(CostPage costPage,Model model){
        //注意：以下代码可以封装以便复用，可以封装到CostPage类中
        //查询某一页的数据
        List<Cost> list=costDao.findByPage(costPage);
        model.addAttribute("costs",list);
        //查询总行数
        costPage.setRows(costDao.findRows());
        model.addAttribute("costPage",costPage);

        return "cost/cost_list";
    }
}
