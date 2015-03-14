package version01.util;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 * 日期类型转换器，可以讲表单中的日期字符串转换为实体类中的java。sql。Date
 */
public class DateEditor extends PropertyEditorSupport{
    private String pattern="yyyy-MM-dd";

    public DateEditor(){

    }

    public DateEditor(String pattern){
        this.pattern=pattern;
    }

    /**
     * @param text
     *  表单中的日期字符串，我们的目的是，将它转化成java.sql.Date
     *  按照指定日期格式，将表单字符串转换为指定的日期类型java.sql.Date
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        if(text==null||text.length()==0){
            setValue(null);
        }else{
            //格式化日期工具
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(this.pattern);
            //将表单中的日期格式化
            String dateStr=simpleDateFormat.format(Date.valueOf(text));
            //将格式化后的日期转型成java.sql.Date，并覆盖原有的表单数据
            setValue(Date.valueOf(dateStr));

//            Date.valueOf(String string)的功能应该是把字符串解析成日期，可以是表单的，也可以是自己格式化的字符串

            //这里的逻辑是：
//            表单中的日期格式不是我们想要的（不是本类中pattern的格式）
//            因此我们从表单拿到字符串（text）重新按照pattern格式化放回去
        }

    }

}
