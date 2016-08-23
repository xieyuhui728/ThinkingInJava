package widetype.erased;

/**
 * Created by 谢宇辉 on 2016/8/22 0022.
 */
public class SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder =new SimpleHolder();
        holder.set("Item");
        String s = (String)holder.get();
    }
}
