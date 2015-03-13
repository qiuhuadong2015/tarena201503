package day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/4.
 */
@Scope("prototype")
@Component
public class Comment implements Serializable {
    private String comment;
    @Autowired
    private Code code;

    public void setCode(Code code) {
        this.code = code;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Code getCode() {
        return code;
    }

    public String getComment() {
        return comment;
    }

    public String toString(){
        return comment+","+code;
    }
}
