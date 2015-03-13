package day03;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/4.
 */
@Component
public class DemoBean implements Serializable {
    @Resource
    private List<String> names;
    @Resource
    private List<Date> dateList;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }

    public List<Date> getDateList() {
        return dateList;
    }

    public String toString(){
        return "names:"+names+"\ndateList:"+dateList;
    }
}
