package widetype;

/**
 * Created by 谢宇辉 on 2016/8/23 0023.
 * java无法实现new T()，部分原因是因为擦除，另一部分原因是因为编译器不能验证T具有默认的构造器
 * 解决法案是传递一个工厂对象，引入类型标签，并使用它来创建新的实例。
 */

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        /**
         * 因为Integer没有默认构造器(无参构造器)
         */
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Employee> failed");
        }

    }
}
