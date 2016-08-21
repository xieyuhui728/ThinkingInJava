package typeinfo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ð»Óî»Ô on 2016/8/19 0019.
 * ×¢²á¹¤³§
 */
class Part{
    public String toString(){
        return this.getClass().getSimpleName();
    }
    static List<Factory<? extends  Part>> partFacotries = new ArrayList<Factory<? extends Part>>();
    static{
        partFacotries.add(new FuelFilter.Factory());
        partFacotries.add(new AirFilter.Factory());
        partFacotries.add(new CabinFilter.Factory());
        partFacotries.add(new OilFilter.Factory());
        partFacotries.add(new FanBelt.Factory());
        partFacotries.add(new GeneratorBelt.Factory());
        partFacotries.add(new PowerSteeringBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFacotries.size());
        return partFacotries.get(n).create();
    }
}

class Filter extends  Part{}

class FuelFilter extends  Filter{
    public static class Factory implements typeinfo.factory.Factory<FuelFilter>{
        public FuelFilter create(){
            return new FuelFilter();
        };
    }
}

class AirFilter extends  Filter{
    public static class Factory implements typeinfo.factory.Factory<AirFilter>{
        public AirFilter create(){
            return new AirFilter();
        };
    }
}

class CabinFilter extends  Filter{
    public static class Factory implements typeinfo.factory.Factory<CabinFilter>{
        public CabinFilter create(){
            return new CabinFilter();
        };
    }
}

class OilFilter extends  Filter{
    public static class Factory implements typeinfo.factory.Factory<OilFilter>{
        public OilFilter create(){
            return new OilFilter();
        };
    }
}

class Belt extends Part{}

class FanBelt extends  Belt{
    public static class Factory implements typeinfo.factory.Factory<FanBelt>{
        public FanBelt create(){
            return new FanBelt();
        };
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements typeinfo.factory.Factory<GeneratorBelt>{
        public GeneratorBelt create(){
            return new GeneratorBelt();
        };
    }
}

class PowerSteeringBelt extends Belt{
    public static class Factory implements typeinfo.factory.Factory<PowerSteeringBelt>{
        public PowerSteeringBelt create(){
            return new PowerSteeringBelt();
        };
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
        System.out.println(Part.createRandom());
        }
    }
}
