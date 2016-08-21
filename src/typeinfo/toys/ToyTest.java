package typeinfo.toys;

/**
 * Created by –ª”Óª‘ on 2016/8/19 0019.
 */
interface  HasBatteries{};

interface  Waterproof{};

interface Shoots{};

interface  newinterface{};

class Toy{
    Toy(){};
    Toy(int i){};
    Toy(String a){};

}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots,newinterface {
    FancyToy(){super(1);};
}

public class ToyTest {
   static void printInfo(Class cc){
       System.out.println("Class name:" + cc.getName());
       System.out.println("is interface?:[" + cc.isInterface() + "]");
       System.out.println("Class Simple name:" + cc.getSimpleName());
       System.out.println("Canonical name:" + cc.getCanonicalName());
   }

    public static void main(String[] args) {
         Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.print("Cannot find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face:c.getInterfaces()){
            printInfo(face);
        }
        Class up =c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
