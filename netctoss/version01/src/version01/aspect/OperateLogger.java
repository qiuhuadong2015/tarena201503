package version01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 * 这是一个方面组件，用于记录用户操作日志（模拟）
 */
//xml配置改为注解配置，首先声明为Bean，其次声明为AOP组件
/**
 *  （方法中会用到的）通知注解类型：
 *  @Before：前置通知
 *  @AfterReturning：后置通知
 *  @After：最终通知
 *  @Around：环绕通知
 *  @AfterThrowing：异常通知
 */
@Component
@Aspect
public class OperateLogger {

    /**
     * 演示前置通知（后置通知和最终通知也是一样的步骤）
     * 对定义方法的要求
     * 1、方法是共有的
     * 2、没有返回值
     * 3、参数为空
     */
    //括号内要声明切入点，也就是切入点表达式，和在xml写的within表达式一样
    @Before("within(version01.control..*)")
    public void log1(){
        System.out.println("前置通知:记录用户操作日志");
    }

     /**
     *
     * 环绕通知（和前置通知不一样）
     * 对定义方法的要求
     * 1、方法是共有的（和前置通知一样，因为都要被SpringAOP的相关API自动调用）
     * 2、返回值是Object类型
     * 3、参数是ProceedingJoinPoint类型
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
     @Around("within(version01.control..*)")
    public Object log2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        //记录日志
        //使用环绕通知还有一点好处，就是可以获得目标组件(getTarget())的相关信息，例如组件的类名
        // 也可以获得目标组件的调用方法（getSignature()），更方便记录日志
        String className=proceedingJoinPoint.getTarget().getClass().getName();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String now=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String msg="用户在"+now+"，执行了"+className+"."+methodName+"()方法";
        System.out.println("arround-前："+msg);

        /*
            proceed（）方法就是调用目标组件的方法
            如果该方法中没有调用proceed，就无法调用到目标组件的方法了。
            1、在这句代码之前执行的代码，就是“环绕通知的前置通知”
            2、在这句代码之后执行的代码，就是“环绕通知的后置通知”
         */
        Object obj=proceedingJoinPoint.proceed();

        System.out.println("arround-后：");

        return obj;
    }

    /**
     * 异常通知的方法要求：
     * 1、方法是共有的
     * 2、没有返回值
     * 3、参数为Exception类型
     * @param exception
     */
    @AfterThrowing(pointcut = "within(version01.control..*)",throwing = "exception")
    public void log3(Exception exception){
        StackTraceElement[] elements=exception.getStackTrace();
//        for (StackTraceElement element:elements){
//            System.out.println(element.toString());
//        }
        System.out.println(elements[0].toString());
    }

}
