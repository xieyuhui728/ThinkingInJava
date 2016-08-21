package typeinfo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by л��� on 2016/8/19 0019.
 * ��̬����
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
         * ���þ�̬����Proxy.newProxyInstance()���Դ�����̬����
         * ��Ҫһ�����������һ������ʵ�ֵĽ���б�һ��InvocationHandler�ӿڵ�ʵ����
         */
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicHandler(realObject));
        consumer(proxy);
    }
}