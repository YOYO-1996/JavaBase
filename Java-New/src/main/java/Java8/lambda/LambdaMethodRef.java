package Java8.lambda;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @description: lambda----重写函数式接口的方法
 * 如果有某个方法的参数列表和返回值与要重写的方法相同，则可直接使用已有的方法的引用
 * <p>
 * 使用格式：类（或对象）::调用的方法
 * 1.对象::非静态方法
 * 2.类::静态方法
 * 3.类::非静态方法
 * <p>
 * 接口中要重写的方法的
 * 形参列表和返回值类型
 * -----
 * 方法引用的方法的
 * 形参列表和返回值类型
 * <p>
 * 相同
 * @author: Tong
 * @date: 2020-07-14 12:59
 */
public class LambdaMethodRef {
    /**
     * 1
     * 初始lambda
     * Consumer中的accept方法： void accept(T t)
     * PrintStream种的 void println(T t)
     */
    @Test
    public void instance() {
        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("instance test");
        System.out.println("***************");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("method test");
    }

    /**
     * 2
     * Supplier 中 T get()
     * LambdaMethodRef 中 String getName()
     */
    @Test
    public void instanceMethod() {
        Supplier<String> supplier1 = () -> "o hu";
        System.out.println(supplier1.get());

        Supplier<String> supplier2 = LambdaMethodRef::ref;
        System.out.println(supplier2.get());

    }

    public static String ref() {
        return "test method ref";
    }

    public String ref2(String name) {
        return name;
    }

    /**
     * 3
     * 类::实例方法--形参1作为调用者
     * Comparator 中 int compare(T t1, T t2)
     * String 中 t1.compareTo(t2)
     * 第一个参数作为调用者
     * 第二个参数作为被调用者
     *
     * @return
     */
    public void test3() {
        Set<String> set = new TreeSet<>(String::compareTo);
    }
}
