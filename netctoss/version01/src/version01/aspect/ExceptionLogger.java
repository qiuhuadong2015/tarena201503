package version01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import version01.entity.Admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 * 方面组件，用于在系统发生异常时，记录日志
 */
@Component
@Aspect
public class ExceptionLogger {

    @Resource
    HttpServletRequest request;

    @Around("within(version01.control..*)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object object=null;

        try {
            object=proceedingJoinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
            //记录异常日志
            Admin admin=(Admin)request.getSession().getAttribute("admin");
            if(admin!=null){//假设我们只记录登陆成功后的异常日志
                String name=admin.getName();
                String ip=request.getRemoteHost();
                String now=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String className=proceedingJoinPoint.getTarget().getClass().getName();
                String methodName=proceedingJoinPoint.getSignature().getName();
                String msg="用户["+name+"],"+
                        "IP["+ip+"],"+
                        "在["+now+"],"+
                        "执行["+className+"."+methodName+"时,"+
                        "发生如下异常：\n";
                StackTraceElement[] elements=e.getStackTrace();
                for(StackTraceElement element:elements){
                    msg+="\t"+element.toString();
                }
                System.out.println(msg);
            }
            //这里要抛出，后面再讲如何处理异常（和之前介绍Spring异常处理应该一样）
            throw new RuntimeException(e);
        }


        return object;
    }

}
