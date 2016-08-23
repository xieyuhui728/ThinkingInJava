package widetype.erased;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 谢宇辉 on 2016/8/22 0022.
 * 在泛型内部，无法获得任何有关泛型参数类型的信息
 * 只能发现用作参数占位符的标识符，并非有用信息
 *  **原因是Java泛型是使用擦除来实现的。
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 ==  c2);
        System.out.println(Arrays.toString(c1.getTypeParameters())+"   " +Arrays.toString(c2.getTypeParameters()));
    }
}
