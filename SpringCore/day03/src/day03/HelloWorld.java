package day03;

import org.springframework.stereotype.Component;

/**
 * Created by qiuhuadong2014 on 2015/3/4.
 */
@Component
public class HelloWorld {
    String msg="HelloWorld!Spring Comming";

    @Override
    public String toString() {
        return msg;
    }
}
