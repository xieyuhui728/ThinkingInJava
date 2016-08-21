package typeinfo.interfadeDemo;

import typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * Created by –ª”Óª‘ on 2016/8/20 0020.
 */
public class HiddenImplementation {
    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();
        Method[] methods = a.getClass().getDeclaredMethods();
        try {
            callHiddenMethod(a,methods[0].getName());
            callHiddenMethod(a,methods[1].getName());
            callHiddenMethod(a,methods[2].getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void callHiddenMethod(Object a,String methodName)throws  Exception{

        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }

}
