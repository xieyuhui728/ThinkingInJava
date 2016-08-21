package typeinfo.shape;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 谢宇辉 on 2016/8/19 0019.
 */

public class Shapes {
    public static void main(String[] args) {
        //向上造型
        List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle());
        for(Shape shape:shapeList){
            shape.draw();
        }
    }
}
