package typeinfo.dynamicProxy;

import java.util.List;

/**
 * Created by –ª”Óª‘ on 2016/8/20 0020.
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test{
        public static void test(Robot r){
            if(r==null){
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name:" + r.name());
            System.out.println("Robot model:" + r.model());
            for(Operation operation :r.operations()){
                System.out.println(operation.description());
                operation.commad();
            }
        }
    }
}
