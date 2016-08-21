package typeinfo.packageaccess;

import java.lang.reflect.Field;

/**
 * Created by 谢宇辉 on 2016/8/21 0021.
 *利用反射可以地调用那些非公共访问权限的方法
 */

class WithPrivateFinalField{
    private int i = 1;
    private final String s= "I'm totally safe";
    private String s2 = "Am I safe ?";
    public String toString(){
        return "i = " + i + " , s = " + s + " , s2 = " + s2;
    }
}
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf =new WithPrivateFinalField();
        System.out.println(pf);
        Field f =  pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(pf,47);
        System.out.println(pf);
        f =  pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf):" +f.get(pf));
        f.set(pf,"No,you're not!");
        System.out.println(pf);
        f =  pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(pf,"No,you're not!");
        System.out.println(pf);
//        for(Field field:fields){
//            System.out.println(field);
//        }
    }
}
