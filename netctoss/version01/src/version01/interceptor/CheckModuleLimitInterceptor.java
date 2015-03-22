package version01.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import version01.entity.Module;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/21.
 * 权限检查拦截器
 * 用于检查用户是否具有当前模块的访问权限
 */
public class CheckModuleLimitInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //取出用户当前访问的模块，这是之前在CurrentModuleInterceptor保存到session的
        int currentModuleId=(Integer)httpServletRequest.getSession().getAttribute("currentModuleId");
        //取出用户有权限的模块，这是之前在LoginController保存到session的
        List<Module> modules=(List)httpServletRequest.getSession().getAttribute("canViewModules");
        //判断有权限的模块是否包含当前访问的模块
        for(Module module:modules){
            if(module.getModule_id()==currentModuleId){
                //如果包含，则说明有权限
                return true;
            }
        }
        //循环结束，没有发现可访问模块包含当前模块，说明没有权限
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/nopower.form");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
