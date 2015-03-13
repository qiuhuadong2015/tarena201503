import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/2.
 */
public class ExampleBean implements Serializable {

    private String name;

    public ExampleBean(){
        System.out.print("创建对象ExampleBean");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void init(){
        System.out.println("初始化ExampleBean");
        name="灰太狼";
    }

    public void destroy(){
        System.out.println("销毁ExampleBean");
        System.out.println("我还会回来的！");
    }
}
