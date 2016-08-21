package widetype.generator;

/**
 * Created by 谢宇辉 on 2016/8/21 0021.
 */
public class Coffee {
    private static long counter = 0;
    private final long id =counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}
