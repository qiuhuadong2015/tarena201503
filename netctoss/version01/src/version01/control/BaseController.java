package version01.control;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import version01.util.DateEditor;

import java.io.UnsupportedEncodingException;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 * 如果日期提交有问题，就可以让Controller继承本类
 */
public class BaseController {

    /**
     * 请求开始时会先调用这个方法
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        //注册转换器，将java.sql.Date类型DateEditor进行转换
        //因为默认情况会自动选择Editor，我们自定义Editor是为了防止自动选择而导致选择错误
        binder.registerCustomEditor(java.sql.Date.class,new DateEditor());
    }

    protected String isoToUtf8(String s) {
        if (s == null)
            return null;
        try {
            return new String(s.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
