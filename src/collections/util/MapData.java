package collections.util;

import widetype.generator.Generator;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by 谢宇辉 on 2016/8/27 0027.
 * Map生成器
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = gen.next();
            put(pair.key, pair.value);
        }
    }

    //Two separate Generators
    public MapData(Generator<K> genK,Generator<V> genV, int quantity){
        for (int i = 0; i < quantity; i++) {
            put(genK.next(),genV.next());
        }
    }

    //A key Generator and a single value
    public MapData(Generator<K> genK,V value,int quantity){
        for (int i = 0; i < quantity; i++) {
            put(genK.next(),value);
        }
    }

    //An Iterable and a value Generator
    public MapData(Iterable<K> genK,Generator<V> genV){
        for(K key:genK){
            put(key, genV.next());
        }
    }

    //An Iterable and single value
    public MapData(Iterable<K> genK,V value){
        for(K key:genK){
            put(key, value);
        }
    }

    // Generic convenience methods:

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
        return new MapData<K, V>(gen,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,Generator<V> genV, int quantity){
        return new MapData<K, V>(genK,genV,quantity);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> genK,Generator<V> genV){
        return new MapData<K, V>(genK,genV);
    }


    public static <K,V> MapData<K,V> map(Iterable<K> genK,V value){
        return new MapData<K, V>(genK,value);
    }
}


