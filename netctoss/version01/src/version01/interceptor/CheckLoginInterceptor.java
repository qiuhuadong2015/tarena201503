package version01.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import version01.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 * 校验用户是否登陆
 * 需要在访问Controller业务方法之前校验，
 * 若没有登陆则踢回（重定向）到登录页面
 */
public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {

        //判断用户是否登陆
        Admin admin=(Admin)httpServletRequest.getSession().getAttribute("admin");
        if(admin==null){
            //没登陆，踢回登陆页面
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/toLogin.form");
            return false;
        }else {
            //已登陆，可以访问Controller
            return true;
        }
        //复习：如果返回true则能够继续执行Controller的方法，否则打回
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
