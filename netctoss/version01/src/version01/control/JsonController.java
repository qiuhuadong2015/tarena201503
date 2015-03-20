package version01.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import version01.entity.Emp;

import java.util.*;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 */
@Controller
@RequestMapping("jsonTest")
public class JsonController {

    @RequestMapping("/test1.form")
    @ResponseBody
    public boolean test1() {
        return true;
    }

    @RequestMapping("test2.form")
    @ResponseBody
    public Map<String, Object> test2() {
        Map map = new HashMap<String, Object>();
        map.put("id", 6);
        map.put("name", "张三");
        map.put("age", 25);
        return map;
    }

    @RequestMapping("test3.form")
    @ResponseBody
    public List<Object> test3() {
        List list = new ArrayList<Object>();
        list.add(2);
        list.add("王五");
        return list;
    }

    @RequestMapping("test4.form")
    @ResponseBody
    public Emp test4() {
        Emp emp=new Emp();
        emp.setEmpno(10);
        emp.setEname("马六");
        emp.setJob("程序员");
        emp.setSal(12000.0);
        return emp;
    }

    @RequestMapping("test5.form")
    @ResponseBody
    public List<Emp> test5() {
        List<Emp> list=new ArrayList<Emp>();
        Emp emp1=new Emp();
        emp1.setEmpno(10);
        emp1.setEname("马六");
        emp1.setJob("程序员");
        emp1.setSal(12000.0);

        Emp emp2=new Emp();
        emp2.setEmpno(20);
        emp2.setEname("周八");
        emp2.setJob("销售");
        emp2.setSal(7000.0);

        list.add(emp1);
        list.add(emp2);

        return list;
    }
}