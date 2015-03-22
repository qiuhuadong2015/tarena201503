package version01.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 * 判断当前访问模块的拦截器
 * 根据用户访问的URL，提取出当前模块信息，并存入session
 */
public class CurrentModuleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        获取用户访问的URI
        String requestURI=httpServletRequest.getRequestURI();
        int currentModuleId=0;//默认是首页
        if(requestURI.contains("role")){
            currentModuleId=1;
        }else if (requestURI.contains("admin")){
            currentModuleId=2;
        }else if (requestURI.contains("cost")){
            currentModuleId=3;
        }else if (requestURI.contains("account")){
            currentModuleId=4;
        }else if (requestURI.contains("service")){
            currentModuleId=5;
        }
        //将当前模块的ID存入session
        httpServletRequest.getSession().setAttribute("currentModuleId",currentModuleId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
