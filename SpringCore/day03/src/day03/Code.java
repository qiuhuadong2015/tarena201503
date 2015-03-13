package day03;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by qiuhuadong2014 on 2015/3/4.
 */
@Scope("prototype")
@org.springframework.stereotype.Component
public class Code implements Serializable {
    private String code;
    private BufferedImage image;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @PostConstruct
    public void init(){
        //初始化验证码
        String id= UUID.randomUUID().toString();
        code=id.substring(id.length()-4);
        image=new BufferedImage(80,30,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g=image.getGraphics();
        g.setColor(Color.black);
        g.drawString(code,5,28);

    }
    public String toString(){
        return code+","+image;
    }
}
