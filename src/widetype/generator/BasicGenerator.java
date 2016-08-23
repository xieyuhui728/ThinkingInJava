package widetype.generator;

/**
 * Created by 谢宇辉 on 2016/8/22 0022.
 * 这个程序可以为任何类构造一个Generator
 * 利用了泛型
 */
public class BasicGenerator<T> implements Generator<T> {
    private  Class<T> type;

    public BasicGenerator(Class<T> type){
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        }  catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
 }
