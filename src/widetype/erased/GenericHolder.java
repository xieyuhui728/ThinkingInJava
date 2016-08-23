package widetype.erased;

import widetype.generator.Generator;

/**
 * Created by 谢宇辉 on 2016/8/22 0022.
 */
public class GenericHolder<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder =new GenericHolder<String>();
        holder.set("Item");
        String s = holder.get();
    }
}

