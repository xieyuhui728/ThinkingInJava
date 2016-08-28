package collections;

import widetype.generator.Generator;

import java.util.ArrayList;

/**
 * Created by 谢宇辉 on 2016/8/25 0025.
 * 所有的Collection子类型都有一个接收另一个Collection对象的构造器
 * CollectionData是适配器设计模式的一个实例，它将Generator适配到Collection的构造器上
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
