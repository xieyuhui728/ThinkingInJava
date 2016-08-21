package typeinfo.interfadeDemo;

/**
 * Created by л��� on 2016/8/20 0020.
 * Υ���ӿڸ���
 */

 class B implements  A{

    @Override
    public void f() {
        System.out.println("f()");
    }

    public void  g(){
        System.out.println("g()");
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getSimpleName());
        if(a instanceof B){
            B b = (B)a;
            b.f();
            b.g();
        }
    }
}
