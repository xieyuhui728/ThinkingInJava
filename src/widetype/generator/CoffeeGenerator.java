package widetype.generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by 谢宇辉 on 2016/8/21 0021.
 */
public class CoffeeGenerator implements Generator<Coffee>,Iterator<Coffee>{

    private Class[] types = {Latta.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};

    private static Random rand  = new Random(47);
    public CoffeeGenerator(){};

    private int size = 0 ;
    public CoffeeGenerator(int sz){ size = sz; };

    @Override
    public boolean hasNext() {
        return size >0;
    }

    @Override
    public Coffee next() {
        size--;
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

//    class  CoffeeItertor implements Iterator<Coffee> {
//        int count = size;
//
//
//
//        @Override
//        public Coffee next() {
//            count --;
//            return CoffeeGenerator.this.next();
//        }
//
//
//    };
    public Iterator<Coffee> iterator(){
        return new CoffeeGenerator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i =0 ;i< 5;i++){
            System.out.println(gen.next());
        }
//        for(Coffee c : new CoffeeGenerator(5)){
//            System.out.println(c);
//        }
    }
}


