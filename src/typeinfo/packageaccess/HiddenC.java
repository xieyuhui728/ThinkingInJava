package typeinfo.packageaccess;

import typeinfo.interfadeDemo.A;

/**
 * Created by –ª”Óª‘ on 2016/8/20 0020.
 */

  class C implements A{

    @Override
    public void f() {
        System.out.println("C f()");
    }

    public void g() {
        System.out.println("C g()");
    }

    private void w() {
        System.out.println("C w()");
    }
}
public class HiddenC {
    public static A makeA(){
        return  new C();
    }
}
