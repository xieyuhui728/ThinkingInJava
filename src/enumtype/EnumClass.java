package enumtype;

/**
 * Created by 谢宇辉 on 2016/8/30 0030.
 * 创建enum时，编译器会生成一个相关的类，该类继承自java.lang.Enum
 */

enum Shrubbery {
    GROUND, CRAWLING, HANGING
};

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + "ordinal " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING)+ " " );
            System.out.println(s.equals(Shrubbery.CRAWLING)+ " ");
            System.out.println(s==Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
        }
    }
}
