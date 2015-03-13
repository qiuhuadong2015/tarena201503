import java.io.Serializable;

/**
 * Created by qiuhuadong2014 on 2015/3/2.
 */
public class Food implements Serializable {
    private Egg egg;
    private Tomato tomato;
    public Food(Egg egg, Tomato tomato) {
        this.egg=egg;
        this.tomato=tomato;
        System.out.println("西红柿炒蛋做好了~");
    }
}
