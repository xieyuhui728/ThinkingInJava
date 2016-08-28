package collections;

import widetype.generator.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by 谢宇辉 on 2016/8/25 0025.
 */

class Government implements Generator<String> {

    String[] foudation = "strange women lying in ponds distributing swords is no basis for s system of government".split(" ");
    private int index;

    @Override
    public String next() {
        return foudation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15));//以构造器填充
        set.addAll(CollectionData.list(new Government(),15));//以Collection容器的addAll()方法填充
        System.out.println(set);
    }
}
