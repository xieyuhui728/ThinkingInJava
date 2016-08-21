package typeinfo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 谢宇辉 on 2016/8/19 0019.
 * 动态代理
 */
class DynamicHandler implements InvocationHandler {
    private Object proxied;

    public DynamicHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy:" + proxy.getClass() + " ,Method:" + method + " ,args:" + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("" + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSometing();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //insert a proxy and call again
        /**
         * 调用静态方法Proxy.newProxyInstance()可以创建动态代理。
         * 需要一个类加载器，一个代理实现的借口列表，一个InvocationHandler接口的实现类
         */
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicHandler(realObject));
        consumer(proxy);
    }
}