package typeinfo.shape;

/**
 * Created by л��� on 2016/8/19 0019.
 */
public abstract class Shape {
    void draw(){System.out.println(this + ".draw()");}

    abstract public String toString();
}
