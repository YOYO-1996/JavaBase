package Java8.lambda;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @description: --重写函数式接口的方法
 * 左边形参列表，右边方法体
 * 总结：
 * ->左边：1.参数类型可以省略，2.只有一个参数，小括号可以省略
 * ->右边：只有一条语句，大括号可以省略
 * @author: Tong
 * @date: 2020-07-14 12:12
 */
public class LambdaBaseUse {
    /**
     * 1、无参，无返回值
     */
    @Test
    public void demo1() {
        new Thread(() -> System.out.println("first type demo")).run();
    }

    /**
     * 2、需要一个参数，无返回值----大括号可以省
     */
    @Test
    public void demo2() {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("second type demo");
    }


    /**
     * 3、需要一个参数，无返回值----一个参数，小括号可以省
     */
    @Test
    public void demo3() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("second type demo");
    }

    /**
     * 4、只有返回值，大括号可以省
     */
    @Test
    public void demo4() {
        Set<String> set = new TreeSet<>((a, b) -> a.compareTo(b));
    }

    /**
     * 5、方法里有语句，有返回值，大括号不可以省
     */
    @Test
    public void demo5() {
        Set<String> set = new TreeSet<>((a, b) -> {
            a = a + b;
            return a.compareTo(b);
        });
    }

}
