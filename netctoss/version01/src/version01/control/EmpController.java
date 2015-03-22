package version01.control;

import org.springframework.stereotype.Controller;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 * Unit05 AOP学习案例，模拟实现EMP的增删改查功能，以便被AOP做日志记录
 */
@Controller
public class EmpController {

    public String find(){
        System.out.println("查询EMP数据，发送至页面");
        //用于测试异常通知，下面的代码会抛出类型转换异常
        Integer.valueOf("abc");
        return "emp/emp_list";
    }

    public String add(){
        System.out.println("新增一条员工数据");
        return "redirect:find.do";
    }

    public String update(){
        System.out.println("修改员工数据");
        return "redirect:find.do";
    }

    public String delete() {
        System.out.println("删除一条员工数据");
        return "redirect:find.do";
    }
}

