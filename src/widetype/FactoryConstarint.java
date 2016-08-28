package widetype;

/**
 * Created by 谢宇辉 on 2016/8/23 0023.
 * InstantiateGenericType 的错误不是在编译期捕获的
 * Sun并不赞成这种方式，所以我们使用显示的工厂
 */
interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFacotry implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstarint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFacotry());
        new Foo2<Widget>(new Widget.Factory());
    }
}
