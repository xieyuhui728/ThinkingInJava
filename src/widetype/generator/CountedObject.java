package widetype.generator;

/**
 * Created by 谢宇辉 on 2016/8/22 0022.
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }
}
