package collections;

import collections.util.MapData;
import collections.util.Pair;
import widetype.generator.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by 谢宇辉 on 2016/8/27 0027.
 * MapData测试
 */

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size = 0;
    private int number = 0;
    private char letter ='A';


    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++,"" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number<size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(),11));
        System.out.println(MapData.map(new Letters(),"Pop"));
    }

}
