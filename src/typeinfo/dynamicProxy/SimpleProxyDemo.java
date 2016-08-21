package typeinfo.dynamicProxy;

import java.util.Iterator;
import java.util.Observable;

/**
 * Created by –ª”Óª‘ on 2016/8/19 0019.
 * ¥˙¿Ì
 */

interface Interface{
    void doSometing();
    void somethingElse(String arg);
}

class RealObject implements Interface{

    @Override
    public void doSometing() {
        System.out.println("doSometing");
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse "+arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }
    @Override
    public void doSometing() {
        System.out.println("SimpleProxy doSometing");
        System.out.println("doSometing");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse "+ arg);
        System.out.println("somethingElse "+arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSometing();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
