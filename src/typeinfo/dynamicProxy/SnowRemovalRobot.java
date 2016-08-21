package typeinfo.dynamicProxy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by –ª”Óª‘ on 2016/8/20 0020.
 */
public class SnowRemovalRobot implements  Robot {
    private  String name;
    public SnowRemovalRobot(String name){
        this.name = name;
    }
    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(new Operation() {
            @Override
            public String description() {
                return name +" can shovel snow";
            }

            @Override
            public void commad() {
                System.out.println(name + " shovel snow");
            }
        },
        new Operation(){

            @Override
            public String description() {
                return name + " can chip ice";
            }

            @Override
            public void commad() {
                System.out.println(name + " chipping ice");
            }
        },
        new Operation(){

            @Override
            public String description() {
                return name + " can clear the roof";
            }

            @Override
            public void commad() {
                System.out.println(name + " clearing roof");
            }
        }
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
