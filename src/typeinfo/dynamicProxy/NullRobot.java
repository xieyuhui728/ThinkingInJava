package typeinfo.dynamicProxy;

import javax.lang.model.type.NullType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 谢宇辉 on 2016/8/20 0020.
 * 动态代理捕获NullRobot
 */
class NullRobotProxyHandle implements InvocationHandler{
    private String nullName;
    private Robot proxied = new NRobot();
    NullRobotProxyHandle(Class<? extends  Robot> type){
        nullName = type.getSimpleName()+ " NullRobot";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }

    private class NRobot implements Robot{

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
//            return Collections.emptyList();
            return Arrays.asList(new Operation() {
                @Override
                public String description() {
                    return nullName +" description()";
                }

                @Override
                public void commad() {
                    System.out.println(nullName +" commad()");
                }
            },
                    new Operation() {
                        @Override
                        public String description() {
                            return nullName +" description()";
                        }

                        @Override
                        public void commad() {
                            System.out.println(nullName +" commad()");
                        }
                    }
            );
        }

    }
}

public class NullRobot {
    public static Robot newNullRobot(Class<? extends  Robot> type){
        return (Robot)Proxy.newProxyInstance(NullRobot.class.getClassLoader(),new Class[]{Robot.class},new NullRobotProxyHandle(SnowRemovalRobot.class));
    }

    public static void main(String[] args) {
        Robot[] bots={new SnowRemovalRobot("SnowBee"),newNullRobot(SnowRemovalRobot.class)};
        for(Robot robot:bots){
            Robot.Test.test(robot);
        }
    }
}

